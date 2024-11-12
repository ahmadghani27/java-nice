package org.yourcompany.project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Riwayat extends JFrame {

    private Font openSans;
    private String idPelanggan; // Declare the variable to hold the ID

    private static final String URL = "jdbc:mysql://localhost:3306/DataBaseIanKonter";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Riwayat() {
        loadCustomFont();
        initComponents();
        getIdPelanggan(); // Call to get the ID from InputID
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

    private JTable jTable1 = new JTable();

    private void initComponents() {
        JPanel subPanel1 = new JPanel();
        JPanel MAINPANEL = new JPanel();
        JButton jBKeluar = new JButton();
        JLabel jLIDPLN2 = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JLabel jLtitle = new JLabel();
        JLabel jLStore = new JLabel("iAN Konter" + " > " + "Listrik" + " > " + "Menu Utama" + " > " + "Riwayat Transaksi");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(960, 720));
        getContentPane().setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width / 2;
        int screenHeight = screenSize.height / 2;
        int x = (screenWidth - 960 / 2);
        int y = (screenHeight - 780 / 2);
        setLocation(x, y);

        MAINPANEL.setLayout(null);
        MAINPANEL.setBounds(0, 0, 944, 681);
        MAINPANEL.setBackground(new Color(250, 255, 250));
        getContentPane().add(MAINPANEL);
        Border border = BorderFactory.createLineBorder(new Color(46, 255, 44), 4);
        MAINPANEL.setBorder(border);

        subPanel1.setBounds(20, 120, 899, 460);
        subPanel1.setBackground(new Color(240, 240, 255));
        MAINPANEL.add(subPanel1);
        subPanel1.setLayout(null);

        jBKeluar.setBackground(new Color(255, 0, 0));
        jBKeluar.setForeground(Color.WHITE);
        jBKeluar.setText("Keluar");
        jBKeluar.setBorder(null);
        MAINPANEL.add(jBKeluar);
        jBKeluar.setBounds(710, 600, 210, 60);
        jBKeluar.addActionListener(evt -> ActionMenu(evt));
        jBKeluar.setFont(openSans);

        jLIDPLN2.setFont(openSans);
        jLIDPLN2.setHorizontalAlignment(SwingConstants.LEFT);
        jLIDPLN2.setText("ID PLN                :");
        subPanel1.add(jLIDPLN2);
        jLIDPLN2.setBounds(20, 10, 480, 60);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},},
                new String[]{
                    "No", "Paket", "Promo", "Total Harga", "Status", "Tanggal"
                }
        ) {
            Class[] types = new Class[]{
                Integer.class, String.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(175);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(192);

        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowHeight(25);
        jTable1.setShowGrid(false);
        jScrollPane1.setViewportView(jTable1);

        subPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 879, 375);

        jLtitle.setFont(openSans.deriveFont(40f));
        jLtitle.setHorizontalAlignment(SwingConstants.CENTER);
        jLtitle.setText("Riwayat Transaksi");
        MAINPANEL.add(jLtitle);
        jLtitle.setBounds(80, 40, 784, 60);

        jLStore.setFont(openSans.deriveFont(16f));
        jLStore.setForeground(new Color(4, 4, 144));
        jLStore.setBounds(16, 10, 909, 20);
        MAINPANEL.add(jLStore);

        pack();
    }

    private void getIdPelanggan() {
        InputID inputIDFrame = new InputID();
        inputIDFrame.setVisible(true); 
        inputIDFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Long AB = inputIDFrame.AmbilIDMeteran(); // Get the ID from InputID
                idPelanggan = AB.toString();
                System.out.println("ID Pelanggan: " + idPelanggan);
                loadRiwayatTransaksi(); // Load transaction history after getting the ID
            }
        });
    }

    private void loadRiwayatTransaksi() {
        String query = "SELECT NO, IDPELANGGAN, PAKET, PROMO, TOTALHARGA, STATUS, TANGGAL FROM RiwayatTransaksi WHERE IDPELANGGAN = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idPelanggan); // Set the ID parameter
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Clear existing rows

            int no = 1; // Row number for display
            while (rs.next()) {
                String idPelanggan = rs.getString("IDPELANGGAN");
                String paket = rs.getString("PAKET");
                String promo = rs.getString("PROMO");
                String totalHarga = rs.getString("TOTALHARGA");
                String status = rs.getString("STATUS");
                String tanggal = rs.getString("TANGGAL");

                // Add a new row to the table model
                model.addRow(new Object[]{no++, idPelanggan, paket, promo, totalHarga, status, tanggal});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading transaction history: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ActionMenu(ActionEvent evt) {
        MenuUtama menuUtama = new MenuUtama();
        menuUtama.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Riwayat().setVisible(true);
            }
        });
    }
}