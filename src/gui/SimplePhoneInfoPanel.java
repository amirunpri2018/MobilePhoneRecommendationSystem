/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import knowledge.Result;
import lib.Tools;

/**
 *
 * @author Woh
 */
public class SimplePhoneInfoPanel extends javax.swing.JPanel {

    private Result result;
    
    public SimplePhoneInfoPanel() {
        initComponents();
        setVisible(true);
    }
    
    public void setPhoneImage(Result result) {
        BufferedImage resize = Tools.resize(result.getBufferedImage(), 100);
        phoneImage.setIcon(new ImageIcon(resize));
    }
    
    public void setup(String brand, String phoneName, String price, Result result) {
        //add specific search result here
        brandLabel.setText("Brand: "+brand);
        nameLabel.setText("Name: "+phoneName);
        priceLabel.setText("Price: RM"+price);
        this.result = result;
        setPhoneImage(result);
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
        simpleInformationPanel = new javax.swing.JPanel();
        brandLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        detailButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(629, 193));
        setMinimumSize(new java.awt.Dimension(629, 193));
        setLayout(new java.awt.GridLayout());

        phoneImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smartphone-samsung-s8.jpg"))); // NOI18N
        phoneImage.setToolTipText("");
        add(phoneImage);

        simpleInformationPanel.setLayout(new java.awt.GridLayout(0, 1));

        brandLabel.setText("Brand: Samsung");
        simpleInformationPanel.add(brandLabel);

        nameLabel.setText("Name: S8");
        simpleInformationPanel.add(nameLabel);

        priceLabel.setText("Price: RM 1999");
        simpleInformationPanel.add(priceLabel);

        detailButton.setText("View Details");
        detailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailButtonActionPerformed(evt);
            }
        });
        simpleInformationPanel.add(detailButton);

        add(simpleInformationPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void detailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailButtonActionPerformed
        // TODO add your handling code here:
        DetailPhoneInfoFrame dpif = new DetailPhoneInfoFrame();
        dpif.setTitle(result.getMP().getFullName());
        DetailPhoneInfoPanel dpip = dpif.getDetailPhoneInfoPanel();
        dpip.setup(result); //put result as parameter
        dpif.setVisible(true);
    }//GEN-LAST:event_detailButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandLabel;
    private javax.swing.JButton detailButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel phoneImage;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JPanel simpleInformationPanel;
    // End of variables declaration//GEN-END:variables
}
