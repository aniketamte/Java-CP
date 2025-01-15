
public class Leetcode75 {

    public static void sortColor(int nums[]) {
        int n = nums.length;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        //override on element
        int idx = 0;
        for (int i = 0; i < count0; i++) {
            nums[idx++] = 0;
        }
        for (int i = 0; i < count1; i++) {
            nums[idx++] = 1;
        }
        for (int i = 0; i < count2; i++) {
            nums[idx++] = 2;
        }
    }

    public static void main(String[] args) {
      int nums[] = {2, 0, 2, 1, 1, 0};
      //output = [0,0,1,1,2,2]
      System.out.println(sortColor(nums));
    }
}
