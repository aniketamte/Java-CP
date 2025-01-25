import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Leetcode2948 {
      //Problem Of the Day ----> 25-01-2025
      public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] numsSorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) numsSorted[i] = nums[i];
        Arrays.sort(numsSorted);

        int currGroup = 0;
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);

        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(
            currGroup,
            new LinkedList<Integer>(Arrays.asList(numsSorted[0]))
        );

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) {
                // new group
                currGroup++;
            }

            // assign current element to group
            numToGroup.put(numsSorted[i], currGroup);

            // add element to sorted group list
            if (!groupToList.containsKey(currGroup)) {
                groupToList.put(currGroup, new LinkedList<Integer>());
            }
            groupToList.get(currGroup).add(numsSorted[i]);
        }

        // iterate through input and overwrite each element with the next element in its corresponding group
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }
        print(nums);
        return nums;
    }
    public static void print(int nums[]){
      for(int i=0; i<nums.length; i++){
                  System.out.print(nums[i] + " ");
            }
            System.out.println();
      
    }
    public static void main(String[] args) {
      int nums[] = {1, 5, 3, 9, 8};
      int limit = 2;
      System.out.println(lexicographicallySmallestArray(nums, limit));
      
    }
}
