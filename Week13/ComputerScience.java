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
        double total = super.getMathG() + super.getEnglishG() + super.getScienceG() + computerScienceG;
        return total / 4; 
    }

    @Override
    public void print(String temp) {
        super.print(temp); 
    }

    @Override
    public void print(double getAverage, double englishG, double mathG, double scienceG) {
        super.print(getAverage, englishG, mathG, scienceG); 
        System.out.println("Computer Science Grade\t: " + computerScienceG);
        System.out.println("Average (including CS)\t: " + getAverage());
    }
}