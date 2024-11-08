package org.yourcompany.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Riwayat extends JFrame {

    public Riwayat() {
        initComponents();
    }

    private void initComponents() {
        JFrame jFrame1 = new JFrame();
        JPanel jPanel2 = new JPanel();
        JTextField jTFinputID1 = new JTextField();
        JButton jBinputID1 = new JButton();
        JLabel jLtitle2 = new JLabel();
        JPanel jPanel1 = new JPanel();
        JButton jBKeluar = new JButton();
        JLabel jLIDPLN2 = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable jTable1 = new JTable();
        JLabel jLtitle = new JLabel();

        jFrame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setBackground(Color.WHITE);
        jFrame1.setFont(new Font("SansSerif", 0, 18));
        jFrame1.setForeground(new Color(0, 0, 51));
        jFrame1.setLocation(new Point(0, 0));
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

        jBKeluar.setBackground(Color.RED);
        jBKeluar.setFont(new Font("SansSerif", 0, 32));
        jBKeluar.setForeground(Color.WHITE);
        jBKeluar.setText("Menu Utama");
        jBKeluar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 0));
        jBKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jBKeluarActionPerformed(evt);
            }
        });
        jBKeluar.addActionListener(evt -> ActionMenu(evt));
        jPanel1.add(jBKeluar);
        jBKeluar.setBounds(290, 500, 210, 60);

        jLIDPLN2.setFont(new Font("sansserif", 2, 24));
        jLIDPLN2.setHorizontalAlignment(SwingConstants.LEFT);
        jLIDPLN2.setText("ID PLN                :");
        jPanel1.add(jLIDPLN2);
        jLIDPLN2.setBounds(20, 10, 480, 60);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "No", "Paket", "Total Harga", "Status", "Tanggal"
                }
        ) {
            Class[] types = new Class[]{
                Integer.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 80, 520, 402);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 90, 520, 610);

        jLtitle.setFont(new Font("SansSerif", 1, 48));
        jLtitle.setHorizontalAlignment(SwingConstants.CENTER);
        jLtitle.setText("Riwayat Transaksi");
        getContentPane().add(jLtitle);
        jLtitle.setBounds(80, 30, 470, 60);

        pack();
    }

    private void jTFinputID1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jBinputID1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jBKeluarActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ActionMenu(java.awt.event.ActionEvent evt) {
        MenuUtama menuUtama = new MenuUtama();
        menuUtama.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Riwayat().setVisible(true);
            }
        });
    }
}
