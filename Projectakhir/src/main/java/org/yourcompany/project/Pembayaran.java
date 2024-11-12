package org.yourcompany.project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Pembayaran extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/DataBaseIanKonter";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Long idPelanggan;

    private Font openSansFont;
    private int HargaPaketAkhir, HargaPaketAwal, BiayaAdmin, TotalHargaDibayar, HargaPromo;
    private JLabel jLPaket = new JLabel("Paket Listrik:");
    private JComboBox<String> jCBmetode = new JComboBox<>(new String[]{"Dana", "Bank BCA", "Bank BRI", "Bank Mandiri", "Shopee Pay"});
    private JLabel jLMetode = new JLabel("Metode Pembayaran ");
    private JTextField JTinputPromo = new JTextField("");
    private JLabel jLPromo = new JLabel("Promo");
    private JLabel jLPaketdibeli = new JLabel("Rp0,00", SwingConstants.RIGHT);
    private JLabel jLHargapaket = new JLabel("Harga Paket");
    private JLabel jLPromodipakai = new JLabel("-Rp0,00", SwingConstants.RIGHT);
    private JLabel jLKodePromo = new JLabel("Kode Promo");
    private JLabel jLTotalharga = new JLabel("Total Pembayaran");
    private JTextField TotalHarga = new JTextField("Rp0,00");
    private JButton jBbayar = new JButton("Bayar");
    private ButtonGroup buttonGroup = new ButtonGroup();

    private static final int BIAYA_ADMIN = 2000;

    public Pembayaran() {
        loadCustomFont();
        initComponents();
    }

    private void loadCustomFont() {
        try {
            InputStream fontStream = getClass().getClassLoader().getResourceAsStream("OpenSans-Regular.ttf");
            if (fontStream != null) {
                openSansFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(18f);
            } else {
                System.err.println("Font file not found! Using default font.");
                openSansFont = new Font("Arial", Font.PLAIN, 18);
            }
        } catch (Exception e) {
            e.printStackTrace();
            openSansFont = new Font("Arial", Font.PLAIN, 18); // Fallback to default font
        }
    }

    private void initComponents() {
        String[] Paket = {"20000", "50000", "100000", "150000", "200000", "300000", "500000", "1000000", "1500000"};

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(640, 720));
        setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize ();
        int screenWidth = screenSize.width / 2;
        int screenHeight = screenSize.height / 2;
        int x = (screenWidth - 640 / 2);
        int y = (screenHeight - 780 / 2);
        setLocation(x, y);

        JPanel MAINPANEL = new JPanel();
        JPanel subPanel0 = new JPanel();
        JPanel subPanel1 = new JPanel();
        JPanel subPanel2 = new JPanel();
        JButton jBKeluar = new JButton();

        MAINPANEL.setLayout(null);
        MAINPANEL.setBounds(0, 0, 624, 681);
        MAINPANEL.setBackground(new Color(250, 255, 250));
        getContentPane().add(MAINPANEL);
        Border border = BorderFactory.createLineBorder(new Color(46, 255, 44), 4);
        MAINPANEL.setBorder(border);
        MAINPANEL.add(subPanel1);
        MAINPANEL.add(subPanel2);

        subPanel0.setBounds(20, 100, 584, 388);
        subPanel0.setBackground(new Color(240, 240, 255));
        MAINPANEL.add(subPanel0);
        subPanel0.setLayout(null);
        
        subPanel1.setLayout(null);
        ActionListener toggleListener = e -> {
            JToggleButton selectedButton = (JToggleButton) e.getSource();
            String Hargapaket = selectedButton.getText();
            HargaPaketAwal = Integer.parseInt(Hargapaket);
            BiayaAdmin = BIAYA_ADMIN + HargaPaketAwal * 1 / 100;
            HargaPaketAkhir = HargaPaketAwal + BiayaAdmin;
            jLPaketdibeli.setText("Rp" + HargaPaketAkhir + ",00");
            TotalHargaDibayar = HargaPaketAkhir - HargaPromo;
            updateTotalPrice();
        };
        JToggleButton[] jToggleButtons = new JToggleButton[Paket.length];
        for (int i = 0; i < Paket.length; i++) {
            jToggleButtons[i] = new JToggleButton(Paket[i]);
            jToggleButtons[i].setBounds((i % 3) * 176, (i / 3) * 43, 173, 40);
            subPanel1.add(jToggleButtons[i]);
            buttonGroup.add(jToggleButtons[i]);
            jToggleButtons[i].addActionListener(toggleListener);
        }

        JLabel jTtitle = new JLabel("Beli Token Listrik", SwingConstants.CENTER);
        jTtitle.setBounds(80, 20, 470, 60);
        MAINPANEL.add(jTtitle);

        jBKeluar.setBackground(new Color(255, 0, 0));
        jBKeluar.setForeground(Color.WHITE);
        jBKeluar.setText("Keluar");
        jBKeluar.setBorder(null);
        MAINPANEL.add(jBKeluar);
        jBKeluar.setBounds(60, 600, 210, 60);
        jBKeluar.addActionListener(evt -> ActionMenu(evt));
        jBKeluar.setFont(openSansFont);


        subPanel0.add(subPanel1).setBounds(32, 60, 525, 126);
        subPanel0.add(jLPaket).setBounds(32, 12, 525, 40);

        JRadioButton cekPromo = new JRadioButton();
        subPanel0.add(cekPromo).setBounds(530, 260, 20, 40);

        jCBmetode.setBackground(Color.WHITE);
        jCBmetode.setFont(openSansFont.deriveFont(16f));
        jCBmetode.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBorder(BorderFactory.createEmptyBorder(2, 16, 2, 16));
                return label;
            }
        });

        subPanel0.add(jCBmetode).setBounds(250, 210, 300, 40);
        subPanel0.add(jLMetode).setBounds(60, 210, 190, 40);
        subPanel0.add(JTinputPromo).setBounds(250, 260, 280, 40);
        subPanel2.setLayout(null);
        subPanel2.setBackground(new Color(250, 255, 250));
        subPanel2.add(jLPromo).setBounds(30, 30, 190, 40);
        subPanel2.add(jLPaketdibeli).setBounds(290, 0, 190, 40);
        subPanel2.add(jLHargapaket).setBounds(30, 0, 190, 40);
        subPanel2.add(jLPromodipakai).setBounds(290, 30, 190, 40);
        subPanel0.add(subPanel2).setBounds(32, 320, 525, 70);
        subPanel0.add(jLKodePromo).setBounds(60, 260, 190, 40);

        jBbayar.setBackground(new Color(0, 204, 0));
        jBbayar.setFont(openSansFont.deriveFont(32f));
        jBbayar.setForeground(new Color(255, 255, 255));
        jBbayar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jBbayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(subPanel0, "Pilih Paket Listrik Yang Diinginkan Terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String selectedPackage = jLPaketdibeli.getText();
                String paymentMethod = (String) jCBmetode.getSelectedItem();
                String promoCode = jLPromodipakai.getText();

                String formattedPrice = selectedPackage.replace("Rp", "").replace(".", "").replace(",", "").trim();
                int packagePrice;

                try {
                    packagePrice = Integer.parseInt(formattedPrice);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(subPanel0, "Harga paket tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int discount = 0;
                if (!promoCode.isEmpty()) {
                    discount = getDiscountAmount(promoCode);
                }

                // Assuming you have a way to get the ID without creating a new instance
                String meterID = String.valueOf(idPelanggan); // Ensure this is the correct type

                int totalPrice = updateTotalPrice(); // Ensure this method accounts for discounts
                TotalHarga.setText("Rp " + String.format("%,d", totalPrice));
                saveTransaction(meterID, selectedPackage, promoCode, totalPrice); // Pass the meterID

                JOptionPane.showMessageDialog(subPanel0,
                        "<html><body style='width: 300px;'>"
                                + "<h2>Detail Pembayaran</h2>"
                                + "<p><strong>Paket:</strong> " + selectedPackage + "</p>"
                                + "<p><strong>Metode Pembayaran:</strong> " + paymentMethod + "</p>"
                                + "<p><strong>Kode Promo:</strong> " + (promoCode.isEmpty() ? "None" : promoCode) + "</p>"
                                + "<p><strong>Total:</strong> Rp " + String.format("%,d", totalPrice) + "</p>"
                                + "</body></html>",
                        "Konfirmasi Pembayaran", JOptionPane.INFORMATION_MESSAGE);
                toStatus(e);
            }
        });

        cekPromo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cekPromo.isSelected()) {
                    String promoCode = JTinputPromo.getText().trim();
                    HargaPromo = getDiscountAmount(promoCode);

                    if (HargaPromo > 0) {
                        jLPromodipakai.setText("-Rp " + String.format("%,d", HargaPromo));
                    } else {
                        jLPromodipakai.setText("-Rp 0");
                        JOptionPane.showMessageDialog(MAINPANEL, "Kode promo tidak valid atau tidak aktif.", "Kode Promo Tidak Valid", JOptionPane.WARNING_MESSAGE);
                        cekPromo.setSelected(false);
                    }
                } else {
                    HargaPromo = 0;
                    jLPromodipakai.setText("-Rp 0");
                }
                updateTotalPrice();
            }
        });

        MAINPANEL.add(TotalHarga).setBounds(60, 525, 290, 60);
        MAINPANEL.add(jLTotalharga).setBounds(60, 485, 190, 50);
        MAINPANEL.add(jBbayar).setBounds(350, 525, 220, 60);

        jTtitle.setFont(openSansFont.deriveFont(28f));
        jLPaket.setFont(openSansFont.deriveFont(20f));
        jLMetode.setFont(openSansFont.deriveFont(16f));
        jLKodePromo .setFont(openSansFont.deriveFont(16f));
        jLPromo.setFont(openSansFont.deriveFont(16f));
        jLTotalharga.setFont(openSansFont.deriveFont(16f));
        jLPaketdibeli.setFont(openSansFont.deriveFont(16f));
        jLHargapaket.setFont(openSansFont.deriveFont(16f));
        jLPromodipakai.setFont(openSansFont.deriveFont(16f));
        JTinputPromo.setFont(openSansFont.deriveFont(18));
        TotalHarga.setFont(openSansFont.deriveFont(24f));
        
        for (JToggleButton button : jToggleButtons) {
            button.setFont(openSansFont.deriveFont(22f));
            button.setBackground(new Color(153, 255, 153));
        }

        JTinputPromo.setMargin(new Insets(2, 16, 2, 16));
        JTinputPromo.setCaretColor(new Color(0, 153, 0));

        TotalHarga.setMargin(new Insets(2, 16, 2, 16));
        TotalHarga.setCaretColor(new Color(0, 153, 0));
        TotalHarga.setEditable(false);
        TotalHarga.setBackground(Color.WHITE);

        pack();
    }

    private Integer updateTotalPrice() {
        if (HargaPaketAkhir > 0) {
            TotalHargaDibayar = HargaPaketAkhir - HargaPromo;
            TotalHarga.setText("Rp " + String.format("%,d", TotalHargaDibayar));
            return TotalHargaDibayar;
        }
        return 0;
    }

    public Integer getDiscountAmount(String promoCode) {
        String query = "SELECT discount_amount FROM promo_codes WHERE code = ? AND is_active = TRUE";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); 
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, promoCode);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("discount_amount");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void saveTransaction(String idPelanggan, String paket, String promo, int totalHarga) {
        String query = "INSERT INTO RiwayatTransaksi (IDPELANGGAN, PAKET, PROMO, TOTALHARGA, STATUS, TANGGAL) VALUES (?, ?, ?, ?, ?, NOW())";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

               String OO = "11111111111";
    
            stmt.setString(1, OO); // ID Pelanggan
            stmt.setString(2, paket); // Paket yang dibeli
            stmt.setString(3, promo); // Kode promo
            stmt.setInt(4, totalHarga); // Total harga
            stmt.setString(5, "Sukses"); // Status transaksi
    
            stmt.executeUpdate();
            System.out.println("Transaksi berhasil disimpan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void toStatus(ActionEvent evt) {
        StatusTransaksi status = new StatusTransaksi();
        status.setVisible(true);
        this.dispose();
    }

    private void ActionMenu(ActionEvent evt) {
        MenuUtama menuUtama = new MenuUtama();
        menuUtama.setVisible(true);
        this.dispose();
    }

    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            // Provide a valid idPelanggan for the constructor
            long idPelanggan = 1; // Example ID, replace with actual logic to get ID
            new Pembayaran().setVisible(true);
        });
    }
}