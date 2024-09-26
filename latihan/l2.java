import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class l2 {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("Contoh JTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Membuat data untuk tabel
        String[] kolom = {"Nama", "Usia", "Kota"};
        Object[][] data = {
            {"Ali", 25, "Jakarta"},
            {"Budi", 30, "Bandung"},
            {"Cindy", 22, "Surabaya"},
        };

        // Membuat model tabel
        DefaultTableModel model = new DefaultTableModel(data, kolom);
        JTable tabel = new JTable(model);

        // Menambahkan tabel ke dalam scroll pane
        JScrollPane scrollPane = new JScrollPane(tabel);
        frame.add(scrollPane);

        // Menampilkan frame
        frame.setVisible(true);
    }
}
