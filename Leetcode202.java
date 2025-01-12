public class Leetcode202 {
      public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSq(slow);
            fast = findSq(findSq(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private static int findSq(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {
      int n  = 19; 
      System.out.println(isHappy(n));
    }
}
