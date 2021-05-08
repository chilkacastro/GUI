/*
 * The MIT License
 *
 * Copyright 2021 Chilka Castro.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package convertor;
import java.awt.Color;
/**
 * A menu of converters
 * @author Chilka Castro
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setForeground(Color.BLACK);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeB = new javax.swing.JButton();
        weightB = new javax.swing.JButton();
        lengthB = new javax.swing.JButton();
        tempB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        timeB.setFont(new java.awt.Font("DialogInput", 1, 16)); // NOI18N
        timeB.setForeground(new java.awt.Color(0, 102, 102));
        timeB.setText("Time Converter");
        timeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeBActionPerformed(evt);
            }
        });

        weightB.setFont(new java.awt.Font("DialogInput", 1, 16)); // NOI18N
        weightB.setForeground(new java.awt.Color(153, 51, 0));
        weightB.setText("Weight Converter");
        weightB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightBActionPerformed(evt);
            }
        });

        lengthB.setFont(new java.awt.Font("DialogInput", 1, 16)); // NOI18N
        lengthB.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        lengthB.setText("Length Converter");
        lengthB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lengthBActionPerformed(evt);
            }
        });

        tempB.setFont(new java.awt.Font("DialogInput", 1, 16)); // NOI18N
        tempB.setForeground(new java.awt.Color(101, 70, 39));
        tempB.setText("Temperature Converter");
        tempB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lengthB, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightB, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeB, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tempB, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(weightB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lengthB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(timeB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(tempB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Opens a weight converter and make the menu invisible
     * @param evt the event action
     */
    private void weightBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightBActionPerformed
        if (weightB.isFocusable())
            weightB.setForeground(Color.RED);
        new WeightConverter(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_weightBActionPerformed

    /**
     * Opens a length converter and make the menu invisible
     * @param evt the event action
     */
    private void lengthBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lengthBActionPerformed
        if (lengthB.isFocusable())
            lengthB.setForeground(Color.RED);
        new LengthConverter(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lengthBActionPerformed

    /**
     * Opens a temperature converter and make the menu invisible
     * @param evt the event action
     */
    private void tempBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempBActionPerformed
        if (tempB.isFocusable())
            tempB.setForeground(Color.RED);
        new TemperatureConverter(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tempBActionPerformed

    /**
     * Opens a time converter and make the menu invisible
     * @param evt the event action
     */
    private void timeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeBActionPerformed
        if (timeB.isFocusable())
            timeB.setForeground(Color.RED);
        new TimeConverter(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_timeBActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton lengthB;
    private javax.swing.JButton tempB;
    private javax.swing.JButton timeB;
    private javax.swing.JButton weightB;
    // End of variables declaration//GEN-END:variables
}