/*
 * ConfigFrame.java
 *
 * Created on 20. červenec 2007, 18:59
 */

package esmska;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import persistence.ConfigBean;

/**
 *
 * @author  ripper
 */
public class ConfigFrame extends javax.swing.JFrame {
    private ConfigBean config;
    
    /** Creates new form ConfigFrame */
    public ConfigFrame(ConfigBean config) {
        this.config = config;
        initComponents();
        useSenderIDCheckBoxActionPerformed(null);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_O);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_V);
        tabbedPane.setIconAt(0, new ImageIcon(this.getClass().getResource("resources/config-small.png")));
        tabbedPane.setIconAt(1, new ImageIcon(this.getClass().getResource("/operators/resources/Vodafone.png")));
        closeButton.requestFocusInWindow();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        rememberQueueCheckBox = new javax.swing.JCheckBox();
        rememberLayoutCheckBox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        useSenderIDCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        senderNumberTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        senderNameTextField = new javax.swing.JTextField();
        closeButton = new javax.swing.JButton();

        setTitle("Nastaven\u00ed");
        setIconImage(new ImageIcon(getClass().getResource("resources/esmska.png")).getImage());
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        rememberQueueCheckBox.setMnemonic('f');
        rememberQueueCheckBox.setSelected(config.isRememberQueue());
        rememberQueueCheckBox.setText("Ukl\u00e1dat frontu neodeslan\u00fdch sms");
        rememberQueueCheckBox.setToolTipText("<html>\nP\u0159i ukon\u010den\u00ed programu uchov\u00e1v\u00e1 frontu neodeslan\u00fdch sms pro p\u0159\u00ed\u0161t\u00ed spu\u0161t\u011bn\u00ed programu.\n</html>");
        rememberQueueCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rememberQueueCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberQueueCheckBoxActionPerformed(evt);
            }
        });

        rememberLayoutCheckBox.setMnemonic('r');
        rememberLayoutCheckBox.setSelected(config.isRememberLayout());
        rememberLayoutCheckBox.setText("Pamatovat rozvr\u017een\u00ed formul\u00e1\u0159e");
        rememberLayoutCheckBox.setToolTipText("<html>\nPou\u017eije aktu\u00e1ln\u00ed rozm\u011bry programu a prvk\u016f formul\u00e1\u0159e p\u0159i p\u0159\u00ed\u0161t\u00edm spu\u0161t\u011bn\u00ed programu.\n</html>");
        rememberLayoutCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rememberLayoutCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberLayoutCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rememberLayoutCheckBox)
                    .addComponent(rememberQueueCheckBox))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rememberLayoutCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rememberQueueCheckBox)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        tabbedPane.addTab("Obecn\u00e9", jPanel1);

        useSenderIDCheckBox.setMnemonic('p');
        useSenderIDCheckBox.setSelected(config.isUseSenderID());
        useSenderIDCheckBox.setText("P\u0159ipojovat podpis odesilatele");
        useSenderIDCheckBox.setToolTipText("<html>P\u0159i p\u0159ipojen\u00ed podpisu p\u0159ijde sms adres\u00e1tovi ze zadan\u00e9ho \u010d\u00edsla<br>\na s dan\u00fdm jm\u00e9nem napsan\u00fdm na konci zpr\u00e1vy.</html>");
        useSenderIDCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        useSenderIDCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useSenderIDCheckBoxActionPerformed(evt);
            }
        });

        jLabel1.setDisplayedMnemonic('l');
        jLabel1.setLabelFor(senderNumberTextField);
        jLabel1.setText("\u010c\u00edslo");

        jLabel2.setText("+420");

        senderNumberTextField.setColumns(9);
        senderNumberTextField.setText(config.getSenderNumber());
        senderNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senderNumberTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setDisplayedMnemonic('m');
        jLabel3.setLabelFor(senderNameTextField);
        jLabel3.setText("Jm\u00e9no");

        senderNameTextField.setText(config.getSenderName());
        senderNameTextField.setToolTipText("<html>P\u0159i vypln\u011bn\u00ed jm\u00e9na je p\u0159ipojeno na konec zpr\u00e1vy,<br>\ntak\u017ee je sms ve skute\u010dnosti o n\u011bco del\u0161\u00ed.</html>");
        senderNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senderNameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(useSenderIDCheckBox)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(senderNumberTextField))
                            .addComponent(senderNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
                .addGap(119, 119, 119))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(useSenderIDCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(senderNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(senderNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        tabbedPane.addTab("Vodafone", jPanel2);

        closeButton.setMnemonic('z');
        closeButton.setText("Zav\u0159\u00edt");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addComponent(closeButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rememberLayoutCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberLayoutCheckBoxActionPerformed
        config.setRememberLayout(rememberLayoutCheckBox.isSelected());
    }//GEN-LAST:event_rememberLayoutCheckBoxActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        senderNameTextFieldActionPerformed(null);
        senderNumberTextFieldActionPerformed(null);
    }//GEN-LAST:event_formWindowLostFocus
    
    private void senderNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senderNameTextFieldActionPerformed
        config.setSenderName(senderNameTextField.getText());
    }//GEN-LAST:event_senderNameTextFieldActionPerformed
    
    private void senderNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senderNumberTextFieldActionPerformed
        config.setSenderNumber(senderNumberTextField.getText());
    }//GEN-LAST:event_senderNumberTextFieldActionPerformed
    
    private void useSenderIDCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useSenderIDCheckBoxActionPerformed
        senderNameTextField.setEnabled(useSenderIDCheckBox.isSelected());
        senderNumberTextField.setEnabled(useSenderIDCheckBox.isSelected());
        config.setUseSenderID(useSenderIDCheckBox.isSelected());
    }//GEN-LAST:event_useSenderIDCheckBoxActionPerformed
    
    private void rememberQueueCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberQueueCheckBoxActionPerformed
        config.setRememberQueue(rememberQueueCheckBox.isSelected());
    }//GEN-LAST:event_rememberQueueCheckBoxActionPerformed
    
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        //close form
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox rememberLayoutCheckBox;
    private javax.swing.JCheckBox rememberQueueCheckBox;
    private javax.swing.JTextField senderNameTextField;
    private javax.swing.JTextField senderNumberTextField;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JCheckBox useSenderIDCheckBox;
    // End of variables declaration//GEN-END:variables
    
}
