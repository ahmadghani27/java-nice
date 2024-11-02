package Class;

public class DataBukuAlamat {
    public static void main(String[] args) {
        BukuAlamat bukuAlamat = new BukuAlamat();

        bukuAlamat.tambahKontak(new Kontak("Andi Setiawan", "Jl. Merpati No. 10", "08123456780", "andi.setiawan@email.com"));
        bukuAlamat.tambahKontak(new Kontak("Siti Nurhaliza", "Jl. Kenanga No. 15", "08987654322", "siti.nurhaliza@email.com"));
        bukuAlamat.tambahKontak(new Kontak("Budi Santoso", "Jl. Melati No. 25", "08123456781", "budi.santoso@email.com"));
        bukuAlamat.tambahKontak(new Kontak("Dewi Lestari", "Jl. Cempaka No. 30", "08987654323", "dewi.lestari@email.com"));
        bukuAlamat.tambahKontak(new Kontak("Rudi Hartono", "Jl. Jati No. 5", "08123456782", "rudi.hartono@email.com"));
        bukuAlamat.tambahKontak(new Kontak("Fitriani", "Jl. Mawar No. 12", "08987654324", "fitriani@email.com"));
        bukuAlamat.tambahKontak(new Kontak("Toni Prabowo", "Jl. Puspa No. 8", "08123456783", "toni.prabowo@email.com"));
        bukuAlamat.tambahKontak(new Kontak("Nina Amalia", "Jl. Anggrek No. 3", "08987654325", "nina.amalia@email.com"));

        bukuAlamat.tampilkanKontak();
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("-----------------------------");

        bukuAlamat.hapusKontak(1);
        bukuAlamat.hapusKontak(2);
        bukuAlamat.hapusKontak(3);
        bukuAlamat.tampilkanKontak();
        System.out.println("|||||||||||||||||||||||||||||");
        System.out.println("-----------------------------");


        bukuAlamat.updateKontak(1, new Kontak("Rizky Pratama", "Jl. Bunga No. 20", "08123456784", "rizky.pratama@email.com"));
        bukuAlamat.updateKontak(2, new Kontak("Prabowo", "Jl. Cendana No. 7", "08987654326", "prab.prabowo@email.com"));
        bukuAlamat.updateKontak(3, new Kontak("Joko Widodo", "Jl. Pahlawan No. 1", "08123456785", "joko.widodo@email.com"));

        bukuAlamat.tampilkanKontak();
    }
}
