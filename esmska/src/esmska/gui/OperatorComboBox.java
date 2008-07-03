/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package esmska.gui;

import esmska.data.Config;
import esmska.data.Icons;
import esmska.operators.Operator;
import esmska.operators.OperatorUtil;
import esmska.persistence.PersistenceManager;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.text.JTextComponent;

/** JComboBox showing available operators.
 *
 * @author ripper
 */
public class OperatorComboBox extends JComboBox {
    private static final String RES = "/esmska/resources/";
    private static final TreeSet<Operator> operators = PersistenceManager.getOperators();
    private static final Config config = PersistenceManager.getConfig();
    private static final OperatorComboBoxRenderer cellRenderer = new OperatorComboBoxRenderer();
    private DefaultComboBoxModel model = new DefaultComboBoxModel(operators.toArray());
    /** used only for non-existing operators */
    private String operatorName;
    
    public OperatorComboBox() {
        filterOperators();
        setModel(model);
        setRenderer(cellRenderer);
        setToolTipText("Seznam dostupných webových bran operátorů");
        if (model.getSize() > 0) {
            setSelectedIndex(0);
        }
        
        //add listener to operator filter patterns
        config.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (!"operatorFilter".equals(evt.getPropertyName())) {
                    return;
                }
                filterOperators();
                if (model.getSize() > 0) {
                    setSelectedIndex(0);
                }
            }
        });
    }
    
    /** Get selected operator in list or null if none selected. */
    public Operator getSelectedOperator() {
        return (Operator) getSelectedItem();
    }
    
    /** Get name of the selected operator. 
     * If unknown operator selected (selection cleared), it returns previously inserted
     * operator name (may be null).
     */
    public String getSelectedOperatorName() {
        return (getSelectedOperator() != null ? getSelectedOperator().getName() : operatorName);
    }
  
// Disabled, because it caused issues when selecting non-existing operator and
// getting the operator back after that. It changed the contact operator from
// unknown string to null.
//
//    /** Set currently selected operator.
//     * Use null for clearing the selection. Non-existing operator will not change the selection.
//     */
//    public void setSelectedOperator(Operator operator) {
//        operatorName = (operator != null ? operator.getName() : null);
//        setSelectedItem(operator);
//    }
    
    /** Set currently selected operator by it's name.
     * Use null for clearing the selection. Non-existing operator will also clear the selection.
     */
    public void setSelectedOperator(String operatorName) {
        this.operatorName = operatorName;
        Operator operator = OperatorUtil.getOperator(operatorName);
        if (model.getIndexOf(operator) < 0) {
            setSelectedItem(null);
        } else {
            setSelectedItem(operator);
        }
    }
    
    /** Select operator according to phone number or phone number prefix.
     * Searches through available (displayed) operators and selects the best
     * suited on supporting this phone number. Doesn't change selection if no 
     * such operator is found. Doesn't change selection if no operator prefix 
     * matched and operator with matching country prefix is already selected.
     * @param number phone number or it's prefix. The minimum length is two characters,
     *               for shorter input (or null) the method does nothing.
     */
    public void selectSuggestedOperator(String number) {
        TreeSet<Operator> visibleOperators = new TreeSet<Operator>();
        for (int i = 0; i < model.getSize(); i++) {
            Operator op = (Operator) model.getElementAt(i);
            visibleOperators.add(op);
        }
        
        Operator operator = OperatorUtil.suggestOperator(number, visibleOperators);
        
        //none suitable operator found, do nothing
        if (operator == null) {
            return;
        }
        
        //if perfect match found, select it
        if (OperatorUtil.matchesWithOperatorPrefix(operator, number)) {
            setSelectedOperator(operator.getName());
            return;
        }
        
        //return if already selected operator with matching country prefix
        Operator selectedOperator = getSelectedOperator();
        if (OperatorUtil.matchesWithCountryPrefix(selectedOperator, number)) {
            return;
        }
        
        //select suggested
        setSelectedOperator(operator.getName());
        
    }
          
    /** Get action to automatically select best suitable operator in this list
     * according to number filled in specified text component.
     * 
     * @param numberComponent Text component containing phone number
     * @return action to automatically select best suitable operator in this list
     * according to number filled in specified text component
     */
    public Action getSuggestOperatorAction(JTextComponent numberComponent) {
        SuggestOperatorAction action = new SuggestOperatorAction(this, numberComponent);
        return action;
    }
    
    /** Renderer for items in OperatorComboBox */
    private static class OperatorComboBoxRenderer extends DefaultListCellRenderer {
        private final ListCellRenderer lafRenderer = new JList().getCellRenderer();
        
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = lafRenderer.getListCellRendererComponent(list, value, 
                    index, isSelected, cellHasFocus);
            if (!(value instanceof Operator)) {
                return c;
            }
            JLabel label = (JLabel) c;
            Operator operator = (Operator)value;
            label.setText(operator != null ? operator.getName() : "Neznámý operátor");
            label.setIcon(operator != null ? operator.getIcon() : Icons.OPERATOR_BLANK);
            return label;
        }
    }
    
    /** Iterates through all operators and leaves in the model only those which
     * matches the user configured patterns
     */
    private void filterOperators() {
        model.removeAllElements();
        String[] patterns = config.getOperatorFilter().split(",");
        ArrayList<Operator> filtered = new ArrayList<Operator>();
        oper: for (Operator operator : operators.toArray(new Operator[0])) {
            for (String pattern : patterns) {
                if (operator.getName().contains(pattern)) {
                    filtered.add(operator);
                    continue oper;
                }
            }
        }
        for (Operator operator : filtered) {
            model.addElement(operator);
        }
    }
    
    /** Select suggested operator in the combobox */
    private class SuggestOperatorAction extends AbstractAction {
        private OperatorComboBox operatorComboBox;
        private JTextComponent numberComponent;
        
        public SuggestOperatorAction(OperatorComboBox operatorComboBox, JTextComponent numberComponent) {
            super("Zvolit vhodnou bránu", new ImageIcon(OperatorComboBox.class.getResource(RES + "search-22.png")));
            this.putValue(SHORT_DESCRIPTION, "Vybrat vhodnou bránu pro zadané číslo");
            
            if (operatorComboBox == null || numberComponent == null) {
                throw new IllegalArgumentException("Arguments cant be null");
            }
            
            this.operatorComboBox = operatorComboBox;
            this.numberComponent = numberComponent;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String number = numberComponent.getText();
            operatorComboBox.selectSuggestedOperator(number);
            operatorComboBox.requestFocusInWindow();
        }
    }
}
