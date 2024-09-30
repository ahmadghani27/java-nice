package modul7;

import javax.swing.JOptionPane;

public class Budi {

    // Method untuk menghitung volume kubus
    public static double volumeKubus(double sisi) {
        return Math.pow(sisi, 3);
    }

    // Method untuk menghitung volume balok
    public static double volumeBalok(double panjang, double lebar, double tinggi) {
        return panjang * lebar * tinggi;
    }

    // Method untuk menghitung volume tabung
    public static double volumeTabung(double jari2, double tinggi) {
        return Math.PI * Math.pow(jari2, 2) * tinggi;
    }

    public static void main(String[] args) {
        // Mengambil input untuk kubus
        String inputSisiKubus = JOptionPane.showInputDialog("Masukkan panjang sisi kubus:");
        double sisiKubus = Double.parseDouble(inputSisiKubus);
        double hasilKubus = volumeKubus(sisiKubus);
        JOptionPane.showMessageDialog(null, "Volume Kubus: " + hasilKubus);

        // Mengambil input untuk balok
        String inputPanjangBalok = JOptionPane.showInputDialog("Masukkan panjang balok:");
        double panjangBalok = Double.parseDouble(inputPanjangBalok);
        
        String inputLebarBalok = JOptionPane.showInputDialog("Masukkan lebar balok:");
        double lebarBalok = Double.parseDouble(inputLebarBalok);
        
        String inputTinggiBalok = JOptionPane.showInputDialog("Masukkan tinggi balok:");
        double tinggiBalok = Double.parseDouble(inputTinggiBalok);
        
        double hasilBalok = volumeBalok(panjangBalok, lebarBalok, tinggiBalok);
        JOptionPane.showMessageDialog(null, "Volume Balok: " + hasilBalok);

        // Mengambil input untuk tabung
        String inputJariTabung = JOptionPane.showInputDialog("Masukkan jari-jari tabung:");
        double jariTabung = Double.parseDouble(inputJariTabung);
        
        String inputTinggiTabung = JOptionPane.showInputDialog("Masukkan tinggi tabung:");
        double tinggiTabung = Double.parseDouble(inputTinggiTabung);
        
        double hasilTabung = volumeTabung(jariTabung, tinggiTabung);
        JOptionPane.showMessageDialog(null, "Volume Tabung: " + hasilTabung);

        System.exit(0); // Menutup program
    }
}
