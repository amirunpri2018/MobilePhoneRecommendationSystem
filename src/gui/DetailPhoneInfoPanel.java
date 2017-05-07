/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.ImageIcon;
import knowledge.Information;
import knowledge.Result;

/**
 *
 * @author Woh
 */
public class DetailPhoneInfoPanel extends javax.swing.JPanel {

    /**
     * Creates new form DetailPhoneInfoPanel
     */
    public DetailPhoneInfoPanel() {
        initComponents();
    }
    
    public void setPhoneImage(Result result) {
        phoneImage.setIcon(new ImageIcon(result.getBufferedImage()));
    }
    
    public void addInformation(Result result) {
        informationPanel.removeAll();
        informationPanel.add(new SingleInformationPanel(result.getInformations()));
    }
    
    public void setup(Result result) {
//        setPhoneImage(result);
//        addInformation(result);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phoneImage = new javax.swing.JLabel();
        informationPanel = new javax.swing.JPanel();

        phoneImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartphone-samsung-s8.jpg"))); // NOI18N

        informationPanel.setLayout(new java.awt.GridLayout(0, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(phoneImage, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(phoneImage, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
            .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel informationPanel;
    private javax.swing.JLabel phoneImage;
    // End of variables declaration//GEN-END:variables

}
