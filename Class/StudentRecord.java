package Class;

public class StudentRecord {
    private String name;
    private String address;
    private int age;
    private double mathG;
    private double englishG;
    private double scienceG;
    private double average;
    public static int studentCount;

    public void setName(String temp) {
        this.name = temp;
    }

    public void setAddress(String temp) {
        this.address = temp;
    }

    public void setAge(int temp) {
        this.age = temp;
    }

    public void setMathG(Double temp) {
        this.mathG = temp;
    }

    public void setEnglishG(Double temp) {
        this.englishG = temp;
    }

    public void setScienceG(Double temp) {
        this.scienceG = temp;
    }

    public String getName() {
        return name;
    }

    public String getAddres() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public double getAverage() {
        average = (mathG + englishG + scienceG) / 3;
        return average;
    }

    public double getMathG() {
        return mathG;
    }

    public double getScienceG() {
        return scienceG;
    }

    public double getEnglishG() {
        return englishG;
    }

    public void print(String temp) {
        System.out.println("Name\t\t:" + name);
        System.out.println("Address\t\t:" + address);
        System.out.println("Age\t\t:" + age);
    }

    public void print(double getAverage, double englishG, double mathG, double scienceG) {
        System.out.println("Math Grade\t:" + mathG);
        System.out.println("English Grade\t:" + englishG);
        System.out.println("Science Grade\t:" + scienceG);
        System.out.println("Average\t\t:" + average);
    }
}