import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {
      public static int longestConsecutive(int[] nums){
            Set<Integer> hashSet = new HashSet<>();
            for(int num : nums){
                  hashSet.add(num);
            }
            int longestStreak = 0;
            for(int num : nums){
                  if(!hashSet.contains(num-1)){
                        int currentNum = num;
                        int currStreak = 1;

                        while(hashSet.contains(currentNum + 1)){
                              currentNum += 1;
                              currStreak += 1;
                        }
                        longestStreak = Math.max(longestStreak, currStreak);
                  }
            }
            return longestStreak;
      }
      public static void main(String[] args) {
            int[] nums = {100, 4, 200, 1, 3, 2};
            System.out.println(longestConsecutive(nums));
      }
}
