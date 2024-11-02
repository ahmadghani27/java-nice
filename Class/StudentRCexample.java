package Class;

public class StudentRCexample {
    public static void main(String[] args) {
        System.out.println();
        StudentRecord iwanRecord = new StudentRecord();
        iwanRecord.setName("Iwan Perdamaean");
        iwanRecord.setAddress("Riau");
        iwanRecord.setAge(17);
        iwanRecord.setMathG((double) 88);
        iwanRecord.setEnglishG((double) 95.5);
        iwanRecord.setScienceG((double) 100);
        // overload
        iwanRecord.print(iwanRecord.getName());
        iwanRecord.print(iwanRecord.getAverage(), iwanRecord.getEnglishG(),
                iwanRecord.getMathG(),
                iwanRecord.getScienceG());

        System.out.println();

        StudentRecord ediRecord = new StudentRecord();
        ediRecord.setName("Edi Suharto");
        ediRecord.setAddress("Jawa Tengah");
        ediRecord.setAge(15);
        ediRecord.setMathG((double) 95);
        ediRecord.setEnglishG((double) 95.5);
        ediRecord.setScienceG((double) 91.5);
        // overload
        ediRecord.print(ediRecord.getName());
        ediRecord.print(ediRecord.getAverage(), ediRecord.getEnglishG(),
                ediRecord.getMathG(),
                ediRecord.getScienceG());

    }
}

