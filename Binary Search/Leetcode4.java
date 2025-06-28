public class Leetcode4 {
      public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int[] merged = new int[m + n];
            int i = 0, j = 0, k = 0;

            while (i < m && j < n) {
                  if (nums1[i] < nums2[j]) {
                        merged[k++] = nums1[i++];
                  } else {
                        merged[k++] = nums2[j++];
                  }
            }

            while (i < m) {
                  merged[k++] = nums1[i++];
            }

            while (j < n) {
                  merged[k++] = nums2[j++];
            }

            // find mid of odd and even

            int size = m + n;
            if (size % 2 == 1) { // odd
                  return merged[size / 2];
            }
            return (merged[size / 2] + merged[(size / 2) - 1]) / 2.0; // even
      }

      public static void main(String[] args) {
            int[] nums1 = { 1, 3, 4, 5 };
            int[] nums2 = { 2, 3, 9, 6 };
            System.out.println(findMedianSortedArrays(nums1, nums2));
      }
}
