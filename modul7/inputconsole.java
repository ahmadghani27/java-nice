package modul7;
import java.io.*;
public class inputconsole {
    public static String readString(){
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String string = " ";
        try {
            string = bfr.readLine();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return string;
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }

    public static double readDouble(){
        return Double.parseDouble(readString());
    }
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

