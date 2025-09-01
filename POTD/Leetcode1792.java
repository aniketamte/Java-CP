

public class Leetcode1792 {

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        double PR[] = new double[n];
        for (int i = 0; i < n; i++) {
            double ratio = (double) classes[i][0] / classes[i][1];
            PR[i] = ratio;
        }

        while (extraStudents-- > 0) {
            double[] updatedPR = new double[n];
            for (int i = 0; i < n; i++) {
                double newRatio = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
                updatedPR[i] = newRatio;
            }

            int bestClassIndex = 0;
            double bestDifference = 0.0;

            for(int i=0; i<n; i++){
                  double diff = updatedPR[i] - PR[i];
                  if(diff > bestDifference){
                        bestDifference = diff;
                        bestClassIndex = i;
                  }
            }
            PR[bestClassIndex] = updatedPR[bestClassIndex];
            classes[bestClassIndex][0]++;
            classes[bestClassIndex][1]++;
        }
        double result = 0.0; //AR
        for(int i=0; i<n; i++){
            result += PR[i];
        }
        return result/n;
    }
    public static void main(String[] args) {
      int classes[][] = {
            {1,2}, {3,5}, {2,2}
      };
      int extraStudents = 2;
      System.out.println(maxAverageRatio(classes, extraStudents));
    }
}
