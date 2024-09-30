package modul7;
public class bacaKonsol2 {
    public static void main(String args[]){
        System.out.print("data1 = ");
        inputconsole ic = new inputconsole();
        int data1 = ic.readInt();
        
        System.out.print("data2 = ");
        int data2 = ic.readInt();
        
        int data3 = data1 + data2;
        System.out.println("data1 + data2 = " + data3);
    }
}
