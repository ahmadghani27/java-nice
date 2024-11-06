
public class Implements implements Interface {

    private double x1, x2, y1, y2;

    public Implements(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double getLength() {
        double length = Math.sqrt((x2 - x1) * (x2 - x1)
                + (y2 - y1) * (y2 - y1));
        return length;
    }

    public boolean isGreater(Object a, Object b) {
        double aLen = ((Implements) a).getLength();
        double bLen = ((Implements) b).getLength();
        return (aLen > bLen);
    }

    public boolean isLess(Object a, Object b) {
        double aLen = ((Implements) a).getLength();
        double bLen = ((Implements) b).getLength();
        return (aLen < bLen);
    }

    public boolean isEqual(Object a, Object b) {
        double aLen = ((Implements) a).getLength();
        double bLen = ((Implements) b).getLength();
        return (aLen == bLen);
    }

    public static void main(String[] args) {
        Implements line1 = new Implements(0, 3, 0, 4); 
        Implements line2 = new Implements(0, 1, 0, 1); 

        System.out.println("Line 1 Length: " + line1.getLength());
        System.out.println("Line 2 Length: " + line2.getLength());

        System.out.println("Line 1 is greater than Line 2: " + line1.isGreater(line1, line2));
        System.out.println("Line 1 is less than Line 2: " + line1.isLess(line1, line2));
        System.out.println("Line 1 is equal to Line 2: " + line1.isEqual(line1, line2));
    }
}
