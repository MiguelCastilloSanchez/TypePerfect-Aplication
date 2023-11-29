
package com.cds.typeperfectapp.views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ViewPractice extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ViewPractice() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        labelImage = new javax.swing.JLabel();
        fieldPractice = new javax.swing.JTextField();
        buttonStop = new javax.swing.JButton();
        buttonMenu = new javax.swing.JButton();
        buttonStart = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelUserWordBefore = new javax.swing.JLabel();
        labelWordBefore = new javax.swing.JLabel();
        labelWordActual = new javax.swing.JLabel();
        labelCorrectIcon = new javax.swing.JLabel();
        labelIncorrectIcon = new javax.swing.JLabel();
        labelTimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelImage.setIcon(new javax.swing.ImageIcon("src/main/resources/rsz_manos_en_el_teclado.jpg")); // NOI18N

        buttonStop.setText("Parar");

        buttonMenu.setText("Menú");

        buttonStart.setText("Iniciar");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelUserWordBefore.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        labelUserWordBefore.setForeground(new java.awt.Color(102, 102, 102));
        labelUserWordBefore.setText("");

        labelWordBefore.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        labelWordBefore.setText("");

        labelWordActual.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        labelWordActual.setText("");

        labelCorrectIcon.setIcon(new javax.swing.ImageIcon("src/main/resources/correct.png")); // NOI18N

        labelIncorrectIcon.setIcon(new javax.swing.ImageIcon("src/main/resources/incorrect.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelUserWordBefore)
                    .addComponent(labelWordBefore))
                .addGap(72, 72, 72)
                .addComponent(labelCorrectIcon)
                .addGap(18, 18, 18)
                .addComponent(labelIncorrectIcon)
                .addGap(80, 80, 80))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(labelWordActual)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelWordBefore)
                        .addGap(40, 40, 40)
                        .addComponent(labelUserWordBefore))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelIncorrectIcon)
                            .addComponent(labelCorrectIcon))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(labelWordActual)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonStart)
                    .addComponent(buttonStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldPractice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonMenu)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(labelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonStart)
                                .addGap(66, 66, 66)
                                .addComponent(buttonStop)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonMenu)
                                .addGap(144, 144, 144)))))
                .addComponent(fieldPractice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>                        

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

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
            java.util.logging.Logger.getLogger(ViewPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPractice().setVisible(true);
            }
        });
    }

    public JButton getButtonMenu() {
        return buttonMenu;
    }

    public void setButtonMenu(JButton buttonMenu) {
        this.buttonMenu = buttonMenu;
    }

    public JButton getButtonStart() {
        return buttonStart;
    }

    public void setButtonStart(JButton buttonStart) {
        this.buttonStart = buttonStart;
    }

    public JButton getButtonStop() {
        return buttonStop;
    }

    public void setButtonStop(JButton buttonStop) {
        this.buttonStop = buttonStop;
    }

    public JTextField getFieldPractice() {
        return fieldPractice;
    }

    public void setFieldPractice(JTextField fieldPractice) {
        this.fieldPractice = fieldPractice;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JLabel getLabelCorrectIcon() {
        return labelCorrectIcon;
    }

    public void setLabelCorrectIcon(JLabel labelCorrectIcon) {
        this.labelCorrectIcon = labelCorrectIcon;
    }

    public JLabel getLabelImage() {
        return labelImage;
    }

    public void setLabelImage(JLabel labelImage) {
        this.labelImage = labelImage;
    }

    public JLabel getLabelIncorrectIcon() {
        return labelIncorrectIcon;
    }

    public void setLabelIncorrectIcon(JLabel labelIncorrectIcon) {
        this.labelIncorrectIcon = labelIncorrectIcon;
    }

    public JLabel getLabelUserWordBefore() {
        return labelUserWordBefore;
    }

    public void setLabelUserWordBefore(JLabel labelUserWordBefore) {
        this.labelUserWordBefore = labelUserWordBefore;
    }

    public JLabel getLabelWordActual() {
        return labelWordActual;
    }

    public void setLabelWordActual(JLabel labelWordActual) {
        this.labelWordActual = labelWordActual;
    }

    public JLabel getLabelWordBefore() {
        return labelWordBefore;
    }

    public void setLabelWordBefore(JLabel labelWordBefore) {
        this.labelWordBefore = labelWordBefore;
    }

    public JLabel getLabelTimer() {
        return labelTimer;
    }

    public void setLabelTimer(JLabel labelTimer) {
        this.labelTimer = labelTimer;
    }
    
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton buttonMenu;
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonStop;
    private javax.swing.JTextField fieldPractice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCorrectIcon;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelIncorrectIcon;
    private javax.swing.JLabel labelTimer;
    private javax.swing.JLabel labelUserWordBefore;
    private javax.swing.JLabel labelWordActual;
    private javax.swing.JLabel labelWordBefore;
    // End of variables declaration                   
}
