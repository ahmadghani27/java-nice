public class percobaan3 {
    public static void main(String[] args) {
        int data2[][] = {{4, 6, 4, 2, 8, 4, 2, 10}, {4, 6, 4, 2, 8, 4, 2, 10}};
        int o = 0;

        while (o < data2.length) {
            int oo = 0;
            while (oo < data2[o].length) {
                System.out.print(data2[o][oo] + " ");
                oo++;
            }
            o++;
            System.out.println("\n");
        }

        o = 0;
        do {
            int oo = 0;
            while (oo < data2[o].length) {
                System.out.print(data2[o][oo] + " ");
                oo++;
            }
            o++;
            System.out.println("\n");
        } while (o < data2.length);
        int d1=0;
        int jumlah=0;
        for (int r=0;r<data2.length;r++){
            for(int rr=0;rr<data2[r].length;rr++){
                jumlah += data2[r][rr];
                d1=r+rr;
            }
        }
        double ratarata = jumlah/d1;
        System.out.println("Rata-rata data adalah "+ ratarata);
    }
}
