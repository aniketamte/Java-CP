
public class Leetcode837 {

    public double new21Game(int n, int k, int maxPts) {
        double[] P = new double[n + 1];
        // P[i] = probability of getting score = i

        P[0] = 1.0; // Initially, probability of score 0 is 1
        double currProbabSum = (k > 0 ? 1.0 : 0.0);

        for (int i = 1; i <= n; i++) {
            // Probability to reach i = average of last 'maxPts' probabilities
            P[i] = currProbabSum / maxPts;

            // If i < k, we can still draw more numbers, so add P[i] into sum
            if (i < k) {
                currProbabSum += P[i];
            }

            // Remove contribution that goes out of the sliding window
            if (i - maxPts >= 0 && i - maxPts < k) {
                currProbabSum -= P[i - maxPts];
            }
        }

        // Answer = sum of probabilities from k to n
        double ans = 0.0;
        for (int i = k; i <= n; i++) {
            ans += P[i];
        }
        return ans;
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        Leetcode837 sol = new Leetcode837();

        // Example test cases (from LeetCode problem statement)
        int n1 = 10, k1 = 1, maxPts1 = 10;
        System.out.println("Result 1: " + sol.new21Game(n1, k1, maxPts1));

        int n2 = 6, k2 = 1, maxPts2 = 10;
        System.out.println("Result 2: " + sol.new21Game(n2, k2, maxPts2));

        int n3 = 21, k3 = 17, maxPts3 = 10;
        System.out.println("Result 3: " + sol.new21Game(n3, k3, maxPts3));
    }
}
