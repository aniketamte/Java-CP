public class fractionalKnapsack {
      //Fractional Knapsack problem ====> Greedy Algorithm
      //15-03-2025
      public static void main(String[] args) {
            int val[] = {60, 100, 120};
            int weight[]= {10, 20, 30};
            int W = 50;

            double ratio[][] = new double[val.length][2];
            //0th col ==>idx; 1st col ==> ratio

            for(int i=0; i<val.length; i++){
                  ratio[i][0] = i;
                  ratio[i][1] = val[i] / (double)weight[i];
            }
      }
}
