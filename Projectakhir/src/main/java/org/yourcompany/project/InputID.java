package org.yourcompany.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InputID extends JFrame {

    private JPanel jPanel1;
    private JTextField jTFinputID;
    private JButton jBinputID;
    private JLabel jLtitle1, jLInput;
    private Font openSans;

    public InputID() {
        initComponents();
        setupActions();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jTFinputID = new JTextField();
        jBinputID = new JButton();
        jLtitle1 = new JLabel();
        jLInput = new JLabel();

        // Load custom font
        loadCustomFont();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(640, 720));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        jPanel1.setForeground(new Color(51, 0, 102));

        jTFinputID.setFont(openSans.deriveFont(36f));
        jTFinputID.setHorizontalAlignment(JTextField.CENTER);
        jTFinputID.setBorder(BorderFactory.createLineBorder(new Color(51, 0, 153), 1, true));
        jTFinputID.setCaretColor(new Color(51, 0, 255));
        jTFinputID.setMargin(new Insets(8, 8, 8, 8));
        jPanel1.add(jTFinputID);
        jTFinputID.setBounds(74, 41, 450, 75);

        jBinputID.setBackground(new Color(51, 153, 255));
        jBinputID.setFont(openSans.deriveFont(32f));
        jBinputID.setForeground(Color.WHITE);
        jBinputID.setText("Enter");
        jBinputID.addActionListener(evt -> jBinputIDActionPerformed(evt));
        jPanel1.add(jBinputID);
        jBinputID.setBounds(74, 147, 450, 55);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 120, 600, 250);

        jLtitle1.setFont(openSans.deriveFont(48f));
        jLtitle1.setHorizontalAlignment(SwingConstants.CENTER);
        jLtitle1.setText("Input ID Meteran");
        getContentPane().add(jLtitle1);
        jLtitle1.setBounds(80, 50, 470, 60);

        jLInput.setFont(openSans.deriveFont(12f));
        jLInput.setForeground(Color.RED);
        jLInput.setText("Input tidak valid");
        jLInput.setVisible(false);
        jPanel1.add(jLInput);
        jLInput.setBounds(80, 115, 440, 15);

        pack();
    }

    private void loadCustomFont() {
        try {
            openSans = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\\\Github\\\\java-nice\\\\Projectakhir\\\\src\\\\main\\\\java\\\\org\\\\yourcompany\\\\project\\\\OpenSans-Regular.ttf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(openSans);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private void setupActions() {
        jTFinputID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTFinputID.getText().length() >= 10) {
                    e.consume(); // Limit input to 10 characters
                }
                if (jTFinputID.getText().length() < 11) {
                    jTFinputID.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                    jLInput.setVisible(true);
                } else {
                    jTFinputID.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    jLInput.setVisible(false);
                }
            }
        });
    }

    private void jBinputIDActionPerformed(java.awt.event.ActionEvent evt) {
        MenuUtama menuUtama = new MenuUtama();
        menuUtama.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new InputID().setVisible(true));
    }
}