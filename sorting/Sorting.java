import java.io.*;
import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Input n angka dari pengguna
        System.out.print("Masukkan jumlah angka: ");
        int n = scan.nextInt();
        int[] data = new int[n];
        System.out.println("Masukkan " + n + " angka:");
        for (int i = 0; i < n; i++) {
            data[i] = scan.nextInt();
        }

        // Memilih opsi algoritma sorting
        System.out.println("Pilih algoritma sorting:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Merge Sort");
        int opsi = scan.nextInt();

        long waktuMulai, waktuAkhir;
        int[] terurut = new int[n];
        String algoritma = "";

        // Melakukan sorting
        switch (opsi) {
            case 1:
                algoritma = "Bubble Sort";
                terurut = Arrays.copyOf(data, n);
                waktuMulai = System.nanoTime();
                bubbleSort(terurut);
                waktuAkhir = System.nanoTime();
                break;
            case 2:
                algoritma = "Quick Sort";
                terurut = Arrays.copyOf(data, n);
                waktuMulai = System.nanoTime();
                quickSort(terurut, 0, n - 1);
                waktuAkhir = System.nanoTime();
                break;
            case 3:
                algoritma = "Merge Sort";
                terurut = Arrays.copyOf(data, n);
                waktuMulai = System.nanoTime();
                mergeSort(terurut, 0, n - 1);
                waktuAkhir = System.nanoTime();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        // Menampilkan hasil sorting
        System.out.println("Hasil sorting menggunakan " + algoritma + ":");
        System.out.println(Arrays.toString(terurut));

        // Menghitung waktu eksekusi
        long executionTime = waktuAkhir - waktuMulai;
        System.out.println("Waktu eksekusi: " + executionTime + " nanodetik");

        // Menyimpan hasil ke dalam file tanpa menghapus data yang sudah ada
        simpanData(algoritma, terurut, executionTime);

        // Analisis kompleksitas waktu
        System.out.println("Analisis Kompleksitas Waktu:");
        analisaKompleks(algoritma);

        scan.close();
    }

    // Algoritma Bubble Sort
    public static void bubbleSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // Algoritma Quick Sort
    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    public static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;
        return i + 1;
    }

    // Algoritma Merge Sort
    public static void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    public static void merge(int[] data, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = data[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = data[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                data[k] = L[i];
                i++;
            } else {
                data[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            data[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            data[k] = R[j];
            j++;
            k++;
        }
    }

    // Menyimpan hasil ke file tanpa menghapus data yang sudah ada
    public static void simpanData(String algoritma, int[] terurut, long executionTime) {
        File file = new File("hasil_sorting.txt");
        boolean fileBaru = false;

        // Cek apakah file baru dibuat
        if (!file.exists()) {
            try {
                fileBaru = file.createNewFile(); // Mencoba membuat file baru
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter tulis = new FileWriter(file, true)) {
            // Jika file baru, tulis penjelasan tentang kompleksitas
            if (fileBaru) {
                tulis.write("Penjelasan Kompleksitas Waktu:\n");
                tulis.write("O(n): Kompleksitas terbaik, di mana algoritma melakukan tugasnya dalam waktu linear.\n");
                tulis.write(
                        "O(n log n): Kompleksitas terbaik untuk banyak algoritma sorting, di mana waktu eksekusi tumbuh lebih lambat dibandingkan dengan O(n^2).\n");
                tulis.write(
                        "O(n^2): Kompleksitas terburuk untuk algoritma seperti Bubble Sort dan Insertion Sort, di mana waktu eksekusi tumbuh dengan kuadrat dari jumlah elemen.\n");
                tulis.write("\n---------------------------------------\n");
            }
            tulis.write("Hasil sorting menggunakan " + algoritma + ":\n");
            tulis.write(Arrays.toString(terurut) + "\n");
            tulis.write("Waktu eksekusi: " + executionTime + " nanodetik\n");
            tulis.write("Analisis Kompleksitas Waktu:\n");
            analisaKomplesFile(tulis, algoritma);
            tulis.write("\n---------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Analisis kompleksitas waktu untuk ditampilkan di layar
    public static void analisaKompleks(String algoritma) {
        switch (algoritma) {
            case "Bubble Sort":
                System.out.println("Kasus Terbaik: O(n)");
                System.out.println("Kasus Rata-rata: O(n^2)");
                System.out.println("Kasus Terburuk: O(n^2)");
                break;
            case "Quick Sort":
                System.out.println("Kasus Terbaik: O(n log n)");
                System.out.println("Kasus Rata-rata: O(n log n)");
                System.out.println("Kasus Terburuk: O(n^2)");
                break;
            case "Merge Sort":
                System.out.println("Kasus Terbaik: O(n log n)");
                System.out.println("Kasus Rata-rata: O(n log n)");
                System.out.println("Kasus Terburuk: O(n log n)");
                break;
        }
    }

    // Analisis kompleksitas waktu untuk disimpan ke file
    public static void analisaKomplesFile(FileWriter writer, String algoritma) throws IOException {
        switch (algoritma) {
            case "Bubble Sort":
                writer.write("Kasus Terbaik: O(n)\n");
                writer.write("Kasus Rata-rata: O(n^2)\n");
                writer.write("Kasus Terburuk: O(n^2)\n");
                break;
            case "Quick Sort":
                writer.write("Kasus Terbaik: O(n log n)\n");
                writer.write("Kasus Rata-rata: O(n log n)\n");
                writer.write("Kasus Terburuk: O(n^2)\n");
                break;
            case "Merge Sort":
                writer.write("Kasus Terbaik: O(n log n)\n");
                writer.write("Kasus Rata-rata: O(n log n)\n");
                writer.write("Kasus Terburuk: O(n log n)\n");
                break;
        }
    }
}
