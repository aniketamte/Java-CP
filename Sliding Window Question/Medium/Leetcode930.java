import java.util.HashMap;

public class Leetcode930 {
      public static int numSubarraysWithSum(int[] nums, int goal){
            int n = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int currSum = 0;

            map.put(0, 1);

            for(int num : nums){
                  currSum += num;
                  if(map.containsKey(currSum - goal)){
                        count += map.get(currSum - goal);
                  }
                  map.put(currSum, map.getOrDefault(currSum, 0) + 1);
            }
            return count;
      }
      public static void main(String[] args) {
            int[] nums = {1, 1, 1, 1, 1};
            int goal = 2;
            System.out.println(numSubarraysWithSum(nums, goal));
      }
}
