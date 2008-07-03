/*
 * EditContactPanel.java
 *
 * Created on 26. červenec 2007, 11:50
 */

package esmska.gui;

import esmska.ThemeManager;
import esmska.data.Config;
import esmska.gui.FormChecker;
import esmska.data.Contact;
import esmska.persistence.PersistenceManager;
import java.awt.Color;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.jvnet.substance.SubstanceLookAndFeel;

/** Add new or edit current contact
 *
 * @author  ripper
 */
public class EditContactPanel extends javax.swing.JPanel {
    private static final Border fieldBorder = new JTextField().getBorder();
    private static final Border lineRedBorder = BorderFactory.createLineBorder(Color.RED);
    
    private Config config = PersistenceManager.getConfig();

    private Action suggestOperatorAction;
    /**
     * Creates new form EditContactPanel
     */
    public EditContactPanel() {
        initComponents();
        //if not Substance LaF, add clipboard popup menu to text components
        if (!config.getLookAndFeel().equals(ThemeManager.LAF.SUBSTANCE)) {
            ClipboardPopupMenu.register(nameTextField);
            ClipboardPopupMenu.register(numberTextField);
        }
        
        //set up button for suggesting operator
        suggestOperatorAction = operatorComboBox.getSuggestOperatorAction(numberTextField);
        suggestOperatorButton.setAction(suggestOperatorAction);
        suggestOperatorButton.setText(null);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameTextField = new javax.swing.JTextField();
        nameTextField.requestFocusInWindow();
        numberTextField = new javax.swing.JTextField() {
            @Override
            public String getText() {
                String text = super.getText();
                if (!text.startsWith("+"))
                text = config.getCountryPrefix() + text;
                return text;
            }
        }
        ;
        operatorComboBox = new esmska.gui.OperatorComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        suggestOperatorButton = new javax.swing.JButton();

        nameTextField.setToolTipText("Jméno kontaktu");
        nameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTextFieldFocusLost(evt);
            }
        });

        numberTextField.setColumns(13);
        numberTextField.setToolTipText("<html>\nTelefonní číslo kontaktu včetně předčíslí země.<br>\nPředčíslí země nemusí být vyplněno, pokud je nastaveno<br>\nvýchozí předčíslí země v nastavení programu.\n</html>");
        numberTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numberTextFieldFocusLost(evt);
            }
        });
        numberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numberTextFieldKeyReleased(evt);
            }
        });

        jLabel1.setDisplayedMnemonic('m');
        jLabel1.setLabelFor(nameTextField);
        jLabel1.setText("Jméno:");
        jLabel1.setToolTipText(nameTextField.getToolTipText());

        jLabel2.setDisplayedMnemonic('o');
        jLabel2.setLabelFor(numberTextField);
        jLabel2.setText("Číslo:");
        jLabel2.setToolTipText(numberTextField.getToolTipText());

        jLabel3.setDisplayedMnemonic('b');
        jLabel3.setLabelFor(operatorComboBox);
        jLabel3.setText("Brána:");
        jLabel3.setToolTipText(operatorComboBox.getToolTipText());

        suggestOperatorButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        suggestOperatorButton.putClientProperty(SubstanceLookAndFeel.FLAT_PROPERTY, Boolean.TRUE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(operatorComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suggestOperatorButton))
                    .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(numberTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(operatorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(suggestOperatorButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {nameTextField, numberTextField});

    }// </editor-fold>//GEN-END:initComponents
    
    /** Check if the form is valid */
    public boolean validateForm() {
        boolean valid = true;
        boolean focusTransfered = false;
        JComponent[] comps = new JComponent[] {nameTextField, numberTextField};
        for (JComponent c : comps) {
            valid = checkValid(c) && valid;
            if (!valid && !focusTransfered) {
                c.requestFocusInWindow();
                focusTransfered = true;
            }
        }
        return valid;
    }
    
    /** checks if component's content is valid */
    private boolean checkValid(JComponent c) {
        boolean valid = true;
        if (c == nameTextField) {
            valid = FormChecker.checkContactName(nameTextField.getText());
            updateBorder(c, valid);
        } else if (c == numberTextField) {
            valid = FormChecker.checkSMSNumber(numberTextField.getText());
            updateBorder(c, valid);
        }
        return valid;
    }
    
    /** sets highlighted border on non-valid components and regular border on valid ones */
    private void updateBorder(JComponent c, boolean valid) {
        if (valid) {
            c.setBorder(fieldBorder);
        } else {
            c.setBorder(lineRedBorder);
        }
    }
    
    private void numberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberTextFieldKeyReleased
        //guess operator
        operatorComboBox.selectSuggestedOperator(numberTextField.getText());
    }//GEN-LAST:event_numberTextFieldKeyReleased

    private void nameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFieldFocusLost
        checkValid(nameTextField);
    }//GEN-LAST:event_nameTextFieldFocusLost

    private void numberTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numberTextFieldFocusLost
        checkValid(numberTextField);
    }//GEN-LAST:event_numberTextFieldFocusLost
    
    /** Set contact to be edited or use null for new one */
    public void setContact(Contact contact) {
        if (contact == null) {
            nameTextField.setText(null);
            numberTextField.setText(config.getCountryPrefix());
            operatorComboBox.selectSuggestedOperator(numberTextField.getText());
        } else {
            nameTextField.setText(contact.getName());
            numberTextField.setText(contact.getNumber());
            operatorComboBox.setSelectedOperator(contact.getOperator());
        }
    }
    
    /** Get currently edited contact */
    public Contact getContact() {
        Contact c = new Contact();
        c.setName(nameTextField.getText());
        c.setNumber(numberTextField.getText());
        c.setOperator(operatorComboBox.getSelectedOperatorName());
        return c;
    }
    
    /** Improve focus etc. before displaying panel */
    public void prepareForShow() {
        nameTextField.requestFocusInWindow();
        nameTextField.selectAll();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField numberTextField;
    private esmska.gui.OperatorComboBox operatorComboBox;
    private javax.swing.JButton suggestOperatorButton;
    // End of variables declaration//GEN-END:variables
    
}
