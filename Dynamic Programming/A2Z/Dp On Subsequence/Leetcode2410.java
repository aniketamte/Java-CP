import java.util.*;
public class Leetcode2410 {
      public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);

            int m = players.length;
            int n = trainers.length;

            int i = 0, j = 0;
            int count = 0;

            while (i < m && j < n) {
                  if (trainers[j] >= players[i]) {
                        i++;
                        count++;
                  }
                  j++;
            }
            return count;
      }
      public static void main(String[] args) {
            int[] players = { 4, 7, 9};
            int[] trainers = {8, 2, 5, 8};
            System.out.println(matchPlayersAndTrainers(players, trainers));
      }
}
