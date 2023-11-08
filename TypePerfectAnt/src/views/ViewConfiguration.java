/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 *
 * @author Miguel
 */
public class ViewConfiguration extends javax.swing.JFrame {
    
    /**
     * Creates new form ViewParameters
     */
    public ViewConfiguration() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupHands = new javax.swing.ButtonGroup();
        groupLanguage = new javax.swing.ButtonGroup();
        groupTime = new javax.swing.ButtonGroup();
        buttonBoth = new javax.swing.JToggleButton();
        buttonRight = new javax.swing.JToggleButton();
        buttonLeft = new javax.swing.JToggleButton();
        buttonNext = new javax.swing.JButton();
        labelLanguage = new javax.swing.JLabel();
        buttonEs = new javax.swing.JRadioButton();
        buttonEn = new javax.swing.JRadioButton();
        labelTime = new javax.swing.JLabel();
        button30Seg = new javax.swing.JRadioButton();
        button1Min = new javax.swing.JRadioButton();
        button5Min = new javax.swing.JRadioButton();
        labelHands = new javax.swing.JLabel();
        buttonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        groupHands.add(buttonBoth);
        buttonBoth.setIcon(new javax.swing.ImageIcon("/resources/ambas_manos.png")); // NOI18N

        groupHands.add(buttonRight);
        buttonRight.setIcon(new javax.swing.ImageIcon("/resources/mano_derecha.png")); // NOI18N
        buttonRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRightActionPerformed(evt);
            }
        });

        groupHands.add(buttonLeft);
        buttonLeft.setIcon(new javax.swing.ImageIcon("/resources/mano_izquierda.png")); // NOI18N

        buttonNext.setText("Siguiente");
        buttonNext.setToolTipText("");

        labelLanguage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelLanguage.setText("Elige el idioma en el que quieres realizar la prueba:");

        groupLanguage.add(buttonEs);
        buttonEs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonEs.setText("Español");

        groupLanguage.add(buttonEn);
        buttonEn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonEn.setText("Ingles");

        labelTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTime.setText("Elige en intervalo de tiempo por el cual quieres realizar la prueba:");

        groupTime.add(button30Seg);
        button30Seg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button30Seg.setText("30 seg");

        groupTime.add(button1Min);
        button1Min.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button1Min.setText("1 min");

        groupTime.add(button5Min);
        button5Min.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button5Min.setText("5 min");

        labelHands.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelHands.setText("Elige el tipo de prueba que quieres realizar:");

        buttonBack.setText("Atras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(buttonEs)
                                .addGap(121, 121, 121)
                                .addComponent(buttonEn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(button30Seg)
                                .addGap(116, 116, 116)
                                .addComponent(button1Min)
                                .addGap(177, 177, 177)
                                .addComponent(button5Min))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelHands)
                                    .addComponent(labelTime)
                                    .addComponent(labelLanguage)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(buttonBoth, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(buttonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelHands)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonBoth, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(labelLanguage)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEs)
                    .addComponent(buttonEn))
                .addGap(42, 42, 42)
                .addComponent(labelTime)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button30Seg)
                    .addComponent(button1Min)
                    .addComponent(button5Min))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRightActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewConfiguration().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton button1Min;
    private javax.swing.JRadioButton button30Seg;
    private javax.swing.JRadioButton button5Min;
    private javax.swing.JButton buttonBack;
    private javax.swing.JToggleButton buttonBoth;
    private javax.swing.JToggleButton buttonLeft;
    private javax.swing.JButton buttonNext;
    private javax.swing.JToggleButton buttonRight;
    private javax.swing.ButtonGroup groupHands;
    private javax.swing.ButtonGroup groupLanguage;
    private javax.swing.ButtonGroup groupTime;
    private javax.swing.JLabel labelHands;
    private javax.swing.JLabel labelLanguage;
    private javax.swing.JLabel labelTime;
    private javax.swing.JRadioButton buttonEn;
    private javax.swing.JRadioButton buttonEs;
    // End of variables declaration//GEN-END:variables
    
    public JRadioButton getButton1Min() {
        return button1Min;
    }

    public void setButton1Min(JRadioButton button1Min) {
        this.button1Min = button1Min;
    }

    public JRadioButton getButton30Seg() {
        return button30Seg;
    }

    public void setButton30Seg(JRadioButton button30Seg) {
        this.button30Seg = button30Seg;
    }

    public JRadioButton getButton5Min() {
        return button5Min;
    }

    public void setButton5Min(JRadioButton button5Min) {
        this.button5Min = button5Min;
    }
    
    public JButton getButtonBack() {
        return buttonBack;
    }

    public void setButtonBack(JButton buttonBack) {
        this.buttonBack = buttonBack;
    }

    public JToggleButton getButtonBoth() {
        return buttonBoth;
    }

    public void setButtonBoth(JToggleButton buttonBoth) {
        this.buttonBoth = buttonBoth;
    }

    public JToggleButton getButtonLeft() {
        return buttonLeft;
    }

    public void setButtonLeft(JToggleButton buttonLeft) {
        this.buttonLeft = buttonLeft;
    }

    public JButton getButtonNext() {
        return buttonNext;
    }

    public void setButtonNext(JButton buttonNext) {
        this.buttonNext = buttonNext;
    }

    public JToggleButton getButtonRight() {
        return buttonRight;
    }

    public void setButtonRight(JToggleButton buttonRight) {
        this.buttonRight = buttonRight;
    }

    public ButtonGroup getGroupHands() {
        return groupHands;
    }

    public void setGroupHands(ButtonGroup groupHands) {
        this.groupHands = groupHands;
    }

    public ButtonGroup getGroupLanguage() {
        return groupLanguage;
    }

    public void setGroupLanguage(ButtonGroup groupLanguage) {
        this.groupLanguage = groupLanguage;
    }

    public ButtonGroup getGroupTime() {
        return groupTime;
    }

    public void setGroupTime(ButtonGroup groupTime) {
        this.groupTime = groupTime;
    }

    public JLabel getLabelHands() {
        return labelHands;
    }

    public void setLabelHands(JLabel labelHands) {
        this.labelHands = labelHands;
    }

    public JLabel getLabelLanguage() {
        return labelLanguage;
    }

    public void setLabelLanguage(JLabel labelLanguage) {
        this.labelLanguage = labelLanguage;
    }

    public JLabel getLabelTime() {
        return labelTime;
    }

    public void setLabelTime(JLabel labelTime) {
        this.labelTime = labelTime;
    }

    public JRadioButton getbuttonEn() {
        return buttonEn;
    }

    public void setbuttonEn(JRadioButton radioButtonEn) {
        this.buttonEn = radioButtonEn;
    }

    public JRadioButton getbuttonEs() {
        return buttonEs;
    }

    public void setbuttonEs(JRadioButton radioButtonEs) {
        this.buttonEs = radioButtonEs;
    }
    
}
    
