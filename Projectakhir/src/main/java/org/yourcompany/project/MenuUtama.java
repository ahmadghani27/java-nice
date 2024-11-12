package org.yourcompany.project;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class MenuUtama extends JFrame {

    private JButton jBBeli;
    private JButton jBKeluar;
    private JButton jBriwayat;
    private JLabel jLIDPLN2;
    private JLabel jLNamaPengguna;
    private JLabel jLtitle, jLStore;
    private JPanel subPanel1, MAINPANEL;
    private Font openSans;

    private static final String URL = "jdbc:mysql://localhost:3306/DataBaseIanKonter";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public MenuUtama() {
        loadCustomFont();
        initComponents();
        setResizable(false);
        Connector();

        
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

    private void initComponents() {

        MAINPANEL = new JPanel();
        subPanel1 = new JPanel();
        jBKeluar = new JButton();
        jBBeli = new JButton();
        jBriwayat = new JButton();
        jLtitle = new JLabel();
        jLStore = new JLabel("iAN Konter" + " > " + "Listrik" + " > " + "Menu Utama");

        jBBeli.setBackground(Color.ORANGE);
        jBBeli.setFont(openSans.deriveFont(Font.BOLD, 32f));
        jBBeli.setForeground(Color.WHITE);
        jBBeli.setText("Beli Token Listrik");
        jBBeli.setBorder(null);
        jBBeli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBBeliActionPerformed(evt);
            }
        });
        jBBeli.addActionListener(evt -> toPembelian(evt));
        subPanel1.add(jBBeli);
        jBBeli.setBounds(24, 36, 531, 190);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setFont(new Font("SansSerif", 0, 18));
        setForeground(new Color(0, 0, 51));
        setLocation(new Point(0, 0));
        setName("MainFrame");
        getContentPane().setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width / 2;
        int screenHeight = screenSize.height / 2;
        int x = (screenWidth - 640 / 2);
        int y = (screenHeight - 780 / 2);
        setLocation(x, y);

        jLStore.setFont(openSans.deriveFont(16f));
        jLStore.setForeground(new Color(4, 4, 144));
        jLStore.setBounds(16, 10, 589, 20);
        MAINPANEL.add(jLStore);

        MAINPANEL.setLayout(null);
        MAINPANEL.setBounds(0, 0, 624, 681);
        MAINPANEL.setBackground(new Color(250, 255, 250));
        getContentPane().add(MAINPANEL);
        Border Border = BorderFactory.createLineBorder(new Color(46, 255, 44), 4);
        MAINPANEL.setBorder(Border);
        MAINPANEL.add(subPanel1);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(640, 720));
        getContentPane().setLayout(null);

        subPanel1.setBounds(20, 120, 579, 460);
        subPanel1.setBackground(new Color(240, 240, 255));
        MAINPANEL.add(subPanel1);
        subPanel1.setLayout(null);

        jBKeluar.setBackground(new Color(255, 0, 0));// Use Open Sans font
        jBKeluar.setForeground(Color.WHITE);
        jBKeluar.setText("Keluar");
        jBKeluar.setBorder(null);
        jBKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBKeluarActionPerformed(evt);
            }
        });
        MAINPANEL.add(jBKeluar);
        jBKeluar.setBounds(390, 600, 210, 60);
        jBKeluar.setFont(openSans);

        jBriwayat.setBackground(new Color(13, 207, 0));
        jBriwayat.setFont(openSans.deriveFont(Font.BOLD, 32f));
        jBriwayat.setForeground(Color.WHITE);
        jBriwayat.setText("Riwayat Transaksi");
        jBriwayat.setBorder(null);
        jBriwayat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBriwayatActionPerformed(evt);
            }
        });
        jBriwayat.addActionListener(evt -> toRiwayat(evt));
        subPanel1.add(jBriwayat);
        jBriwayat.setBounds(24, 240, 531, 190);

        jLtitle.setFont(openSans.deriveFont(40f));
        jLtitle.setHorizontalAlignment(SwingConstants.CENTER);
        jLtitle.setText("Menu Utama");
        MAINPANEL.add(jLtitle);
        jLtitle.setBounds(80, 40, 470, 60);

        pack();
    }

    private void jBKeluarActionPerformed(ActionEvent evt) {
        MySQLConnector connector = new MySQLConnector();
        Connection connection = null;

        try {
            connection = connector.connect();
        } finally {
            connector.closeConnection(connection);
        }

        System.exit(0);
    }

    private void jBBeliActionPerformed(ActionEvent evt) {
    }

    private void jBriwayatActionPerformed(ActionEvent evt) {
    }

    public void Connector() {
        MySQLConnector connector = new MySQLConnector(); // Membuat instance dari MySQLConnector
        Connection connection = connector.connect(); // Memanggil metode connect
    }

    public void ID(String inputID) {
        String selectQuery = "SELECT * FROM id_pelanggan WHERE ID_Pelanggan = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {

            selectStmt.setString(1, inputID);
            ResultSet ID_Pelanggan = selectStmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void toPembelian(ActionEvent evt) {
        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setVisible(true);
        this.dispose();
    }

    private void toRiwayat(ActionEvent evt) {
        Riwayat riwayat = new Riwayat();
        riwayat.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }
}
