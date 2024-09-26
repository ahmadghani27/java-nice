import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class l1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel(
            new Object[] { "Column 1", "Column 2", "Column 3" }, 0
        );
        model.addRow(new Object[] { "Cell 1", "Cell 2", "Cell 3" });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
