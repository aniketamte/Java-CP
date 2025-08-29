
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashSet;
// import java.util.List;

// public class Leetcode368 {

//     public static List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);
//         List<Integer> result = new ArrayList<>();
//         List<Integer> temp = new ArrayList<>();
//         int prev = -1;

//         solve(0, nums, result, temp, prev);

//         return result;
//     }

//     public static List<Integer> largestDivisibleSubset2(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         for (int i = 0; i < nums.length; i++) {
//             set.add(nums[i]);
//         }

//         int nums2[] = new int[set.size()];
//         int i = 0;
//         for (int num : set) {
//             nums2[i] = num;
//             i++;
//         }

//         Arrays.sort(nums2);
//         return lcs(nums, nums2);
//     }

//     public static void solve(int idx, int nums[], List<Integer> result, List<Integer> temp, int prev) {
//         if (idx >= nums.length) {
//             if (temp.size() > result.size()) {
//                 result.clear();
//                 result.addAll(temp);
//             }
//             return;
//         }

//         //Take
//         if (prev == -1 || nums[idx] % prev == 0) {
//             temp.add(nums[idx]); //take
//             solve(idx + 1, nums, result, temp, nums[idx]);
//             temp.remove(temp.size() - 1); //not take
//         }

//         solve(idx + 1, nums, result, temp, prev);
//     }

//     public static void main(String[] args) {
//         int nums[] = {1, 2, 3};
//         System.out.println(largestDivisibleSubset(nums));
//     }
// }
