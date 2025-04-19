public class Leetcode33 {
      //Leetcode : 33 =====> Search in Rotated Sorted Array
      //Solve using Binary Search
      //27-02-2025
      public static int search(int[] nums, int target){
            int st=0;
            int end=nums.length-1;
            while (st<=end) {
                  int mid = st + (end-st)/2;
                  if(nums[mid] == target){
                        return mid;
                  }
                  if(nums[st]<=nums[mid]){
                        //Left
                        if(nums[st]<=target && target<=nums[mid]){
                              end=mid-1;
                        } else{
                              st=mid+1;
                        }
                  } else{
                        //Right
                        if(nums[mid]<=target && target<=nums[end]){
                              st=mid+1;
                        } else{
                              end=mid-1;
                        }
                  }
            }
            return -1;
      }
     public static void main(String[] args) {
      int nums[] = {4, 5, 6, 7, 0, 1, 2};
      int target=9;
      System.out.println(search(nums, target));
     } 
}
