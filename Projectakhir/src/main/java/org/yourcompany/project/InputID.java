package org.yourcompany.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
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
import javax.swing.border.Border;

public class InputID extends JFrame {

    private JPanel subPanel1, MAINPANEL;
    private JTextField jTFinputID, jTFinputUsr;
    private JButton jBinputID;
    private JLabel jLTitle, jLInput, jLStore;
    private Font openSans;

    private static final String URL = "jdbc:mysql://localhost:3306/DataBaseIanKonter";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    public InputID() {
        initComponents();
        setupActions();

        MySQLConnector CheckandCreate = new MySQLConnector();
        connection = CheckandCreate.connect();

        if (connection != null) {
            CheckandCreate.checkAndCreateDatabaseAndTables(connection);
        } else {
            JOptionPane.showMessageDialog(this, "Database connection failed. The application will continue without database access.",
                    "Connection Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void initComponents() {
        MAINPANEL = new JPanel();
        subPanel1 = new JPanel();
        jTFinputID = new JTextField("ID Meteran");
        jTFinputUsr = new JTextField("Nama Pelanggan");
        jBinputID = new JButton("Enter");
        jLTitle = new JLabel("Input ID Meteran", SwingConstants.CENTER);
        jLInput = new JLabel("Input tidak valid");
        jLStore = new JLabel("iAN Konter" + " > " + "Listrik");
        loadCustomFont();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(640, 720));
        getContentPane().setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width / 2;
        int screenHeight = screenSize.height / 2;
        int x = (screenWidth - 640 / 2);
        int y = (screenHeight - 780 / 2);
        setLocation(x, y);

        MAINPANEL.setLayout(null);
        MAINPANEL.setBounds(0, 0, 624, 681);
        MAINPANEL.setBackground(new Color(250, 255, 250));
        getContentPane().add(MAINPANEL);
        Border Border = BorderFactory.createLineBorder(new Color(46, 255, 44), 4);
        MAINPANEL.setBorder(Border);

        subPanel1.setLayout(null);
        jTFinputID.setFont(openSans.deriveFont(36f));
        jTFinputID.setHorizontalAlignment(JTextField.CENTER);
        jTFinputID.setBorder(BorderFactory.createLineBorder(new Color(51, 0, 153), 1));
        jTFinputID.setMargin(new Insets(8, 8, 8, 8));
        jTFinputID.setBounds(74, 41, 450, 75);
        subPanel1.add(jTFinputID);

        jTFinputUsr.setFont(openSans.deriveFont(28f));
        jTFinputUsr.setHorizontalAlignment(JTextField.CENTER);
        jTFinputUsr.setBorder(BorderFactory.createLineBorder(new Color(51, 0, 153), 1));
        jTFinputUsr.setMargin(new Insets(8, 8, 8, 8));
        jTFinputUsr.setBounds(74, 147, 450, 75);
        subPanel1.add(jTFinputUsr);

        jBinputID.setBackground(new Color(51, 153, 255));
        jBinputID.setFont(openSans.deriveFont(32f));
        jBinputID.setForeground(Color.WHITE);
        jBinputID.setBounds(74, 253, 450, 55);
        jBinputID.addActionListener(evt -> ActionMenu());
        subPanel1.add(jBinputID);

        subPanel1.setBounds(20, 150, 579, 340);
        subPanel1.setBackground(new Color(240, 240, 255));
        MAINPANEL.add(subPanel1);

        jLTitle.setFont(openSans.deriveFont(48f));
        jLTitle.setBounds(80, 50, 470, 60);
        MAINPANEL.add(jLTitle);

        jLInput.setFont(openSans.deriveFont(12f));
        jLInput.setForeground(Color.RED);
        jLInput.setVisible(false);
        jLInput.setBounds(80, 115, 440, 15);
        subPanel1.add(jLInput);

        jLStore.setFont(openSans.deriveFont(16f));
        jLStore.setForeground(new Color(4, 4, 144));
        jLStore.setBounds(16, 10, 589, 20);
        MAINPANEL.add(jLStore);

        pack();
    }

    private void loadCustomFont() {
        try {
            InputStream fontStream = getClass().getClassLoader().getResourceAsStream("OpenSans-Regular.ttf");
            if (fontStream != null) {
                openSans = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(18f);
            } else {
                System.err.println("Font file not found!");
            }
        } catch (Exception e) {
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
        String InputID = jTFinputID.getText();
        String NamaPelanggan = jTFinputUsr.getText();

        if (InputID.length() == 11) {
            long inputID;
            try {
                inputID = Long.parseLong(InputID);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Masukkan ID Meteran yang benar", "Harus angka 11 digit", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String checkQuery = "SELECT COUNT(*) FROM IDPelanggan WHERE IDMeteran = ?";
            String insertQuery = "INSERT INTO IDPelanggan (IDMeteran, NamaPelanggan) VALUES (?, ?)";

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement checkStmt = connection.prepareStatement(checkQuery); PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {

                checkStmt.setLong(1, inputID);
                ResultSet resultSet = checkStmt.executeQuery();

                if (resultSet.next() && resultSet.getInt(1) == 0) {
                    insertStmt.setLong(1, inputID);
                    insertStmt.setString(2, NamaPelanggan);
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


    public long AmbilIDMeteran() {
        return Long.parseLong(jTFinputID.getText());
    }
    
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new InputID().setVisible(true));
    }
}
