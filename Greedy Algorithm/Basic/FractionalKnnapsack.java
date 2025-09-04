import java.util.*;
public class FractionalKnnapsack {
      public static void main(String[] args) {
            int val[] = {60, 100, 120};
            int weight[] = {10, 20, 30};
            int W = 50;

            double ratio[][] = new double[val.length][2];

            //0th col => idx;  1st col ==> ratiom
            for(int i=0; i<val.length; i++){
                  ratio[i][0] = i;
                  ratio[i][1] = val[i] / (double) weight[i];
            }

            //Acsending order sorting
            Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

            int Capacity = W;
            int finalAns = 0;

            for(int i=ratio.length-1; i>=0; i--){
                  int idx = (int) ratio[i][0];
                  if(Capacity >= weight[idx]){
                        //include full item
                        finalAns += val[idx];
                        Capacity -= weight[idx];
                  } else{
                        //include fractional item
                        finalAns += (ratio[i][1] * Capacity);
                        Capacity=0;
                        break;
                  }
            }
            System.out.println("Final Value = " + finalAns);
      }
}
