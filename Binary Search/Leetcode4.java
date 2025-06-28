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

      //O(1)
      public static double BetterApproach(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int size = m + n;
            int i = 0, j = 0, k = 0;

            int idx1 = (size/2) - 1;
            int element1 = -1;
            int idx2 = size/2;
            int element2 = -1;

            while (i < m && j < n) {
                  if (nums1[i] < nums2[j]) {
                        if(k == idx1){
                              element1 = nums1[i];
                        }
                        if(k == idx2){
                              element2 = nums1[i];
                        }
                        i++;
                  } else{
                        if(k == idx1){
                              element1 = nums2[j];
                        }
                        if(k == idx2){
                              element2 = nums2[j];
                        }
                        j++;
                  }
                  k++;
            }

            while (i < m) {
                  if (k == idx1) {
                        element1 = nums1[i];
                  }
                  if (k == idx2) {
                        element2 = nums1[i];
                  }
                  i++;
                  k++;
            }

            while (j < n) {
                  if (k == idx1) {
                        element1 = nums2[j];
                  }
                  if (k == idx2) {
                        element2 = nums2[j];
                  }
                  j++;
                  k++;
            }

            // find mid of odd and even

            if (size % 2 == 1) { // odd
                  return element2;
            }
            return (element1 + element2) / 2.0; // even
      }

      public static double BinarySearch(int[] nums1, int[] nums2){
            if (nums1.length > nums2.length) {
                  return findMedianSortedArrays(nums2, nums1);
            }

            int m = nums1.length;
            int n = nums2.length;

            int low = 0, high = m;
            while (low <= high) {
                  int Px = low + (high - low) / 2;
                  int Py = (m + n + 1) / 2 - Px;

                  int x1 = (Px == 0) ? Integer.MIN_VALUE : nums1[Px - 1];
                  int x3 = (Px == m) ? Integer.MAX_VALUE : nums1[Px];

                  int x2 = (Py == 0) ? Integer.MIN_VALUE : nums2[Py - 1];
                  int x4 = (Py == n) ? Integer.MAX_VALUE : nums2[Py];

                  if (x1 <= x4 && x2 <= x3) {
                        if ((m + n) % 2 == 0) {
                              return (Math.max(x1, x2) + Math.min(x3, x4)) / 2.0;
                        }
                        return Math.max(x1, x2);
                  } else if (x1 > x4) {
                        high = Px - 1;
                  } else {
                        low = Px + 1;
                  }
            }

            return -1;
      }

      public static void main(String[] args) {
            int[] nums1 = { 1, 3, 4, 5 };
            int[] nums2 = { 2, 3, 9, 6 };
            System.out.println(findMedianSortedArrays(nums1, nums2));
            System.out.println(BetterApproach(nums1, nums2));
            System.out.println(BinarySearch(nums1, nums2));
      }
}
