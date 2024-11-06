
public class StudentRecord {
    private String name;
    private int studentId;

    public StudentRecord(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getRecord() {
        return "Name: " + name + ", ID: " + studentId;
    }
}
