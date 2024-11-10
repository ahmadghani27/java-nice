package Week13;

public class DetailedEmployeeRecord extends EmployeeRecord {
    private String kompetensi;
    private double gaji;

    public DetailedEmployeeRecord(String nama, String alamat, int usia, String posisi, String kompetensi, double gaji) {
        super(nama, alamat, usia, posisi); // Memanggil konstruktor superclass
        this.kompetensi = kompetensi;
        this.gaji = gaji;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Menampilkan informasi dasar
        System.out.println("Kompetensi: " + kompetensi);
        System.out.println("Gaji: " + gaji);
    }
}