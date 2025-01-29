
public class GFG21 {
    //GfG 160 Day Challenge ----> Day 21
    //Day 21 --->Sort 0s, 1s and 2s

    public static void sort012(int[] arr) {
        // code here
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        //override
        int idx = 0;
        for (int i = 0; i < count0; i++) {
            arr[idx++] = 0;
        }

        for (int i = 0; i < count1; i++) {
            arr[idx++] = 1;
        }

        for (int i = 0; i < count2; i++) {
            arr[idx++] = 2;
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 0, 1, 2};
        sort012(arr);
    }
}
