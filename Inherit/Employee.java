
public class Employee extends SuperSubClass {
    public static void main(String[] args) {        
    SuperSubClass ref;
    Student studentObject = new Student();
    Employee employeeObject = new Employee();

    ref = studentObject;
    String temp = ref.getNama();
    System.out.println(temp);
    
    ref = employeeObject;    
    String temp2 = ref.getNama();
    System.out.println(temp2);    
    }

    public String getNama(){
        System.out.println("Employee Name: " + nama);
        return nama; 
    }
}