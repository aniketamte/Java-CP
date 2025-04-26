import java.util.Stack;

public class StockSpaProblem {
      public static int[] stackSpan(int price[], int ans[]) {
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < price.length; i++) {
                  while (!s.isEmpty() && price[s.peek()] <= price[i]) {
                        s.pop();
                  }
                  if (s.isEmpty()) {
                        ans[i] = i + 1;
                  } else {
                        ans[i] = i - s.peek();
                  }
                  s.push(i);
            }
            return ans;
      }

      public static void main(String[] args) {
            int price[] = { 100, 80, 60, 70, 60, 75, 85 };
            int ans[] = new int[price.length];
            ans = stackSpan(price, ans);

            for (int span : ans) {
                  System.out.print(span + " ");
            }
      }
}