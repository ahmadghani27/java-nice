
import java.util.List;

public class ComputerKnowledgeStudentRecord extends StudentRecord {
    private List<String> programmingLanguages;
    private String proficiencyLevel;

    public ComputerKnowledgeStudentRecord(String name, String address, int age, double mathG, double englishG, double scienceG, List<String> programmingLanguages, String proficiencyLevel) {
        setName(name);
        setAddress(address);
        setAge(age);
        setMathG(mathG);
        setEnglishG(englishG);
        setScienceG(scienceG);
        this.programmingLanguages = programmingLanguages;
        this.proficiencyLevel = proficiencyLevel;
    }

    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    @Override
    public void print(String name) {
        super.print(name);
        System.out.println("Proficiency Level: " + proficiencyLevel);
        System.out.println("Programming Languages: " + String.join(", ", programmingLanguages));
    }
}