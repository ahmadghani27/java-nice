package org.yourcompany.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class Riwayat extends JFrame {

    private Font openSans;

    public Riwayat() {
        loadCustomFont();
        initComponents();
    }

    private void loadCustomFont() {
        try {
            openSans = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\Github\\java-nice\\Projectakhir\\src\\main\\java\\org\\yourcompany\\project\\OpenSans-Regular.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(openSans);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        JPanel subPanel1 = new JPanel();
        JPanel MAINPANEL = new JPanel();
        JButton jBKeluar = new JButton();
        JLabel jLIDPLN2 = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable jTable1 = new JTable();
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
        Border Border = BorderFactory.createLineBorder(new Color(46, 255, 44), 4);
        MAINPANEL.setBorder(Border);

        subPanel1.setBounds(20, 120, 899, 460);
        subPanel1.setBackground(new Color(240, 240, 255));
        MAINPANEL.add(subPanel1);
        subPanel1.setLayout(null);

        jBKeluar.setBackground(new Color(255, 0, 0));// Use Open Sans font
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

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(34);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(175);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);

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
        jLStore.setForeground(new Color(4,4,144));
        jLStore.setBounds(16, 10, 909, 20);
        MAINPANEL.add(jLStore);

        pack();
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
