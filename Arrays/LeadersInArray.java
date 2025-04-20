
import java.util.*;

public class LeadersInArray {

    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight); // rightmost element is always a leader

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }

        Collections.reverse(leaders); // to maintain original order
        return leaders;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 7, 1, 0};
        int[] arr2 = {10, 22, 12, 3, 0, 6};

        System.out.println("Leaders in arr1: " + findLeaders(arr1));
        System.out.println("Leaders in arr2: " + findLeaders(arr2));
    }
}
