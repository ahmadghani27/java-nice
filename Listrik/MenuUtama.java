package Listrik;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class MenuUtama extends JFrame {
  private JLabel JLtitle, JLinputID;
  private JTextField JTinputID;
  private JButton JBtenter, JBkeluar, JBriwayat, JBbeli;
  private String konter;

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

    InputID();
    MenuUtama();

    JLtitle = new JLabel("iAN Konter");
    JLtitle.setBounds(20, 370, 180, 50);
    JLtitle.setFont(new Font("SansSerif", 3, 28));
    JLtitle.setForeground(new Color(0, 51, 153));
    JLtitle.setText("iAN Konter");
    add(JLtitle);
  }

  public void InputID(){    
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
  //   jButton1.addActionListener(new java.awt.event.ActionListener() {
  //     public void actionPerformed(java.awt.event.ActionEvent evt) {
  //         jButton1ActionPerformed(evt);
  //     }
  // });
  }

  public void MenuUtama(){    
    JLinputID = new JLabel();
    JLinputID.setBounds(120, 40, 400, 50);
    JLinputID.setFont(new Font("SansSerif", 1, 28)); 
    JLinputID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    JLinputID.setText("Menu Utama");
    add(JLinputID);

   
    
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
    // JBkeluar.addActionListener(new java.awt.event.ActionListener() {
    //     public void actionPerformed(java.awt.event.ActionEvent evt) {
    //         jButton2ActionPerformed(evt);
    //     }
    // });
    add(JBkeluar);
    JBkeluar.setBounds(350, 370, 260, 60);
  }

  public static void main(String[] args) {
      new MenuUtama();
  }
}