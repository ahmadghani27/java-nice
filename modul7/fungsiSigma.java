package modul7;

import java.util.Scanner;

public class fungsiSigma {

    public static int calculateSigma(int x, int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (x + 2 * i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nilai x: ");
        int x = scanner.nextInt();

        System.out.print("Masukkan nilai n: ");
        int n = scanner.nextInt();

        int result = calculateSigma(x, n);
        System.out.println("Hasil dari sigma (y) adalah: " + result);

        scanner.close();
    }
}
