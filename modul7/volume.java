package modul7;
import java.util.Scanner;

public class volume {
    public double luas_lingkaran(int diameter){
        int jari2 = diameter / 2;
        double luas = Math.PI * Math.pow(jari2, 2);
        return luas;
    }

    public void hitungLuasLingkaran(int jari2){
        double luas = Math.PI * Math.pow(jari2, 2);
        System.out.println("Luas Lingkaran: " + luas);
    }

    public double volume_tabung(int diameter, int tinggi){
        int jari2 = diameter / 2;
        double volume = Math.PI * Math.pow(jari2, 2) * tinggi;
        return volume;
    }

    public double volume_kerucut(int diameter, int tinggi){
        int jari2 = diameter / 2;
        double volume = (Math.PI * Math.pow(jari2, 2) * tinggi) / 3;
        return volume;
    }

    public double volume_bola(int diameter){
        int jari2 = diameter / 2;
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(jari2, 3);
        return volume;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        volume vol = new volume();  // Menggunakan objek `volume`

        System.out.print("Masukkan diameter: ");
        int diameter = scanner.nextInt();

        System.out.print("Masukkan tinggi (untuk tabung atau kerucut): ");
        int tinggi = scanner.nextInt();

        System.out.println("Volume Tabung: " + vol.volume_tabung(diameter, tinggi));
        System.out.println("Volume Kerucut: " + vol.volume_kerucut(diameter, tinggi));
        System.out.println("Volume Bola: " + vol.volume_bola(diameter));

        scanner.close();
        System.exit(0);
    }
}
