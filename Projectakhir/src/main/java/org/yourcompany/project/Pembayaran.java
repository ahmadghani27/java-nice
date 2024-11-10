package org.yourcompany.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Pembayaran extends JFrame {

    private Font openSansFont;

    public Pembayaran() {
        loadCustomFont();
        initComponents();
    }

    private void loadCustomFont() {
        try {
            openSansFont = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\Github\\java-nice\\Projectakhir\\src\\main\\java\\org\\yourcompany\\project\\OpenSans-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(openSansFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();
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
        jLtitle2.setBounds(80, 20, 470, 60);
        getContentPane().add(jLtitle2);
        JLabel jLtitle3 = new JLabel("Paket Listrik:");
        JComboBox<String> jComboBox1 = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"});
        JLabel jLtitle4 = new JLabel("Metode Pembayaran ");
        JTextField jTextField1 = new JTextField("jTextField1");
        JPanel jPanel2 = new JPanel();
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

        jPanel1.setPreferredSize(new java.awt.Dimension(510, 180));
        jPanel1.setLayout(null);
        buttonGroup.add(jToggleButton4);
        buttonGroup.add(jToggleButton5);
        buttonGroup.add(jToggleButton3);
        buttonGroup.add(jToggleButton7);
        buttonGroup.add(jToggleButton8);
        buttonGroup.add(jToggleButton6);
        buttonGroup.add(jToggleButton9);
        buttonGroup.add(jToggleButton10);
        buttonGroup.add(jToggleButton11);

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
        getContentPane().add(jLtitle3).setBounds(60, 70, 510, 40);

        jComboBox1.setBackground(Color.WHITE); // Set the background color to white
        jComboBox1.setFont(openSansFont.deriveFont(16f)); // Set the font
        // Create a custom renderer for the JComboBox
        jComboBox1.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBorder(BorderFactory.createEmptyBorder(2, 16, 2, 16)); // Set padding
                return label;
            }
        });

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
        jBinputID.setFont(openSansFont.deriveFont(32f));
        jBinputID.setForeground(new java.awt.Color(255, 255, 255));
        jBinputID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        getContentPane().add(jBinputID).setBounds(350, 580, 220, 60);

        // Set custom fonts for components
        jLtitle2.setFont(openSansFont.deriveFont(28f)); // Title font size
        jLtitle3.setFont(openSansFont.deriveFont(20f)); // Subtitle font size
        jLtitle4.setFont(openSansFont.deriveFont(16f)); // Method of payment font size
        jLtitle5.setFont(openSansFont.deriveFont(16f)); // Promo code font size
        jLtitle6.setFont(openSansFont.deriveFont(16f)); // Promo font size
        jLtitle8.setFont(openSansFont.deriveFont(16f)); // Total payment font size
        jLtitle9.setFont(openSansFont.deriveFont(16f)); // Package price font size
        jLtitle10.setFont(openSansFont.deriveFont(16f)); // Package price font size
        jLtitle11.setFont(openSansFont.deriveFont(16f)); // Package price font size
        jTextField1.setFont(openSansFont.deriveFont(24f)); // Package price font size
        jTextField3.setFont(openSansFont.deriveFont(24f)); // Package price font size
        jToggleButton4.setFont(openSansFont.deriveFont(16f));
        jToggleButton5.setFont(openSansFont.deriveFont(16f));
        jToggleButton3.setFont(openSansFont.deriveFont(16f));
        jToggleButton7.setFont(openSansFont.deriveFont(16f));
        jToggleButton8.setFont(openSansFont.deriveFont(16f));
        jToggleButton6.setFont(openSansFont.deriveFont(16f));
        jToggleButton9.setFont(openSansFont.deriveFont(16f));
        jToggleButton10.setFont(openSansFont.deriveFont(16f));
        jToggleButton11.setFont(openSansFont.deriveFont(16f));

        jToggleButton4.setBackground(new Color(153, 255, 153));
        jToggleButton5.setBackground(new Color(153, 255, 153));
        jToggleButton3.setBackground(new Color(153, 255, 153));
        jToggleButton7.setBackground(new Color(153, 255, 153));
        jToggleButton8.setBackground(new Color(153, 255, 153));
        jToggleButton6.setBackground(new Color(153, 255, 153));
        jToggleButton9.setBackground(new Color(153, 255, 153));
        jToggleButton10.setBackground(new Color(153, 255, 153));
        jToggleButton11.setBackground(new Color(153, 255, 153));

        jTextField1.setMargin(new Insets(2, 16, 2, 16));
        jTextField1.setCaretColor(new Color(0, 153, 0));

        jTextField3.setMargin(new Insets(2, 16, 2, 16));
        jTextField3.setCaretColor(new Color(0, 153, 0));
        jTextField3.setEditable(false);
        jTextField3.setBackground(Color.WHITE);

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
