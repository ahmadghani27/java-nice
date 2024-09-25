public class percobaan6 {
    public static void main(String[] args) {
        String data [][] = {
            {"ABDUL", "085646668991", "Kediri"}, 
            {"KUSNO", "085646668992", "Trenggalek"},
            {"PONIRAN", "085646668999", "Bojonegoro"}};
        String header [] = {"NAMA","NOMOR","ALAMAT"};
        int i,ii;
        for(ii=0;ii<header.length;ii++){
                if(ii== 0){
                    System.out.print("|"+header[ii]+"   \t"+"|"+"");
                }
                if(ii== 1){
                    System.out.print(header[ii]+"   \t"+"|"+"");
                }
                if(ii== 2){
                    System.out.print(header[ii]+"   \t|");
            }
        }
        System.out.println();
        for(i=0;i<data.length;i++){
            for(ii=0;ii<data[i].length;ii++){
                if(ii== 0){
                    System.out.print("|"+data[i][ii]+"   \t"+"|"+"");
                }
                if(ii== 1){
                    System.out.print(data[i][ii]+"\t"+"|"+"");
                }
                if(ii== 2){
                    System.out.print(data[i][ii]+"   \t|");
                }
            }
            System.out.println();
        }
    }
}
