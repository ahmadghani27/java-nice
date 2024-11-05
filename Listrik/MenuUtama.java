package Listrik;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class MenuUtama extends JFrame {
  private JLabel JLtitle, JLinputID;
  private JTextField JTinputID;
  private JButton JBtenter;
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

    JLtitle = new JLabel("iAN Konter");
    JLtitle.setBounds(20, 370, 180, 50);
    JLtitle.setFont(new Font("SansSerif", 3, 28));
    JLtitle.setForeground(new Color(0, 51, 153));
    JLtitle.setText("iAN Konter");
    add(JLtitle);
  }

  public void InputID(){    
    JLinputID = new JLabel("Masukkan ID Meteran Listrik");
    JLinputID.setBounds(120, 40, 400, 50);
    JLinputID.setFont(new java.awt.Font("SansSerif", 1, 28)); 
    JLinputID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    JLinputID.setText("Masukkan ID Meteran Listrik");
    add(JLinputID);

  }

  public static void main(String[] args) {
      new MenuUtama();
  }
}