package org.yourcompany.project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.BorderLayout;
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

    private Font openSansFont;
    private int HargaPaketAkhir, HargaPaketAwal, BiayaAdmin, TotalHargaDibayar, HargaPromo;
    JLabel jLPaket = new JLabel("Paket Listrik:");
    JComboBox<String> jCBmetode = new JComboBox<>(new String[]{"Dana", "Bank BCA", "Bank BRI", "Bank Mandiri", "Shopee Pay"});
    JLabel jLMetode = new JLabel("Metode Pembayaran ");
    JTextField JTinputPromo = new JTextField("");
    JLabel jLPromo = new JLabel("Promo");
    JLabel jLPaketdibeli = new JLabel("Rp0,00", SwingConstants.RIGHT);
    JLabel jLHargapaket = new JLabel("Harga Paket");
    JLabel jLPromodipakai = new JLabel("-Rp0,00", SwingConstants.RIGHT);
    JLabel jLKodePromo = new JLabel("Kode Promo");
    JLabel jLTotalharga = new JLabel("Total Pembayaran");
    JTextField TotalHarga = new JTextField("Rp0,00");
    JButton jBbayar = new JButton("Bayar");
    ButtonGroup buttonGroup = new ButtonGroup();

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
                System.err.println("Font file not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        String[] Paket = {"20000", "50000", "100000", "150000", "200000", "300000", "500000", "1000000", "1500000"};

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(640, 720));
        setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
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

        JToggleButton jToggleButton3 = new JToggleButton(Paket[0]);
        JToggleButton jToggleButton4 = new JToggleButton(Paket[1]);
        JToggleButton jToggleButton5 = new JToggleButton(Paket[2]);
        JToggleButton jToggleButton6 = new JToggleButton(Paket[3]);
        JToggleButton jToggleButton7 = new JToggleButton(Paket[4]);
        JToggleButton jToggleButton8 = new JToggleButton(Paket[5]);
        JToggleButton jToggleButton9 = new JToggleButton(Paket[6]);
        JToggleButton jToggleButton10 = new JToggleButton(Paket[7]);
        JToggleButton jToggleButton11 = new JToggleButton(Paket[8]);
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

        subPanel1.setLayout(null);
        buttonGroup.add(jToggleButton4);
        buttonGroup.add(jToggleButton5);
        buttonGroup.add(jToggleButton3);
        buttonGroup.add(jToggleButton7);
        buttonGroup.add(jToggleButton8);
        buttonGroup.add(jToggleButton6);
        buttonGroup.add(jToggleButton9);
        buttonGroup.add(jToggleButton10);
        buttonGroup.add(jToggleButton11);

        ActionListener toggleListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton selectedButton = (JToggleButton) e.getSource();
                String Hargapaket = selectedButton.getText();
                HargaPaketAwal = Integer.parseInt(Hargapaket);
                BiayaAdmin = 2000 + HargaPaketAwal * 1 / 100;
                HargaPaketAkhir = HargaPaketAwal + BiayaAdmin;
                jLPaketdibeli.setText("Rp" + HargaPaketAkhir + ",00");
                TotalHargaDibayar = HargaPaketAkhir - HargaPromo;
                updateTotalPrice();
            }
        };

        jToggleButton4.addActionListener(toggleListener);
        jToggleButton5.addActionListener(toggleListener);
        jToggleButton3.addActionListener(toggleListener);
        jToggleButton7.addActionListener(toggleListener);
        jToggleButton8.addActionListener(toggleListener);
        jToggleButton6.addActionListener(toggleListener);
        jToggleButton9.addActionListener(toggleListener);
        jToggleButton10.addActionListener(toggleListener);
        jToggleButton11.addActionListener(toggleListener);

        subPanel1.add(jToggleButton4).setBounds(0, 0, 173, 40);
        subPanel1.add(jToggleButton5).setBounds(176, 0, 173, 40);
        subPanel1.add(jToggleButton3).setBounds(352, 0, 173, 40);
        subPanel1.add(jToggleButton7).setBounds(0, 43, 173, 40);
        subPanel1.add(jToggleButton8).setBounds(176, 43, 173, 40);
        subPanel1.add(jToggleButton6).setBounds(352, 43, 173, 40);
        subPanel1.add(jToggleButton9).setBounds(0, 86, 173, 40);
        subPanel1.add(jToggleButton10).setBounds(176, 86, 173, 40);
        subPanel1.add(jToggleButton11).setBounds(352, 86, 173, 40);
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

                String totalAmount = selectedPackage.replace("Rp", "").replace(".", "").replace(",", "").trim();
                int packagePrice = Integer.parseInt(totalAmount);

                Integer discount = 0;

                if (!promoCode.isEmpty()) {
                    discount = getDiscountAmount(promoCode);
                }

                int totalPrice = updateTotalPrice();
                TotalHarga.setText("Rp " + String.format("%,d", totalPrice));

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
                        JOptionPane.showMessageDialog(MAINPANEL, "Promo code is invalid or inactive.", "Invalid Promo Code", JOptionPane.WARNING_MESSAGE);
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
        jLKodePromo.setFont(openSansFont.deriveFont(16f));
        jLPromo.setFont(openSansFont.deriveFont(16f));
        jLTotalharga.setFont(openSansFont.deriveFont(16f));
        jLPaketdibeli.setFont(openSansFont.deriveFont(16f));
        jLHargapaket.setFont(openSansFont.deriveFont(16f));
        jLPromodipakai.setFont(openSansFont.deriveFont(16f));
        JTinputPromo.setFont(openSansFont.deriveFont(18));
        TotalHarga.setFont(openSansFont.deriveFont(24f));
        jToggleButton4.setFont(openSansFont.deriveFont(22f));
        jToggleButton5.setFont(openSansFont.deriveFont(22f));
        jToggleButton3.setFont(openSansFont.deriveFont(22f));
        jToggleButton7.setFont(openSansFont.deriveFont(22f));
        jToggleButton8.setFont(openSansFont.deriveFont(22f));
        jToggleButton6.setFont(openSansFont.deriveFont(22f));
        jToggleButton9.setFont(openSansFont.deriveFont(22f));
        jToggleButton10.setFont(openSansFont.deriveFont(22f));
        jToggleButton11.setFont(openSansFont.deriveFont(22f));

        jToggleButton4.setBackground(new Color(153, 255, 153));
        jToggleButton5.setBackground(new Color(153, 255, 153));
        jToggleButton3.setBackground(new Color(153, 255, 153));
        jToggleButton7.setBackground(new Color(153, 255, 153));
        jToggleButton8.setBackground(new Color(153, 255, 153));
        jToggleButton6.setBackground(new Color(153, 255, 153));
        jToggleButton9.setBackground(new Color(153, 255, 153));
        jToggleButton10.setBackground(new Color(153, 255, 153));
        jToggleButton11.setBackground(new Color(153, 255, 153));

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
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembayaran().setVisible(true);
            }
        });
    }
}
