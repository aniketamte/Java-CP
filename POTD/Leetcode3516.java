public class Leetcode3516 {
    public static int findClosest(int x, int y, int z) {
        int d1 = Math.abs(z - x);
        int d2 = Math.abs(z - y);
        if (d1 < d2) {
            return 1;
        } else if (d1 > d2) {
            return 2;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
      int x = 2, y = 7, z = 4;
      System.out.println(findClosest(x, y, z));
    }
}
