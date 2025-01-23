
public class KnapsackProblem01 {

    public static int knapsanck(int val[], int wt[], int W, int n) {
        //W = Capacity of Bag  
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {  //Valid condition
            //include

            int ans1 = val[n - 1] + knapsanck(val, wt, W - wt[n - 1], n - 1);

            //exlude
            int ans2 = knapsanck(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        } else {
            //Not valid Condition
            return knapsanck(val, wt, W, n - 1);
        }
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(knapsanck(val, wt, W, val.length));
    }
}
