import javax.swing.*;;

public class percobaan5 {
    public static void main(String[] args) {
        int data2[][] = { { 4, 6, 4, 2, 8, 4, 2, 10 }, { 4, 6, 4, 2, 8, 4, 2, 10 } };
        int jumlah = 0;
        for (int b = 0; b < data2.length; b++) {
            for (int k = 0; k < data2[b].length; k++) {
                if (k == 0 || k % 2 == 0) {
                    jumlah += data2[b][k];
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Hasil penjumlahan dari semua data berkolom genap adalah :\n" + jumlah);
    }
}