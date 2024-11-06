
public class Square extends Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String getName() {
        return "Square";
    }

    public double getSide() {
        return side;
    }
}
