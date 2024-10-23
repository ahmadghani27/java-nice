public class Selection {
    public static void main(String[] args) {
        int[] tabel = { 2, 4, 3, 1, 6, 7, 4, 9, 4, 8 };
        int p, k, j;
        p = tabel.length;
        for (k = 0; k < p; k++) {
            int min = tabel[k];
            int pos = k;
            for (j = k; j < p; j++) {
                if (tabel[j] < min) {
                    min = tabel[j];
                    pos = j;
                }
            }
            if (k != pos) {
                int temp = tabel[k];
                tabel[k] = tabel[pos];
                tabel[pos] = temp;
            }
        }
        for (k = 0; k < tabel.length; k++) {
            System.out.print(tabel[k] + " ");
        }
    }
}