package org.yourcompany.project;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import com.sun.jdi.connect.Connector;

public class MenuUtama extends JFrame {

    private JButton jBBeli;
    private JButton jBKeluar;
    private JButton jBinputID1;
    private JButton jBriwayat;
    private JFrame jFrame1;
    private JLabel jLIDPLN2;
    private JLabel jLNamaPengguna;
    private JLabel jLtitle;
    private JLabel jLtitle2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField jTFinputID1;
    private Font openSansFont;

    public MenuUtama() {
        try {
            openSansFont = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\\\Github\\\\java-nice\\\\Projectakhir\\\\src\\\\main\\\\java\\\\org\\\\yourcompany\\\\project\\\\OpenSans-Regular.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(openSansFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        initComponents();
        setResizable(false);
        Connector();
    }

    private void initComponents() {
        jFrame1 = new JFrame();
        jPanel2 = new JPanel();
        jTFinputID1 = new JTextField();
        jBinputID1 = new JButton();
        jLtitle2 = new JLabel();
        jPanel1 = new JPanel();
        jBKeluar = new JButton();
        jLNamaPengguna = new JLabel();
        jLIDPLN2 = new JLabel();
        jBBeli = new JButton();
        jBriwayat = new JButton();
        jLtitle = new JLabel();

        jFrame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setBackground(Color.WHITE);
        jFrame1.setFont(new Font("SansSerif", 0, 18));
        jFrame1.setForeground(new Color(0, 0, 51));
        jFrame1.setLocation(new Point(0, 0));
        jFrame1.setName("MainFrame");
        jFrame1.getContentPane().setLayout(null);

        jPanel2.setForeground(new Color(51, 0, 102));

        jTFinputID1.setFont(new Font("SansSerif", 0, 36));
        jTFinputID1.setHorizontalAlignment(JTextField.CENTER);
        jTFinputID1.setText("Meteran");
        jTFinputID1.setBorder(new javax.swing.border.LineBorder(new Color(51, 0, 153), 1, true));
        jTFinputID1.setCaretColor(new Color(51, 0, 255));
        jTFinputID1.setMargin(new Insets(8, 8, 8, 8));
        jTFinputID1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTFinputID1ActionPerformed(evt);
            }
        });

        jBinputID1.setBackground(new Color(51, 153, 255));
        jBinputID1.setFont(new Font("SansSerif", 0, 32));
        jBinputID1.setForeground(Color.WHITE);
        jBinputID1.setText("Enter");
        jBinputID1.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 0, true));
        jBinputID1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBinputID1ActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jBinputID1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTFinputID1, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jTFinputID1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jBinputID1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(48, Short.MAX_VALUE))
        );

        jFrame1.getContentPane().add(jPanel2);
        jPanel2.setBounds(60, 110, 520, 250);

        jLtitle2.setFont(new Font("SansSerif", 1, 48));
        jLtitle2.setHorizontalAlignment(SwingConstants.CENTER);
        jLtitle2.setText("Input ID Meteran");
        jFrame1.getContentPane().add(jLtitle2);
        jLtitle2.setBounds(80, 50, 470, 60);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(640, 720));
        getContentPane().setLayout(null);

        jPanel1.setForeground(new Color(51, 0, 102));
        jPanel1.setLayout(null);

        jBKeluar.setBackground(new Color(255, 0, 0));
        jBKeluar.setFont(new Font("SansSerif", 0, 32));
        jBKeluar.setForeground(Color.WHITE);
        jBKeluar.setText("Keluar");
        jBKeluar.setBorder(null);
        jBKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(jBKeluar);
        jBKeluar.setBounds(290, 500, 210, 60);

        jLNamaPengguna.setFont(new Font("sansserif", 2, 24));
        jLNamaPengguna.setHorizontalAlignment(SwingConstants.LEFT);
        jLNamaPengguna.setText("Nama Pengguna :");
        jPanel1.add(jLNamaPengguna);
        jLNamaPengguna.setBounds(20, 60, 480, 60);

        jLIDPLN2.setFont(new Font("sansserif", 2, 24));
        jLIDPLN2.setHorizontalAlignment(SwingConstants.LEFT);
        jLIDPLN2.setText("ID PLN                :");
        jPanel1.add(jLIDPLN2);
        jLIDPLN2.setBounds(20, 10, 480, 60);

        jBBeli.setBackground(Color.ORANGE);
        jBBeli.setFont(new Font("SansSerif", 0, 32));
        jBBeli.setForeground(Color.WHITE);
        jBBeli.setText("Beli Token Listrik");
        jBBeli.setBorder(null);
        jBBeli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBBeliActionPerformed(evt);
            }
        });
        jPanel1.add(jBBeli);
        jBBeli.setBounds(20, 150, 480, 130);

        jBriwayat.setBackground(new Color(13, 207, 0));
        jBriwayat.setFont(new Font("SansSerif", 0, 32));
        jBriwayat.setForeground(Color.WHITE);
        jBriwayat.setText("Riwayat Transaksi");
        jBriwayat.setBorder(null);
        jBriwayat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBriwayatActionPerformed(evt);
            }
        });
        jPanel1.add(jBriwayat);
        jBriwayat.setBounds(20, 310, 480, 120);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 90, 520, 610);

        jLtitle.setFont(new Font("SansSerif", 1, 48));
        jLtitle.setHorizontalAlignment(SwingConstants.CENTER);
        jLtitle.setText("Menu Utama");
        getContentPane().add(jLtitle);
        jLtitle.setBounds(80, 30, 470, 60);

        pack();
    }

    private void jTFinputID1ActionPerformed(ActionEvent evt) {
    }

    private void jBinputID1ActionPerformed(ActionEvent evt) {
    }

    private void jBKeluarActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void jBBeliActionPerformed(ActionEvent evt) {
    }

    private void jBriwayatActionPerformed(ActionEvent evt) {
    }

    public void Connector(){
        MySQLConnector connector = new MySQLConnector(); // Membuat instance dari MySQLConnector
        Connection connection = connector.connect(); // Memanggil metode connect
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

}
