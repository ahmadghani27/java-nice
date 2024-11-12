package org.yourcompany.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ppppp extends JFrame {

    public class DatabaseHelper {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ian_konter";
    private static final String DB_USER = "putmul";
    private static final String DB_PASSWORD = "maryzck125";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
    }

    public Integer getDiscountAmount(String promoCode) {
        String query = "SELECT discount_amount FROM promo_codes WHERE code = ? AND is_active = TRUE";
        try (Connection conn = DatabaseHelper.getConnection();
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

    private Font openSansFont;
    private JPanel mainPanel = new JPanel();
    private JPanel paketPanel = new JPanel(new GridLayout(3, 3, 0, 0));
    private JPanel bayarPanel = new JPanel(new BorderLayout());
    private JLabel titleLabel = new JLabel("Beli Token Listrik", SwingConstants.CENTER);
    private JLabel paketLabel = new JLabel("Paket Listrik:");
    private JLabel metodeLabel = new JLabel("Metode Pembayaran");
    private JLabel promoLabel = new JLabel("Kode Promo");
    private JLabel totPembayaran = new JLabel("Total Pembayaran");
    private JLabel hargaPaketLabel = new JLabel("Harga Paket");
    private JLabel promoLabel2 = new JLabel("Promo");
    private JLabel hargaPaketValue = new JLabel("Rp 0", SwingConstants.RIGHT);
    private JLabel promoValue = new JLabel("-Rp 0", SwingConstants.RIGHT);
    private JTextField promoField = new JTextField("");
    private JTextField totalField = new JTextField("Total Harga");
    private JButton bayarButton = new JButton("Bayar");

    ButtonGroup paketButtonGroup = new ButtonGroup();
    Color buttonColor = new Color(153, 255, 153);
    JComboBox<String> metodeComboBox = new JComboBox<>(new String[]{"BNI", "BRI", "BCA", "Mandiri", "Go-Pay", "DANA", });
    String[] hargaPaket = {
        "Rp 5.000", "Rp 10.000", "Rp 15.000", 
        "Rp 20.000", "Rp 50.000", "Rp 100.000", 
        "Rp 200.000", "Rp 500.000", "Rp 1.000.000"
    };

    public ppppp() {
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

        setTitle("Beli Token Listrik");
        setSize(640, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        mainPanel.setLayout(null);

        titleLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        titleLabel.setBounds(80, 20, 470, 60);
        mainPanel.add(titleLabel);

        paketLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        paketLabel.setBounds(40, 80, 470, 40);
        mainPanel.add(paketLabel);

        paketPanel.setBounds(40, 130, 560, 180);

        for (int i = 0; i < 9; i++) {
            JToggleButton toggleButton = new JToggleButton(hargaPaket[i]);
            toggleButton.setFont(openSansFont.deriveFont(18f));
            toggleButton.setBackground(buttonColor);
            toggleButton.setForeground(Color.BLACK);
            toggleButton.setBorder(new javax.swing.border.LineBorder(Color.GRAY, 1, true));

            paketButtonGroup.add(toggleButton);

            toggleButton.addActionListener(e -> hargaPaketValue.setText(toggleButton.getText()));   

            paketPanel.add(toggleButton);
        }
        mainPanel.add(paketPanel);

        metodeLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        metodeLabel.setBounds(40, 340, 220, 40);
        mainPanel.add(metodeLabel);

        metodeComboBox.setBackground(Color.WHITE);
        metodeComboBox.setFont(openSansFont.deriveFont(18f));
        metodeComboBox.setBounds(250, 340, 350, 40);
        metodeComboBox.setSelectedIndex(0);
        mainPanel.add(metodeComboBox);

        promoLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        promoLabel.setBounds(40, 390, 220, 40);
        mainPanel.add(promoLabel);

        promoField.setFont(openSansFont.deriveFont(18f));
        promoField.setBounds(250, 390, 350, 40);
        promoField.setBorder(new javax.swing.border.LineBorder(Color.GRAY, 1, true));
        mainPanel.add(promoField);

        totPembayaran.setFont(new Font("SansSerif", Font.PLAIN, 18));
        totPembayaran.setBounds(40, 450, 300, 20);
        mainPanel.add(totPembayaran);

        hargaPaketLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        hargaPaketLabel.setBounds(80, 490, 300, 20);
        mainPanel.add(hargaPaketLabel);

        hargaPaketValue.setFont(openSansFont.deriveFont(18f));
        hargaPaketValue.setBounds(320, 490, 240, 20);
        mainPanel.add(hargaPaketValue);

        promoLabel2.setFont(new Font("SansSerif", Font.PLAIN, 18));
        promoLabel2.setBounds(80, 530, 300, 20);
        mainPanel.add(promoLabel2);

        promoValue.setFont(openSansFont.deriveFont(18f));
        promoValue.setBounds(320, 530, 240, 20);
        mainPanel.add(promoValue);

        bayarPanel.setBounds(40, 580, 560, 60);

        totalField.setEditable(false);
        totalField.setFont(openSansFont.deriveFont(18f));
        totalField.setHorizontalAlignment(JTextField.CENTER);
        bayarPanel.add(totalField, BorderLayout.CENTER);

        bayarButton.setFont(openSansFont.deriveFont(20f));
        bayarButton.setBackground(Color.GREEN);
        bayarButton.setForeground(Color.WHITE);
        bayarPanel.add(bayarButton, BorderLayout.EAST);

        bayarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPackage = hargaPaketValue.getText();
                String paymentMethod = (String) metodeComboBox.getSelectedItem();
                String promoCode = promoField.getText();

                if (selectedPackage.isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Pilih Paket Listrik Yang Diinginkan Terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String totalAmount = selectedPackage.replace("Rp", "").replace(".", "").trim();
                int packagePrice = Integer.parseInt(totalAmount);

                Integer discount = 0;
                String promoText = "-Rp 0";

                if (!promoCode.isEmpty()) {
                    discount = getDiscountAmount(promoCode);

                    if (!promoCode.isEmpty()) {
                        discount = getDiscountAmount(promoCode);
            
                        if (discount == 0) {
                            int option = JOptionPane.showConfirmDialog(mainPanel, "Kode promo tidak valid/tidak aktif. Apakah Anda ingin mencoba lagi?", "Promo Tidak Valid", JOptionPane.YES_NO_OPTION);
                            
                            if (option == JOptionPane.YES_OPTION) {
                                promoField.setText("");
                                return;  
                            } else {
                                discount = 0;
                            }
                        } promoText = "-Rp " + String.format("%,d", discount);
                        promoValue.setText(promoText); 
                    }
                }
                
                int totalPrice = packagePrice - discount;
                totalField.setText("Rp " + String.format("%,d", totalPrice));

                JOptionPane.showMessageDialog(mainPanel, 
                    "Detail Pembayaran:\n" +
                    "Paket: " + selectedPackage + "\n" +
                    "Metode Pembayaran: " + paymentMethod + "\n" +
                    "Kode Promo: " + (promoCode.isEmpty() ? "None" : promoCode) + "\n" +
                    "Total: Rp " + String.format("%,d", totalPrice), 
                    "Konfirmasi Pembayaran", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        mainPanel.add(bayarPanel);  

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ppppp());
    }
}
