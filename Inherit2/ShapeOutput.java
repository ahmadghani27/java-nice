public class ShapeOutput {
    public static void main(String[] args) {
        // Membuat objek Circle
        Shape circle = new Circle(5); // Radius 5
        System.out.println(circle.getName() + " Area: " + circle.getArea());

        // Membuat objek Square
        Shape square = new Square(4); // Sisi 4
        System.out.println(square.getName() + " Area: " + square.getArea());
    }
}