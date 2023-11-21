package com.cds.typeperfectapp.views;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ViewResults extends javax.swing.JFrame {

    /**
     * Creates new form ViewLogs
     */
    public ViewResults() {
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

        buttonBack = new javax.swing.JButton();
        labelResults = new javax.swing.JLabel();
        labelTitleCorrectWords = new javax.swing.JLabel();
        labelTitleTotalWords = new javax.swing.JLabel();
        labelHands3 = new javax.swing.JLabel();
        buttonAccept = new javax.swing.JButton();
        labelTitlePercentage = new javax.swing.JLabel();
        labelTotalWords = new javax.swing.JLabel();
        labelCorrectWords = new javax.swing.JLabel();
        labelPercentage = new javax.swing.JLabel();

        buttonBack.setText("Atras");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelResults.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelResults.setText("Resultado de la prueba anterior:");

        labelTitleCorrectWords.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTitleCorrectWords.setText("Palabras correctas:");

        labelTitleTotalWords.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTitleTotalWords.setText("Palabras escritas:");

        labelHands3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        buttonAccept.setText("Aceptar");
        buttonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcceptActionPerformed(evt);
            }
        });

        labelTitlePercentage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTitlePercentage.setText("Has acertado:");

        labelTotalWords.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTotalWords.setText("0");

        labelCorrectWords.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCorrectWords.setText("0");

        labelPercentage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPercentage.setText("0%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelResults))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitleTotalWords)
                    .addComponent(labelTitleCorrectWords))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCorrectWords)
                    .addComponent(labelTotalWords))
                .addGap(0, 331, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTitlePercentage)
                    .addComponent(labelHands3))
                .addGap(18, 18, 18)
                .addComponent(labelPercentage)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelResults)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitlePercentage)
                    .addComponent(labelPercentage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitleTotalWords)
                    .addComponent(labelTotalWords))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitleCorrectWords)
                    .addComponent(labelCorrectWords))
                .addGap(31, 31, 31)
                .addComponent(labelHands3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(buttonAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcceptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAcceptActionPerformed

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
            java.util.logging.Logger.getLogger(ViewResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewResults().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonBack;
    private javax.swing.JLabel labelCorrectWords;
    private javax.swing.JLabel labelHands3;
    private javax.swing.JLabel labelPercentage;
    private javax.swing.JLabel labelResults;
    private javax.swing.JLabel labelTitleCorrectWords;
    private javax.swing.JLabel labelTitlePercentage;
    private javax.swing.JLabel labelTitleTotalWords;
    private javax.swing.JLabel labelTotalWords;
    // End of variables declaration//GEN-END:variables

    public JButton getButtonAccept() {
        return buttonAccept;
    }

    public JLabel getLabelTotalWords() {
        return labelTotalWords;
    }

    public void setLabelTotalWords(JLabel labelTotalWords) {
        this.labelTotalWords = labelTotalWords;
    }

    public JLabel getLabelCorrectWords() {
        return labelCorrectWords;
    }

    public void setLabelCorrectWords(JLabel labelCorrectWords) {
        this.labelCorrectWords = labelCorrectWords;
    }

    public JLabel getLabelPercentage() {
        return labelPercentage;
    }

    public void setLabelPercentage(JLabel labelPercentage) {
        this.labelPercentage = labelPercentage;
    }
}
