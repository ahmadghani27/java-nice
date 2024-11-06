
public class Student extends SuperSubClass {
    public Student(){
        super("SomeNama", "SomeAddress");
        System.out.println("Di dalam Student: Konstruktor Student");
    }

    public String getNama(){
        System.out.println("Student: getName");
        return nama; 
    }    

    public static void main(String[] args) {
        Student Edi = new Student();
    }
}