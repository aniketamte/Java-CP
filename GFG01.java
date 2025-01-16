public class GFG01 {
      //GFG160 Challenge Day ----> 1
      public static int getSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {    //because we cant find ans
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }
      public static void main(String[] args) {
            int arr[] = {12, 35, 1, 10, 34, 1};
            System.out.println(getSecondLargest(arr));
      }
}
