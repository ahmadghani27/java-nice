package org.yourcompany.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pembayaran extends JFrame {
    public Pembayaran() {
        initComponents();
    }

    private void initComponents() {
        JTextField jTextField2 = new JTextField("jTextField2");
        JPanel jPanel1 = new JPanel();
        JToggleButton jToggleButton3 = new JToggleButton("jToggleButton1");
        JToggleButton jToggleButton4 = new JToggleButton("jToggleButton1");
        JToggleButton jToggleButton5 = new JToggleButton("jToggleButton1");
        JToggleButton jToggleButton6 = new JToggleButton("jToggleButton1");
        JToggleButton jToggleButton7 = new JToggleButton("jToggleButton1");
        JToggleButton jToggleButton8 = new JToggleButton("jToggleButton1");
        JToggleButton jToggleButton9 = new JToggleButton("jToggleButton1");
        JToggleButton jToggleButton10 = new JToggleButton("jToggleButton1");
        JToggleButton jToggleButton11 = new JToggleButton("jToggleButton1");
        JLabel jLtitle2 = new JLabel("Beli Token Listrik", SwingConstants.CENTER);
        JLabel jLtitle3 = new JLabel("Paket Listrik:");
        JComboBox<String> jComboBox1 = new JComboBox<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" });
        JLabel jLtitle4 = new JLabel("Metode Pembayaran ");
        JTextField jTextField1 = new JTextField("jTextField1");
        JPanel jPanel2 = new JPanel();
        JLabel jLtitle7 = new JLabel("Harga Paket");
        JLabel jLtitle6 = new JLabel("Promo");
        JLabel jLtitle9 = new JLabel("Harga Paket", SwingConstants.RIGHT);
        JLabel jLtitle10 = new JLabel("Harga Paket");
        JLabel jLtitle11 = new JLabel("Harga Paket", SwingConstants.RIGHT);
        JLabel jLtitle5 = new JLabel("Kode Promo");
        JLabel jLtitle8 = new JLabel("Total Pembayaran");
        JTextField jTextField3 = new JTextField("jTextField3");
        JButton jBinputID = new JButton("Bayar");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(510, 174));
        jPanel1.setLayout(null);
        jPanel1.add(jToggleButton4).setBounds(0, 0, 170, 60);
        jPanel1.add(jToggleButton5).setBounds(170, 0, 170, 60);
        jPanel1.add(jToggleButton3).setBounds(340, 0, 170, 60);
        jPanel1.add(jToggleButton7).setBounds(0, 60, 170, 60);
        jPanel1.add(jToggleButton8).setBounds(170, 60, 170, 60);
        jPanel1.add(jToggleButton6).setBounds(340, 60, 170, 60);
        jPanel1.add(jToggleButton9).setBounds(0, 120, 170, 60);
        jPanel1.add(jToggleButton10).setBounds(170, 120, 170, 60);
        jPanel1.add(jToggleButton11).setBounds(340, 120, 170, 60);
        getContentPane().add(jPanel1).setBounds(60, 110, 510, 190);
        getContentPane().add(jLtitle2).setBounds(80, 20, 470, 60);
        getContentPane().add(jLtitle3).setBounds(60, 70, 510, 40);
        getContentPane().add(jComboBox1).setBounds(250, 320, 320, 50);
        getContentPane().add(jLtitle4).setBounds(60, 320, 190, 50);
        getContentPane().add(jTextField1).setBounds(250, 380, 320, 50);
        jPanel2.setLayout(null);
        jPanel2.add(jLtitle6).setBounds(30, 50, 190, 40);
        jPanel2.add(jLtitle9).setBounds(290, 50, 190, 40);
        jPanel2.add(jLtitle10).setBounds(30, 10, 190, 40);
        jPanel2.add(jLtitle11).setBounds(290, 10, 190, 40);
 getContentPane().add(jPanel2).setBounds(60, 480, 510, 100);
        getContentPane().add(jLtitle5).setBounds(60, 380, 190, 50);
        getContentPane().add(jLtitle8).setBounds(60, 440, 190, 50);
        getContentPane().add(jTextField3).setBounds(60, 580, 290, 60);
        jBinputID.setBackground(new java.awt.Color(0, 204, 0));
        jBinputID.setFont(new java.awt.Font("SansSerif", 0, 32));
        jBinputID.setForeground(new java.awt.Color(255, 255, 255));
        jBinputID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        getContentPane().add(jBinputID).setBounds(350, 580, 220, 60);

        jBinputID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBinputIDActionPerformed(evt);
            }
        });

        pack();
    }

    private void jBinputIDActionPerformed(ActionEvent evt) {
        // TODO add your handling code here
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembayaran().setVisible(true);
            }
        });
    }
}