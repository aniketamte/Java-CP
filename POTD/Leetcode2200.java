import java.util.*;

public class Leetcode2200 {
      public static List<Integer> findKDistantIndices(int[] nums, int key, int k){
            int n = nums.length;
            List<Integer> res = new ArrayList<>();

            for(int j=0; j<n; j++){
                  if(nums[j] == key){
                        int start = Math.max(j-k, 0);
                        int end = Math.min(j+k, n-1);

                        if(!res.isEmpty() && res.get(res.size()-1) >= start){
                              start = res.get(res.size() -1) + 1;
                        }
                        for (int i = start; i <= end; i++) {
                              res.add(i);
                        }
                  }
            }
            return res;
      }
      public static void main(String[] args) {
            int nums[] = {3,4,9,1,3,9,5};
            int key = 9;
            int k = 1;

            System.out.println(findKDistantIndices(nums, key, k));
      }
}
