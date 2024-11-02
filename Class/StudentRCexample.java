package Class;

public class StudentRCexample {
    public static void main(String[] args) {
        StudentRecord annaRecord = new StudentRecord();
        annaRecord.setName("Anna");
        annaRecord.setAddress("Philippines");
        annaRecord.setAge(15);
        annaRecord.setMathG((double) 80);
        annaRecord.setEnglishG((double) 95.5);
        annaRecord.setScienceG((double) 100);
        // overload
        annaRecord.print(annaRecord.getName());
        annaRecord.print(annaRecord.getAverage(), annaRecord.getEnglishG(),
                annaRecord.getMathG(),
                annaRecord.getScienceG());

    }
}

