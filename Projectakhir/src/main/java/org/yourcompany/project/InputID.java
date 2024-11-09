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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InputID extends JFrame {

    private JPanel jPanel1;
    private JTextField jTFinputID;
    private JButton jBinputID;
    private JLabel jLtitle1, jLInput;
    private Font openSans;

    private static final String URL = "jdbc:mysql://localhost:3306/DataBaseIanKonter";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public InputID() {
        initComponents();
        setupActions();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jTFinputID = new JTextField();
        jBinputID = new JButton("Enter");
        jLtitle1 = new JLabel("Input ID Meteran", SwingConstants.CENTER);
        jLInput = new JLabel("Input tidak valid", JLabel.CENTER);
        loadCustomFont();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(640, 720));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        jTFinputID.setFont(openSans.deriveFont(36f));
        jTFinputID.setHorizontalAlignment(JTextField.CENTER);
        jTFinputID.setBorder(BorderFactory.createLineBorder(new Color(51, 0, 153), 1));
        jTFinputID.setMargin(new Insets(8, 8, 8, 8));
        jTFinputID.setBounds(74, 41, 450, 75);
        jPanel1.add(jTFinputID);

        jBinputID.setBackground(new Color(51, 153, 255));
        jBinputID.setFont(openSans.deriveFont(32f));
        jBinputID.setForeground(Color.WHITE);
        jBinputID.setBounds(74, 147, 450, 55);
        jBinputID.addActionListener(evt -> ActionMenu());
        jPanel1.add(jBinputID);

        jPanel1.setBounds(20, 120, 600, 250);
        getContentPane().add(jPanel1);

        jLtitle1.setFont(openSans.deriveFont(48f));
        jLtitle1.setBounds(80, 50, 470, 60);
        getContentPane().add(jLtitle1);

        jLInput.setFont(openSans.deriveFont(12f));
        jLInput.setForeground(Color.RED);
        jLInput.setVisible(false);
        jLInput.setBounds(30, 115, 440, 15);
        jPanel1.add(jLInput);

        pack();
    }

    private void loadCustomFont() {
        try {
            openSans = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\Github\\java-nice\\Projectakhir\\src\\main\\java\\org\\yourcompany\\project\\OpenSans-Regular.ttf")).deriveFont(18f);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(openSans);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private void setupActions() {
        jTFinputID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTFinputID.getText().length() >= 11) {
                    e.consume();
                }
                jTFinputID.setBorder(BorderFactory.createLineBorder(jTFinputID.getText().length() < 11 ? Color.RED : Color.GRAY, 1));
                jLInput.setVisible(jTFinputID.getText().length() < 11);
            }
        });
    }
    

    private void ActionMenu() {
        String inputID = jTFinputID.getText();

        if (inputID.length() == 11) {
            String checkQuery = "SELECT COUNT(*) FROM id_pelanggan WHERE ID_Pelanggan = ?";
            String insertQuery = "INSERT INTO id_pelanggan (ID_Pelanggan) VALUES (?)";

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement checkStmt = connection.prepareStatement(checkQuery); PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {

                checkStmt.setString(1, inputID);
                ResultSet resultSet = checkStmt.executeQuery();

                if (resultSet.next() && resultSet.getInt(1) == 0) {
                    insertStmt.setString(1, inputID);
                    insertStmt.executeUpdate();
                    System.out.println("IDPelanggan " + inputID + " berhasil ditambahkan.");
                } else {
                    System.out.println("IDPelanggan " + inputID + " sudah ada di database.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            new MenuUtama().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Masukkan ID Meteran yang benar", "Harus 11 digit", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new InputID().setVisible(true));
    }
}
