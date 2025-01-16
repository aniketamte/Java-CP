
public class GFG02 {
    //GFG160 Challenge Day ----> 2
    //Move all zeros to end

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    public static void main(String[] args) {
      int nums[] = {0,9,0,8,0,7,0,5};
      System.out.println(moveZeroes(nums));
    }
}
