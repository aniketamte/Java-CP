
import java.util.HashMap;

public class L560 {
    public static int subarraySum(int[] nums, int k) {
      HashMap<Integer, Integer> mp =new HashMap<>();
      int result = 0;
      int sum = 0;
      mp.put(0, 1);
      int n = nums.length;

      for(int i=0; i<n; i++){
            sum += nums[i];

            if(mp.containsKey(sum - k)){
                  result += mp.get(sum-k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
      }
      return result;
    }
    public static void main(String[] args) {
      int nums[] = {1, 1, 1};
      int k = 2;
      System.out.println(subarraySum(nums, k));
    }
}
