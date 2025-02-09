
public class powFun {

    public static int pow(int x, int n, int d) {
        long base = x % d;
        long result = 1;
        long exponent = n;

        if (base < 0) {
            base += d;
        }

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % d;
            }
            base = (base * base) % d;
            exponent /= 2;
        }

        return (int) (result % d);
    }
    public static void main(String[] args) {
      int x = 2;
      int n = 3;
      int d = 3;

      System.out.println(pow(x, n, d));
    }
}
