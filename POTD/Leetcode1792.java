import java.util.PriorityQueue;

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

    public static double maxAverageRatio2(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int i = 0; i < n; i++) {
            double currentPR = (double) classes[i][0] / classes[i][1];
            double newPR = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double delta = newPR - currentPR;
            pq.offer(new double[]{delta, i});
        }
        while (extraStudents-- > 0) {
            double[] curr = pq.poll();
            int idx = (int) curr[1];
            classes[idx][0]++;
            classes[idx][1]++;
            double currentPR = (double) classes[idx][0] / classes[idx][1];
            double newPR = (double) (classes[idx][0] + 1) / (classes[idx][1] + 1);
            double delta = newPR - currentPR;
            pq.offer(new double[]{delta, idx});
        }
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result += (double) classes[i][0] / classes[i][1];
        }

        return result / n;
    }

    public static void main(String[] args) {
      int classes[][] = {
            {1,2}, {3,5}, {2,2}
      };
      int extraStudents = 2;
      System.out.println(maxAverageRatio(classes, extraStudents));
      System.out.println(maxAverageRatio2(classes, extraStudents));
    }
}
