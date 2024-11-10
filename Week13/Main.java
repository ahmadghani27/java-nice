abstract class Shape {
    abstract double getArea();
    abstract String getName();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    String getName() {
        return "Circle";
    }

    public double getRadius() {
        return radius;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    double getArea() {
        return side * side;
    }

    @Override
    String getName() {
        return "Square";
    }

    public double getSide() {
        return side;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(28);
        Shape square = new Square(20);

        System.out.println("Shape: " + circle.getName() + ", Area: " + circle.getArea());
        System.out.println("Shape: " + square.getName() + ", Area: " + square.getArea());
    }
}