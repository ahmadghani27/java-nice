package Week13;

public class ComputerScience extends StudentRecord {
    private double computerScienceG;

    public void setComputerScienceG(double temp) {
        this.computerScienceG = temp;
    }

    public double getComputerScienceG() {
        return computerScienceG;
    }

    @Override
    public double getAverage() {
        // Menghitung rata-rata termasuk nilai komputer
        double total = super.getMathG() + super.getEnglishG() + super.getScienceG() + computerScienceG;
        return total / 4; // Menghitung rata-rata dari 4 mata pelajaran
    }

    @Override
    public void print(String temp) {
        super.print(temp); // Memanggil metode print dari superclass
    }

    @Override
    public void print(double getAverage, double englishG, double mathG, double scienceG) {
        super.print(getAverage, englishG, mathG, scienceG); // Memanggil metode print dari superclass
        System.out.println("Computer Science Grade\t: " + computerScienceG);
        System.out.println("Average (including CS)\t: " + getAverage());
    }
}