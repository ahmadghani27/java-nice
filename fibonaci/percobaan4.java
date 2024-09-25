import java.util.Arrays;

import javax.swing.*;

public class percobaan4 {
    public static void main(String[] args) {
        int data2[][] = { { 4, 6, 4, 2, 8, 4, 2, 11 }, { 4, 6, 4, 2, 8, 4, 2, 10 } };
        int cari = Integer.parseInt(JOptionPane.showInputDialog("Massukkan angka yang dicari : "));
        boolean temu = false;
        StringBuilder zz = new StringBuilder("Angka " + cari + " ada pada indeks : ");
        for (int o = 0; o < data2.length; o++) {
            for (int oo = 0; oo < data2[o].length; oo++) {
                if (data2[o][oo] == cari) {
                    zz.append(" [")
                            .append(o).append("][").append(oo).append("] |");
                    temu = true;
                }
            }
        }
        if (!temu) {
            zz.append("~Angka tidak ditemukan~");
        }
        JOptionPane.showMessageDialog(null, zz.toString());
        int ganti = Integer.parseInt(JOptionPane.showInputDialog("Ganti dengan angka: "));
        for (int o = 0; o < data2.length; o++) {
            for (int oo = 0; oo < data2[o].length; oo++) {
                if (data2[o][oo] == cari) {
                    data2[o][oo] = ganti;
                }
            }
        }
        StringBuilder akhir = new StringBuilder("Data angka setelah diubah :\n");
        akhir.append(Arrays.deepToString(data2));
        JOptionPane.showMessageDialog(null, akhir.toString());
    }
}
