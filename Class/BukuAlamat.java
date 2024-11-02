package Class;

import java.util.ArrayList;
import java.util.List;

public class BukuAlamat {
    private List<Kontak> kontakList;

    public BukuAlamat() {
        kontakList = new ArrayList<>();
    }

    public void tambahKontak(Kontak kontak) {
        kontakList.add(kontak);
    }

    public void hapusKontak(int UrutKontak) {
        if (UrutKontak > 0 && UrutKontak <= kontakList.size()) {
            kontakList.remove(UrutKontak);
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    public void tampilkanKontak() {
        if (kontakList.isEmpty()) {
            System.out.println("Buku alamat kosong.");
        } else {
            for (int i = 0; i < kontakList.size(); i++) {
                System.out.println("Kontak ke-" + (i + 1) + ":");
                System.out.println(kontakList.get(i));
                System.out.println("-----------------------------");
            }
        }
    }

    public void updateKontak(int UrutKontak, Kontak kontakBaru) {
        if (UrutKontak > 0 && UrutKontak <= kontakList.size()) {
            kontakList.set(UrutKontak, kontakBaru);
        } else {
            System.out.println("Index tidak valid.");
        }
    }
}

class Kontak {
    private String nama;
    private String alamat;
    private String nomorTelepon;
    private String alamatEmail;

    public Kontak(String nama, String alamat, String nomorTelepon, String alamatEmail) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
        this.alamatEmail = alamatEmail;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getAlamatEmail() {
        return alamatEmail;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + "\nAlamat: " + alamat + "\nNomor Telepon: " + nomorTelepon + "\nAlamat Email: "
                + alamatEmail;
    }
}
