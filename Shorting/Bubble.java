import java.util.*;

public class Bubble {
    public static void main(String[] args) {
        int jml, i, j, temp;
        Scanner scan = new Scanner(System.in);
        jml = scan.nextInt();
        int array[] = new int[jml];
        System.out.println("Masukkan " + jml + " buah bilangan Integer");
        for (i = 0; i < jml; i++) {
            System.out.print("Bilangan ke- " + (i + 1) + " =");
            array[i] = scan.nextInt();
        }
        for (i = 0; i < jml - 1; i++) {
            for (j = 0; j < jml - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("\nBilangan terurut = ");
        for (i = 0; i < jml; i++) {
            System.out.print(array[i] + " ");
        }
    }
}