public class percobaan3 {
    public static void main(String[] args) {
        int data2[][]={{4,6,4,2,8,4,2,11},{4,6,4,2,8,4,2,10}};
        int o=0;
        // While
        while (o<data2.length) {
            int oo=0;
            while (oo<data2[o].length) {
                System.out.print(data2[o][oo]+" ");
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
    }
}
