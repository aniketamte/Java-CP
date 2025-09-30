public class contiguousSubarray {
    public static int findLongest(int arr[]) {
        if (arr.length == 0) {
            return 0;
        }
        int maxLength = 1;
        int currLength = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            } else {
                currLength = 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 5, 7, 8, 9, 1, 2};
        System.out.println("Longest Increasing Subarray Length: " + findLongest(arr));
    }
}
