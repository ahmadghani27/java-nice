package Exception;

import java.io.*;

public class _3 {
    public static String readString(){
        BufferedReader baca = new BufferedReader(new InputStreamReader(System.in));
        String kata ="";
        try{
            kata = baca.readLine();
        } catch(IOException ex){
            System.out.println(ex);
        } 
        return kata;
    }
    
    public static int readInt(){
        return Integer.parseInt(readString());
    }
    
    public static double readDouble(){
        return Double.parseDouble(readString());
    }

    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        String str = readString();
        System.out.println("You entered: " + str);

        System.out.print("Enter an integer: ");
        int num = readInt();
        System.out.println("You entered: " + num);

        System.out.print("Enter a double: ");
        double dbl = readDouble();
        System.out.println("You entered: " + dbl);
    }
}