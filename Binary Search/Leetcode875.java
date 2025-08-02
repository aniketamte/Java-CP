import java.util.Arrays;

public class Leetcode875 {
      public static int minEatingSpeed(int[] piles, int h) {
            int n = piles.length;
            int l = 1;
            int r = Arrays.stream(piles).max().getAsInt();
            while (l < r) {
                  int mid = l + (r - l) / 2; // Per hour I can eat mid number of Bananas
                  if (canEatAll(piles, mid, h)) {
                        r = mid;
                  } else {
                        l = mid + 1;
                  }
            }
            return l;
      }

      public static boolean canEatAll(int piles[], int mid, int h) {
            int actualHours = 0;
            for (int x : piles) {
                  actualHours += x / mid; // hours
                  if (x % mid != 0) {
                        actualHours++;
                  }
            }
            return actualHours <= h;
      }

      public static void main(String[] args) {
            int piles[] = { 3, 7, 8, 11 };
            int h = 8;
            System.out.println(minEatingSpeed(piles, h));
      }
}