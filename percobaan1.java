public class percobaan1 {
    public static void main(String[] args) {
        int tabel[][]={{1,2,3,4},{5,6,7,8}};
        System.out.println("Jumlah baris = "+tabel.length);
        System.out.println("Jumlah kolom = "+tabel[0].length);
        System.out.println();
        for(int o=0;o<tabel.length;o++){
            for(int oo=0;oo<tabel[0].length;oo++){
                System.out.print(tabel[o][oo]+" ");
            }
            System.out.println();
        }
    }
}
