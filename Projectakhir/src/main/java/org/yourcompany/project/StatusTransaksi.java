package org.yourcompany.project;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class StatusTransaksi extends JFrame {
    private JPanel jPanel2;
    private JLabel jLtitle10, jLtitle11, jLtitle12, jLtitle3, jLtitle6, jLtitle7, jLtitle8, jLtitle9;
    private JTextField jTextField1;
    private Font openSansFont;
    private JButton jBBack; // Declare the back button

    public StatusTransaksi() {
        loadCustomFont();  // Load the custom font
        initComponents();
    }

    private void loadCustomFont() {
        try {
            openSansFont = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\Github\\java-nice\\Projectakhir\\src\\main\\java\\org\\yourcompany\\project\\OpenSans-Regular.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(openSansFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        jPanel2 = new JPanel();
        jLtitle7 = new JLabel("Harga Paket");
        jLtitle6 = new JLabel("Tanggal");
        jLtitle9 = new JLabel("Harga Paket");
        jLtitle10 = new JLabel("Harga Paket");
        jLtitle11 = new JLabel("Harga Paket");
        jLtitle8 = new JLabel("Promo");
        jLtitle12 = new JLabel("Harga Paket");
        jLtitle3 = new JLabel("Status Transaksi");
        jTextField1 = new JTextField("Berhasil / Gagal");
        jBBack = new JButton("Kembali"); // Initialize the back button

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);
        jLtitle7.setBounds(60, 440, 190, 50);
        jLtitle6.setBounds(30, 90, 190, 40);
        jLtitle9.setBounds(290, 90, 190, 40);
        jLtitle10.setBounds(30, 10, 190, 40);
        jLtitle11.setBounds(290, 10, 190, 40);
        jLtitle8.setBounds(30, 50, 190, 40);
        jLtitle12.setBounds(290, 50, 190, 40);
        
        // Set custom font for labels
        jLtitle7.setFont(openSansFont);
        jLtitle6.setFont(openSansFont);
        jLtitle9.setFont(openSansFont);
        jLtitle10.setFont(openSansFont);
        jLtitle11.setFont(openSansFont);
        jLtitle8.setFont(openSansFont);
        jLtitle12.setFont(openSansFont);
        
        jPanel2.add(jLtitle7);
        jPanel2.add(jLtitle6);
        jPanel2.add(jLtitle9);
        jPanel2.add(jLtitle10);
        jPanel2.add(jLtitle11);
        jPanel2.add(jLtitle8);
        jPanel2.add(jLtitle12);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(60, 80, 510, 140);

        jLtitle3.setFont(openSansFont.deriveFont(24f));  // Set font for title
        jLtitle3.setHorizontalAlignment(SwingConstants.CENTER);
        jLtitle3.setBounds(80, 20, 470, 60);
        getContentPane().add(jLtitle3);

        jTextField1.setBackground(new java.awt.Color(255, 51 , 0));
        jTextField1.setFont(openSansFont);  // Set custom font for text field
        jTextField1.setForeground(new java.awt.Color(153, 255, 255));
        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setBounds(90, 260, 460, 60);
        jTextField1.addActionListener(evt -> jTextField1ActionPerformed(evt));
        getContentPane().add(jTextField1);

        jBBack.setFont(openSansFont); // Set custom font for back button
        jBBack.setBounds(90, 340, 150, 50); // Set position and size
        jBBack.addActionListener(evt -> backButtonActionPerformed(evt)); // Add action listener
        getContentPane().add(jBBack); // Add button to the frame

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Handle action event here
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Navigate back to the main menu or previous screen
        MenuUtama menuUtama = new MenuUtama();
        menuUtama.setVisible(true);
        this.dispose(); // Close the current window
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new StatusTransaksi().setVisible(true));
    }
}