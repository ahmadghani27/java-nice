package Exception;

public class _1 {
    public static void main(String[] args) {
        _1 f5 = new _1();
        f5.coba(5);
        f5.coba(4);
    }

    public void coba(int b) {
        int a = 1;
        if (b == 0 || b == 1) {
            a = 1;
        } else {
            for (int i = 1; i <= b; i++) {
                a *= i;
            }
        }
        System.out.println(b + "! = " + a);
    }
}