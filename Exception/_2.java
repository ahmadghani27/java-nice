package Exception;

public class _2 {
    public static void main(String[] args) {
        _2 o = new _2();
        o.segiempat(20, 5);
    }

    public void segiempat(int p, int l) {
        double L, K;
        L = p * l;
        K = (p + l) * 2;
        System.out.println("Panjang = " + p);
        System.out.println("Lebar = " + l);
        System.out.println("Luas = " + L);
        System.out.println("Keliling = " + K);
    }
}