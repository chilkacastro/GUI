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
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * A Length Converter Class
 * @author Chilka Castro
 */
public class LengthConverter extends javax.swing.JFrame {
    private Menu menu;

    /**
     * Constructor with menu data member
     * @param menu the input menu object
     */
    public LengthConverter(Menu menu) {
        initComponents();
        this.menu = menu;
        setVisibility();
        ImageIcon titleImg = new ImageIcon("imgs\\ruler.png");  
        imgL.setIcon(titleImg);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeBG = new javax.swing.ButtonGroup();
        titleL = new javax.swing.JLabel();
        inputUnitL = new javax.swing.JLabel();
        outputUnitL = new javax.swing.JLabel();
        equalL = new javax.swing.JLabel();
        inputTF = new javax.swing.JTextField();
        outputTF = new javax.swing.JTextField();
        mile2KmB = new javax.swing.JRadioButton();
        m2FtAndInB = new javax.swing.JRadioButton();
        ftAndIn2MB = new javax.swing.JRadioButton();
        km2MileB = new javax.swing.JRadioButton();
        submitB = new javax.swing.JButton();
        outputInTF = new javax.swing.JTextField();
        outputInUnitL = new javax.swing.JLabel();
        plusL = new javax.swing.JLabel();
        inputSL = new javax.swing.JSlider();
        imgL = new javax.swing.JLabel();
        inputInchSL = new javax.swing.JSlider();
        msgL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Length Converter");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        titleL.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        titleL.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        titleL.setText("Length Converter");

        inputUnitL.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        inputUnitL.setText("km");

        outputUnitL.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        outputUnitL.setText("mile");

        equalL.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        equalL.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        equalL.setText("=");

        inputTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputTFKeyReleased(evt);
            }
        });

        outputTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                outputTFKeyReleased(evt);
            }
        });

        modeBG.add(mile2KmB);
        mile2KmB.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        mile2KmB.setText("mile to km");
        mile2KmB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mile2KmBActionPerformed(evt);
            }
        });

        modeBG.add(m2FtAndInB);
        m2FtAndInB.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        m2FtAndInB.setText("meter to foot and inch");
        m2FtAndInB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2FtAndInBActionPerformed(evt);
            }
        });

        modeBG.add(ftAndIn2MB);
        ftAndIn2MB.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        ftAndIn2MB.setText("foot and inch to meter");
        ftAndIn2MB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftAndIn2MBActionPerformed(evt);
            }
        });

        modeBG.add(km2MileB);
        km2MileB.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        km2MileB.setSelected(true);
        km2MileB.setText("km to mile");
        km2MileB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                km2MileBActionPerformed(evt);
            }
        });

        submitB.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        submitB.setText("Submit");
        submitB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBActionPerformed(evt);
            }
        });

        outputInUnitL.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        outputInUnitL.setText("inch");

        plusL.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        plusL.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        plusL.setText("+");

        inputSL.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        inputSL.setMajorTickSpacing(25);
        inputSL.setMinorTickSpacing(5);
        inputSL.setPaintLabels(true);
        inputSL.setPaintTicks(true);
        inputSL.setValue(0);
        inputSL.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inputSLStateChanged(evt);
            }
        });

        inputInchSL.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        inputInchSL.setMajorTickSpacing(25);
        inputInchSL.setMinorTickSpacing(5);
        inputInchSL.setPaintLabels(true);
        inputInchSL.setPaintTicks(true);
        inputInchSL.setValue(0);
        inputInchSL.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inputInchSLStateChanged(evt);
            }
        });

        msgL.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        msgL.setForeground(new java.awt.Color(0, 0, 204));
        msgL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msgL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitB)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(m2FtAndInB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ftAndIn2MB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(km2MileB, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mile2KmB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputSL, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputInchSL, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputUnitL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(equalL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outputUnitL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(plusL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outputInTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(outputInUnitL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titleL)
                                .addGap(18, 18, 18)
                                .addComponent(imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(msgL, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(titleL)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUnitL)
                    .addComponent(outputUnitL)
                    .addComponent(equalL)
                    .addComponent(inputTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputInTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputInUnitL)
                    .addComponent(plusL))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(km2MileB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mile2KmB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(m2FtAndInB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftAndIn2MB))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputSL, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputInchSL, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(msgL, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitB)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Reads the user input, and convert the weight, then set the result in the 
     * output label.
     */
     public void convertLength() {
        try {
            // read from text field
            double input = Math.abs(Double.parseDouble(inputTF.getText())); 
            // kilometer to mile
            if (km2MileB.isSelected()) {
                outputTF.setText(String.format("%.2f", kmToMile(input)));
                msgL.setText(String.format("%.2f km  is equal to %.2f mile", 
                        input, kmToMile(input)));
                msgL.setVisible(true);
            }
            // mile to kilometer
            else if (mile2KmB.isSelected()) {
                outputTF.setText(String.format("%.2f", mileToKm(input)));
                msgL.setText(String.format("%.2f mile  is equal to %.2f km", 
                        input, mileToKm(input)));
                msgL.setVisible(true);
            }
            // meter TO feet & inch
            else if (m2FtAndInB.isSelected()) {
                double[] nums = mToFtAndIn(input);
                outputTF.setText(String.format("%.0f", nums[0]));
                outputInTF.setText(String.format("%.2f", nums[1]));
                msgL.setVisible(true);
                msgL.setText(String.format("%.2f meter is equal to %.2f feet "
                        + "and %.2f inches", input, nums[0], nums[1]));
            } 
            // feet & inch TO meter
            else {
                // read from input inch textfield | inside else cond. to avoid exception
                double inputInch = Math.abs(Double.parseDouble(outputTF.getText()));
                outputInTF.setText(String.format("%.2f", ftAndInToM(input, inputInch)));
                msgL.setText(String.format("%.2f feet and %.2f inches "
                        + "is equal to %.2f meters", input, inputInch,
                        ftAndInToM(input, inputInch)));
                msgL.setVisible(true);
            }  
        } catch (NumberFormatException e) {
            msgL.setVisible(true);
            msgL.setForeground(Color.RED);
            msgL.setBackground(Color.RED);
            msgL.setText("The input value is incorrect. Please try again.");
        }
    }
     
    /**
     * Sets input unit to km and output unit to mile
     * @param evt the event action
     */
    private void km2MileBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_km2MileBActionPerformed
        inputUnitL.setText("km");
        outputUnitL.setText("mile");
        equalL.setText("=");
        cleanTextField();
        setVisibility();
    }//GEN-LAST:event_km2MileBActionPerformed

    /**
     * Sets input unit to mile and output unit to km
     * @param evt the event action
     */
    private void mile2KmBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mile2KmBActionPerformed
        inputUnitL.setText("mile");
        outputUnitL.setText("km");
        equalL.setText("=");
        cleanTextField();
        setVisibility();
    }//GEN-LAST:event_mile2KmBActionPerformed
    
    /**
     * Edits visibility for km and mile
     */
    public final void setVisibility() {
        plusL.setVisible(false);
        outputInUnitL.setVisible(false);
        outputInTF.setVisible(false);
        msgL.setVisible(false);
        inputInchSL.setVisible(false);
        outputTF.setFocusable(false);
    }
    
    /**
     * Sets the input unit to meter equals to feet plus inch arrangement
     * @param evt the event action
     */
    private void m2FtAndInBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2FtAndInBActionPerformed
        inputUnitL.setText("m");
        outputUnitL.setText("ft");
        equalL.setText("=");
        plusL.setText("+");
        outputInUnitL.setText("in");
        inputInchSL.setVisible(false);
        outputTF.setFocusable(false);
        setVisibility2();
        cleanTextField();
    }//GEN-LAST:event_m2FtAndInBActionPerformed

    /**
     * Sets the input unit to feet plus inch equals meter arrangement
     * @param evt the event action
     */
    private void ftAndIn2MBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftAndIn2MBActionPerformed
        inputUnitL.setText("ft");
        outputUnitL.setText("in");
        outputInUnitL.setText("m");
        equalL.setText("+");
        inputInchSL.setVisible(true);                    
        outputTF.setFocusable(true);
        plusL.setText("=");
        setVisibility2();
        cleanTextField();
    }//GEN-LAST:event_ftAndIn2MBActionPerformed
    
    /**
     * Edits visibility when feet, inch and meter is selected
     */
    public void setVisibility2() {
        plusL.setVisible(true);
        outputInUnitL.setVisible(true);
        outputInTF.setVisible(true);
        msgL.setVisible(false);
        outputInTF.setFocusable(false);
        cleanTextField();
    }
    
    /**
     * Clean text fields
     */
    public void cleanTextField() {
        inputTF.setText("");
        outputTF.setText("");
        if (ftAndIn2MB.isSelected())
            outputInTF.setText("");
    }
    
    /**
     * Handles the submit event, do the conversion
     * @param evt the event action
     */
    private void submitBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBActionPerformed
        msgL.setBackground(Color.BLACK);
        msgL.setForeground(Color.BLUE);
        convertLength();
    }//GEN-LAST:event_submitBActionPerformed

    /**
     * Sets the menu frame visible again once the length converter window is closed
     * @param evt the event action
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        menu.setVisible(true);
    }//GEN-LAST:event_formWindowClosed
    
    /**
     * Updates the input text field when the slider value gets changed
     * @param evt the event action
     */
    private void inputSLStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inputSLStateChanged
        if (km2MileB.isSelected() || mile2KmB.isSelected() || m2FtAndInB.isSelected() 
                || ftAndIn2MB.isSelected()) 
            inputTF.setText(inputSL.getValue() + "");  
    }//GEN-LAST:event_inputSLStateChanged

    /**
     * Updates the inch input text field, named as outputTF because it is used 
     * as input when the radio button ft and inch equals to meter is selected
     * @param evt the event action
     */
    private void inputInchSLStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inputInchSLStateChanged
        if (ftAndIn2MB.isSelected())
            // outputTF here is the inputTF for the inch 
            outputTF.setText(inputInchSL.getValue() + "");
    }//GEN-LAST:event_inputInchSLStateChanged

    /**
     * Converts the values with enter key
     * @param evt the event action
     */
    private void inputTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTFKeyReleased
        msgL.setVisible(false);
        msgL.setBackground(Color.BLACK);
        msgL.setForeground(Color.BLUE);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            convertLength();
    }//GEN-LAST:event_inputTFKeyReleased
    
    /**
     * Converts the values with enter key
     * @param evt the event action
     */
    private void outputTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outputTFKeyReleased
        msgL.setVisible(false);
        msgL.setBackground(Color.BLACK);
        msgL.setForeground(Color.BLUE);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            convertLength();
    }//GEN-LAST:event_outputTFKeyReleased
 
    /**
     * Converts kilometer to mile
     * @param km the input km
     * @return the converted mile
     */
    public double kmToMile(double km) {
        final double kmToMileRatio = 0.621371;
        return km * kmToMileRatio; 
    }
    
    /**
     * Converts mile to kilometer
     * @param mile the input mile
     * @return the converted km
     */
    public double mileToKm(double mile) {
        final double mileToKmRatio = 1.60934;
        return mile * mileToKmRatio; 
    }
    
    /**
     * Converts meter to feet and inch
     * @param meter the input meter
     * @return an array containing the converted feet and inch 
     */
    public double[] mToFtAndIn(double meter) {
        final double mToFtRatio = 3.28084;
        final int fToInRatio = 12;
        double feet = Math.floor(meter * mToFtRatio);
        
        return new double[]{feet, meter * mToFtRatio % 1 * fToInRatio};   
    }
    
    /**
     * Convert feet and inch to meter
     * @param feet the input feet
     * @param inch the input inch
     * @return the converted meter
     */
    public double ftAndInToM(double feet, double inch) {
        final double ftToMRatio = 0.3048;
        final double inToMRatio = 0.0254;
        return feet * ftToMRatio + inch * inToMRatio; 
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel equalL;
    private javax.swing.JRadioButton ftAndIn2MB;
    private javax.swing.JLabel imgL;
    private javax.swing.JSlider inputInchSL;
    private javax.swing.JSlider inputSL;
    private javax.swing.JTextField inputTF;
    private javax.swing.JLabel inputUnitL;
    private javax.swing.JRadioButton km2MileB;
    private javax.swing.JRadioButton m2FtAndInB;
    private javax.swing.JRadioButton mile2KmB;
    private javax.swing.ButtonGroup modeBG;
    private javax.swing.JLabel msgL;
    private javax.swing.JTextField outputInTF;
    private javax.swing.JLabel outputInUnitL;
    private javax.swing.JTextField outputTF;
    private javax.swing.JLabel outputUnitL;
    private javax.swing.JLabel plusL;
    private javax.swing.JButton submitB;
    private javax.swing.JLabel titleL;
    // End of variables declaration//GEN-END:variables
}