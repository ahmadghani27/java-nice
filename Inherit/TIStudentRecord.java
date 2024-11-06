
public class TIStudentRecord extends StudentRecord {

    private String programmingLanguages;

    public TIStudentRecord(String name, int studentId, String programmingLanguages) {
        super(name, studentId);
        this.programmingLanguages = programmingLanguages;
    }

    @Override
    public String getRecord() {
        return super.getRecord() + ", Programming Languages: " + programmingLanguages;
    }

    public static void main(String[] args) {
        TIStudentRecord csStudent = new TIStudentRecord("Alice", 12345, "Java, Python, C++");

        System.out.println(csStudent.getRecord());
    }

}
