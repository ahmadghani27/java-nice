package Week13;

public class EmployeeRecord extends SuperSubClass {
    protected int usia;
    protected String posisi;

    public EmployeeRecord(String nama, String alamat, int usia, String posisi) {
        super(nama, alamat); 
        this.usia = usia;
        this.posisi = posisi;
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Usia: " + usia);
        System.out.println("Posisi: " + posisi);
    }
}