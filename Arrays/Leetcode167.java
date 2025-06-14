import java.util.*;
public class Leetcode167 {
      public static int[] twoSum(int[] numbers, int target){
            int start =0;
            int end = numbers.length-1;
            while(start<end){
                  if(numbers[start] + numbers[end] < target){
                        start++;
                  } else if(numbers[start] + numbers[end] > target){
                        end--;
                  } else{
                        return new int[]{start+1, end+1};
                  }
            }
            return null;
      }
      public static void main(String[] args) {
            int[] nums = { 2, 7, 11, 15};
            int target = 9;
            int[] result = twoSum(nums, target);
            System.out.println(Arrays.toString(result));
      }
}
