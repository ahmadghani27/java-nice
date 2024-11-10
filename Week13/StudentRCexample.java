import Week13.ComputerScience;

public class StudentRCexample {
    public static void main(String[] args) {
        System.out.println();
        ComputerScience iwanRecord = new ComputerScience();
        iwanRecord.setName("Iwan Perdamaean");
        iwanRecord.setAddress("Riau");
        iwanRecord.setAge(17);
        iwanRecord.setMathG(88.0);
        iwanRecord.setEnglishG(95.5);
        iwanRecord.setScienceG(100.0);
        iwanRecord.setComputerScienceG(90.0); 
        iwanRecord.print(iwanRecord.getName());
        iwanRecord.print(iwanRecord.getAverage(), iwanRecord.getEnglishG(), iwanRecord.getMathG(), iwanRecord.getScienceG());

        System.out.println();
        ComputerScience ediRecord = new ComputerScience();
        ediRecord.setName("Edi Suharto");
        ediRecord.setAddress("Jawa Tengah");
        ediRecord.setAge(15);
        ediRecord.setMathG(95.0);
        ediRecord.setEnglishG(95.5);
        ediRecord.setScienceG(91.5);
        ediRecord.setComputerScienceG(88.0); 
        ediRecord.print(ediRecord.getName());
        ediRecord.print(ediRecord.getAverage(), ediRecord.getEnglishG(), ediRecord.getMathG(), ediRecord.getScienceG());
    }
}