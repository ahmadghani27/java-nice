public class MainEMployee {
    public static void main(String[] args) {
        // Creating an instance of DetailedEmployeeRecord
        DetailedEmployeeRecord karyawan1 = new DetailedEmployeeRecord(
                "John Doe",
                "Jl. Mawar No. 10",
                30,
                "Software Engineer",
                "Java, Spring, SQL",
                7500000.00
        );

        // Displaying employee information
        karyawan1.displayInfo();
    }
}