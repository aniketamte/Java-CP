public class Leetcode1614 {
    public static int maxDepth(String s) {
        int max = 0, curr = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                curr++;
                if (curr > max) {
                    max = curr;
                }
            } else if (ch == ')') {
                curr--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
      String s = "(1+(2*3)+((8)/4))+1";
      System.out.println(maxDepth(s));
     }
}
