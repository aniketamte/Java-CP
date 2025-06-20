import java.util.*;

public class Leetcode229 {
      public static List<Integer> majorityElement(int[] nums) {
            int count1 = 0, count2 = 0;
            int maj1 = 0, maj2 = 0;
            int n= nums.length;

            for(int i=1; i<n; i++){
                  if(nums[i] == maj1){
                        count1++;
                  } else if(nums[i] == maj2){
                        count2++;
                  } else if(count1 == 0){
                        maj1 = nums[i];
                        count1 = 1;
                  } else if(count2 == 0){
                        maj2 = nums[i];
                        count2 = 1;
                  } else {
                        count1--;
                        count2--;
                  }
            }
            List<Integer> result = new ArrayList<>();
            int freq1 = 0;
            int freq2 = 0;
            for(int num : nums){
                  if(num == maj1) freq1++;
                  else if(num == maj2) freq2++;
            }

            if(freq1 > Math.floor(n/3)){
                  result.add(maj1);
            }

            if(freq2 > Math.floor(n/3)){
                  result.add(maj2);
            }

            return result;
      }

      public static void main(String[] args) {
            int[] nums = {3,2,3};
            System.out.println(majorityElement(nums));
      }
}
