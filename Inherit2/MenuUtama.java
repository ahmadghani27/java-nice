
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class MenuUtama extends JFrame {

    private JLabel JLtitle, JLinputID, JTgetID, JTgetnama;
    private JTextField JTinputID;
    private JButton JBtenter, JBkeluar, JBriwayat, JBbeli;
    private String konter;
    private JTable TabelRiwayat;
    private JScrollPane jScrollPane;
    private Boolean visible;

    public MenuUtama() {
        setTitle("Listrik - iAN Konter");
        setSize(640, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        Dimension window = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (window.width - 640) / 2;
        int y = (window.height - 450) / 2;
        setLocation(x, y);

        InputID(true);
        // Riwayat();

        JLtitle = new JLabel("iAN Konter");
        JLtitle.setBounds(20, 350, 180, 50);
        JLtitle.setFont(new Font("SansSerif", 3, 28));
        JLtitle.setForeground(new Color(0, 51, 153));
        JLtitle.setText("iAN Konter");
        setComponentZOrder(JLtitle, 0);
        add(JLtitle);
    }

    public void InputID(Boolean visible) {
        JLinputID = new JLabel();
        JLinputID.setBounds(120, 40, 400, 50);
        JLinputID.setFont(new Font("SansSerif", 1, 28));
        JLinputID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JLinputID.setText("Masukkan ID Meteran Lisrik");
        add(JLinputID);

        JTinputID = new JTextField();
        JTinputID.setFont(new Font("SansSerif", 0, 40));
        JTinputID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTinputID.setText("");
        // JTinputID.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         jTextField1ActionPerformed(evt);
        //     }
        // });
        add(JTinputID);
        JTinputID.setBounds(150, 120, 340, 70);

        JBtenter = new JButton();
        JBtenter.setBounds(220, 220, 190, 50);
        JBtenter.setFont(new java.awt.Font("SansSerif", 0, 28));
        JBtenter.setText("Enter");
        add(JBtenter);
          JBtenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu();
                InputID(false);
            }
        });
    }

    public void Menu() {
        JLinputID = new JLabel();
        JLinputID.setBounds(120, 20, 400, 50);
        JLinputID.setFont(new Font("SansSerif", 1, 28));
        JLinputID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JLinputID.setText("Menu Utama");
        add(JLinputID);

        JTgetID = new JLabel();
        JTgetID.setBounds(60, 70, 520, 40);
        JTgetID.setFont(new java.awt.Font("SansSerif", 0, 24));
        JTgetID.setText("ID Meteran : getID");
        add(JTgetID);

        JTgetnama = new javax.swing.JLabel();
        JTgetnama.setBounds(60, 110, 520, 40);
        JTgetnama.setFont(new java.awt.Font("SansSerif", 0, 24));
        JTgetnama.setText("Nama         : getdatabase");
        add(JTgetnama);

        JBriwayat = new JButton();
        JBriwayat.setFont(new Font("SansSerif", 0, 28));
        JBriwayat.setText("<html><div style='text-align: center;'>Riwayat<br>Transaksi</html>");
        // JBriwayat.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         jButton3ActionPerformed(evt);
        //     }
        // });
        add(JBriwayat);
        JBriwayat.setBounds(60, 170, 230, 150);

        JBbeli = new javax.swing.JButton();
        JBbeli.setFont(new java.awt.Font("SansSerif", 0, 28));
        JBbeli.setText("Beli Token");
        // JBbeli.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         jButton1ActionPerformed(evt);
        //     }
        // });
        getContentPane().add(JBbeli);
        JBbeli.setBounds(350, 170, 230, 150);

        JBkeluar = new JButton();
        JBkeluar.setBackground(new Color(204, 0, 0));
        JBkeluar.setFont(new Font("SansSerif", 0, 28));
        JBkeluar.setForeground(new Color(255, 255, 255));
        JBkeluar.setText("Keluar");
        // JBkeluar.addMouseListener(new java.awt.event.MouseAdapter() {
        //     public void mouseEntered(java.awt.event.MouseEvent evt) {
        //         jButton2MouseEntered(evt);
        //     }
        //     public void mouseExited(java.awt.event.MouseEvent evt) {
        //         jButton2MouseExited(evt);
        //     }
        // });
        JBkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        add(JBkeluar);
        JBkeluar.setBounds(350, 340, 260, 60);
    }

    public void Riwayat() {
        JLinputID = new JLabel();
        JLinputID.setBounds(120, 20, 400, 50);
        JLinputID.setFont(new Font("SansSerif", 1, 28));
        JLinputID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JLinputID.setText("Riwayat Transaksi");
        add(JLinputID);

        TabelRiwayat = new JTable();
        TabelRiwayat.setFont(new Font("SansSerif", 0, 14));
        TabelRiwayat.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Paket Listrik", "Harga", "Status", "Tanggal"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane = new JScrollPane(TabelRiwayat);
        jScrollPane.setBounds(50, 90, 540, 130);
        add(jScrollPane);

// jScrollPane.setViewportView( TabelRiwayat);
// if ( TabelRiwayat.getColumnModel().getColumnCount() > 0) {
//      TabelRiwayat.getColumnModel().getColumn(0).setResizable(false);
//      TabelRiwayat.getColumnModel().getColumn(1).setResizable(false);
//      TabelRiwayat.getColumnModel().getColumn(2).setResizable(false);
//      TabelRiwayat.getColumnModel().getColumn(3).setResizable(false);
// }
        JBkeluar = new JButton();
        JBkeluar.setBackground(new Color(0, 255, 51));
        JBkeluar.setFont(new Font("SansSerif", 0, 28));
        JBkeluar.setForeground(new Color(255, 255, 255));
        JBkeluar.setText("Keluar");
        // JBkeluar.addMouseListener(new java.awt.event.MouseAdapter() {
        //     public void mouseEntered(java.awt.event.MouseEvent evt) {
        //         jButton2MouseEntered(evt);
        //     }
        //     public void mouseExited(java.awt.event.MouseEvent evt) {
        //         jButton2MouseExited(evt);
        //     }
        // });
        JBkeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        add(JBkeluar);
        JBkeluar.setBounds(350, 340, 260, 60);
    }

    public static void main(String[] args) {
        new MenuUtama();
    }
}
