import java.util.*;

public class Leetcode2294{
      public static int partitionArray(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;

            int count = 1; //1st subsequence
            int minVal = nums[0]; //part of 1st subsequence 
            
            for(int i=0; i<n; i++){
                  if(nums[i] - minVal > k){
                        count++;
                        minVal = nums[i];
                  }
            }
            return count;
      }
      public static void main(String[] args) {
            int[] nums = {3,6,1,2,5};
            int k =2;
            System.out.println(partitionArray(nums, k));
      }
}