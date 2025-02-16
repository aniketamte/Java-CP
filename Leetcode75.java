
public class Leetcode75 {

    public static void sortColor(int nums[]) {
        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i <= r;) {
            if (nums[i] == 0) {
                swap(nums, i++, l++); 
            }else if (nums[i] == 1) {
                ++i; 
            }else {
                swap(nums, i, r--);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {2, 0, 2, 1, 1, 0};
        //output = [0,0,1,1,2,2]
        sortColor(nums);

        // Print sorted array
        System.out.print("Sorted Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
