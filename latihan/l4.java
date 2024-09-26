import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class l4 {
    private JTable table;
    private DefaultTableModel model;
    private JTextField itemField;
    private JTextField quantityField;
    private JTextField priceField;

    public static void main(String[] args) {
        new l4();
    }

    public l4() {
        // Create a JTable instance
        table = new JTable();

        // Define the table model
        model = new DefaultTableModel(
            new Object[] { "Item", "Quantity", "Price", "Total" },
            0
        );

        // Set the table model
        table.setModel(model);

        // Create input fields
        itemField = new JTextField(10);
        quantityField = new JTextField(5);
        priceField = new JTextField(10);

        // Create buttons
        JButton addItemButton = new JButton("Add Item");
        addItemButton.addActionListener(new AddItemListener());

        JButton removeItemButton = new JButton("Remove Item");
        removeItemButton.addActionListener(new RemoveItemListener());

        // Create a panel for the input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Item:"));
        inputPanel.add(itemField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(addItemButton);
        inputPanel.add(removeItemButton);

        // Create a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a JFrame
        JFrame frame = new JFrame("Cashier System");
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private class AddItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String item = itemField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            double total = quantity * price;

            model.addRow(new Object[] { item, quantity, price, total });

            itemField.setText("");
            quantityField.setText("");
            priceField.setText("");
        }
    }

    private class RemoveItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            if (row != -1) {
                model.removeRow(row);
            }
        }
    }
}