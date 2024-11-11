package org.yourcompany.project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Pembayaran extends JFrame {

    private Font openSansFont;

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
        int[] Harga = new int[Paket.length];

        for (int i = 0; i < Paket.length; i++) {
            int BiayaAdmin = Integer.parseInt(Paket[i]) * 5 / 100;
            Harga[i] = Integer.parseInt(Paket[i]) + BiayaAdmin;
        }

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

        MAINPANEL.setLayout(null);
        MAINPANEL.setBounds(0, 0, 624, 681);
        MAINPANEL.setBackground(new Color(250, 255, 250));
        getContentPane().add(MAINPANEL);
        Border Border = BorderFactory.createLineBorder(new Color(46, 255, 44), 4);
        MAINPANEL.setBorder(Border);
        MAINPANEL.add(subPanel1);
        MAINPANEL.add(subPanel2);

        subPanel0.setBounds(20, 120, 579, 460);
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
        JLabel jLPaket = new JLabel("Paket Listrik:");
        JComboBox<String> jCBmetode = new JComboBox<>(new String[]{"Dana", "Bank BCA", "Bank BRI", "Bank Mandiri", "Shopee Pay"});
        JLabel jLMetode = new JLabel("Metode Pembayaran ");
        JTextField JTinputPromo = new JTextField("");
        JLabel jLPromo = new JLabel("Promo");
        JLabel jLPaketdibeli = new JLabel("Harga Paket", SwingConstants.RIGHT);
        JLabel jLHargapaket = new JLabel("Harga Paket");
        JLabel jLPromodipakai = new JLabel("Harga Paket", SwingConstants.RIGHT);
        JLabel jLKodePromo = new JLabel("Kode Promo");
        JLabel jLTotalharga = new JLabel("Total Pembayaran");
        JTextField TotalHarga = new JTextField("TotalHarga");
        JButton jBbayar = new JButton("Bayar");
        ButtonGroup buttonGroup = new ButtonGroup();

        subPanel1.setPreferredSize(new Dimension(510, 180));
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

        subPanel1.add(jToggleButton4).setBounds(0, 0, 175, 60);
        subPanel1.add(jToggleButton5).setBounds(175, 0, 175, 60);
        subPanel1.add(jToggleButton3).setBounds(340, 0, 175, 60);
        subPanel1.add(jToggleButton7).setBounds(0, 60, 175, 60);
        subPanel1.add(jToggleButton8).setBounds(175, 60, 175, 60);
        subPanel1.add(jToggleButton6).setBounds(340, 60, 175, 60);
        subPanel1.add(jToggleButton9).setBounds(0, 120, 175, 60);
        subPanel1.add(jToggleButton10).setBounds(175, 120, 175, 60);
        subPanel1.add(jToggleButton11).setBounds(340, 120, 175, 60);
        subPanel0.add(subPanel1).setBounds(32, 70, 525, 190);
        subPanel0.add(jLPaket).setBounds(24, 24, 525, 40);

        JRadioButton cekPromo = new JRadioButton();
        subPanel0.add(cekPromo).setBounds(550, 380, 20, 50);

        jCBmetode.setBackground(Color.WHITE);
        jCBmetode.setFont(openSansFont.deriveFont(16f));
        jCBmetode.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBorder(BorderFactory.createEmptyBorder(2, 16, 2, 16)); // Set padding
                return label;
            }
        });

        subPanel0.add(jCBmetode).setBounds(250, 320, 320, 50);
        subPanel0.add(jLMetode).setBounds(60, 320, 190, 50);
        subPanel0.add(JTinputPromo).setBounds(250, 380, 300, 50);
        subPanel2.setLayout(null);
        subPanel2.add(jLPromo).setBounds(30, 50, 190, 40);
        subPanel2.add(jLPaketdibeli).setBounds(290, 50, 190, 40);
        subPanel2.add(jLHargapaket).setBounds(30, 10, 190, 40);
        subPanel2.add(jLPromodipakai).setBounds(290, 10, 190, 40);
        subPanel0.add(subPanel2).setBounds(60, 480, 510, 100);
        subPanel0.add(jLKodePromo).setBounds(60, 380, 190, 50);
        jBbayar.setBackground(new java.awt.Color(0, 204, 0));
        jBbayar.setFont(openSansFont.deriveFont(32f));
        jBbayar.setForeground(new java.awt.Color(255, 255, 255));
        jBbayar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        MAINPANEL.add(TotalHarga).setBounds(60, 580, 290, 60);
        MAINPANEL.add(jLTotalharga).setBounds(60, 440, 190, 50);
        MAINPANEL.add(jBbayar).setBounds(350, 580, 220, 60);

        jTtitle.setFont(openSansFont.deriveFont(28f));
        jLPaket.setFont(openSansFont.deriveFont(20f));
        jLMetode.setFont(openSansFont.deriveFont(16f));
        jLKodePromo.setFont(openSansFont.deriveFont(16f));
        jLPromo.setFont(openSansFont.deriveFont(16f));
        jLTotalharga.setFont(openSansFont.deriveFont(16f));
        jLPaketdibeli.setFont(openSansFont.deriveFont(16f));
        jLHargapaket.setFont(openSansFont.deriveFont(16f));
        jLPromodipakai.setFont(openSansFont.deriveFont(16f));
        JTinputPromo.setFont(openSansFont.deriveFont(24f));
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
        jBbayar.addActionListener(evt -> toStatus(evt));

        pack();
    }

    private void toStatus(ActionEvent evt) {
        StatusTransaksi status = new StatusTransaksi();
        status.setVisible(true);
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
