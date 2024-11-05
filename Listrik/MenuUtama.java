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

  public MenuUtama() {
    setTitle("Listrik - iAN Konter");
    setSize(640, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(null);
    setVisible(true);
    Dimension window = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (window.width - 640) / 2; 
    int y = (window.height - 400) / 2; 

    setLocation(x, y);
  }

  public static void main(String[] args) {
      new MenuUtama();
  }
}