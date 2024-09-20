import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner v = new Scanner(System.in);
        System.out.print("Masukkan jumlah deret angka fibonaci : ");
        int angka = v.nextInt();
        long[] array = new long[angka];
        for (int o = 0; o < angka; o++) {
            if (o == 0 || o == 1) {
                array[o] = o;
            } else {
                array[o] = array[o - 1] + array[o - 2];
            }
        }
        // for (int x = 0; x < angka; x++) {
        //     System.out.print(array[x] + " ");
        // }
        // System.out.println();
        System.out.print("Masukkan jumlah deret angka fibonaci yang akan dicari : ");
        int cari = v.nextInt();
    }
}