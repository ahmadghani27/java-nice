import java.util.Arrays;

import javax.swing.*;;
public class percobaan7 {
    public static void main(String[] args) {
        int matrik1 [][] ={{2,9},{1,5}}; 
        int matrik2 [][] ={{5,17},{10,4}}; 
        StringBuilder cari = new StringBuilder();
        int input = Integer.parseInt(JOptionPane.showInputDialog("Masukkan angka yang dicari :"));
        int l,ll; 
        for (l=0;l<matrik1.length;l++){
            for(ll=0;ll<matrik2[l].length;ll++){
                if(matrik1[l][ll]==input){
                    cari.append("angka "+input+" ditemukan pada matrik 1 indeks "+"["+l+"]"+"["+ll+"]");
                }
                if(matrik2[l][ll]==input){
                    cari.append("angka"+input+"ditemukan pada matrik 2 indeks "+"["+l+"]"+"["+ll+"]");
                } 
            }
        }
        if(cari.length()>0){
            JOptionPane.showMessageDialog(null, cari.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Angka tidak ditemukan di kedua data matriks");
        }
        int jml[][]=new int[matrik1.length][matrik1[0].length];
        for (l=0;l<matrik1.length;l++){
            for(ll=0;ll<matrik2[l].length;ll++){
                jml[l][ll]=matrik1[l][ll]+matrik2[l][ll];
            }
        }
        StringBuilder matrikakhir = new StringBuilder();
        for(int []hasil : jml){
            matrikakhir.append(Arrays.toString(hasil)).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Hasil penjumlahan kedua matriks :\n"+matrikakhir.toString());
    }
}
