
public class SuperSubClass {

    protected String nama, alamat;

    // default
    public SuperSubClass() {
        System.out.println("Di dalam SuperSubClass: Konstruktor Superclass");
        nama = "";
        alamat = "";
    }

    // dua parameter
    public SuperSubClass(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    // accessor
    public String getNama() {
        System.out.println("Parent: getName"); 
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String add) {
        this.alamat = add;
    }
}
