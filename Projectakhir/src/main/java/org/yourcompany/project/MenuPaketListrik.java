package org.yourcompany.project;

import javax.swing.*;
import java.awt.*;

public class MenuPaketListrik extends JFrame {

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
    private JLabel hargaPaketValue = new JLabel("", SwingConstants.RIGHT);
    private JLabel promoValue = new JLabel("-Rp 20,000", SwingConstants.RIGHT);
    private JTextField promoField = new JTextField();
    private JTextField totalField = new JTextField("Total Harga");
    private JButton bayarButton = new JButton("Bayar");

    ButtonGroup paketButtonGroup = new ButtonGroup();
    JComboBox<String> metodeComboBox = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3"});
    String[] hargaPaket = {
        "Rp 5.000", "Rp 10.000", "Rp 15.000", 
        "Rp 20.000", "Rp 50.000", "Rp 100.000", 
        "Rp 200.000", "Rp 500.000", "Rp 1.000.000"
    };

    public MenuPaketListrik() {
        try {
            openSansFont = Font.createFont(Font.TRUETYPE_FONT, new java.io.File("C:\\Users\\user\\OneDrive\\Dokumen\\Pemograman\\tugas akhir pemrograman (ahmad)\\java-nice\\Projectakhir\\src\\main\\java\\org\\yourcompany\\project\\OpenSans-Regular.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(openSansFont);
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
            toggleButton.setBackground(Color.WHITE);
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

        metodeComboBox.setFont(openSansFont.deriveFont(18f));
        metodeComboBox.setBounds(250, 340, 350, 40);
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

        mainPanel.add(bayarPanel);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPaketListrik());
    }
}
