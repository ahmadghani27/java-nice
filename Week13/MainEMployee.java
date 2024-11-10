package Week13;

public class MainEMployee {

    public static void main(String[] args) {
        DetailedEmployeeRecord Edi = new DetailedEmployeeRecord(
                "Edi Lurah",
                "Jl. Sudirman No. 10",
                30,
                "Software Engineer",
                "Java, Spring, SQL",
                9000000.00
        );
        DetailedEmployeeRecord Iwan = new DetailedEmployeeRecord(
                "Iwan Awan",
                "Jl. Kaliurang No. 32",
                24,
                "Data Analyst",
                "Python, SQL",
                7500000.00
        );

        Edi.displayInfo();
        System.out.println("----------------------------------");
        Iwan.displayInfo();
    }
}
