public class EmployeeRecord extends SuperSubClass {
    protected int usia;
    protected String posisi;

    // Constructor
    public EmployeeRecord(String nama, String alamat, int usia, String posisi) {
        super(nama, alamat); // Memanggil konstruktor superclass
        this.usia = usia;
        this.posisi = posisi;
    }

    // Method to display employee information
    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Usia: " + usia);
        System.out.println("Posisi: " + posisi);
    }
}