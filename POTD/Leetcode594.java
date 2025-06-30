import java.util.*;
public class Leetcode594 {
      public static int findLHS(int[] nums){
            Map<Integer, Integer> map = new HashMap<>();
            int result = 0;

            for(int num : nums){
                  map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for(int num: nums){
                  int min = num;
                  int max = num + 1;
                  if(map.containsKey(max)){
                        result = Math.max(result, map.get(min) + map.get(max));
                  }
            }
            return result;
      }
      public static void main(String[] args) {
            int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7};
            System.out.println(findLHS(nums));
      }
}
