
import java.util.*;

public class SubsetSums {

    public void subsetSumsHelper(int arr[], int idx, ArrayList<Integer> result, int currSum) {
        if (idx == arr.length) {
            result.add(currSum);
            return;
        }
        subsetSumsHelper(arr, idx + 1, result, currSum + arr[idx]);
        subsetSumsHelper(arr, idx + 1, result, currSum);
    }

    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        subsetSumsHelper(arr, 0, result, 0);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        SubsetSums obj = new SubsetSums();
        ArrayList<Integer> result = obj.subsetSums(arr);

        System.out.println("Subset sums: " + result);
        scanner.close();
    }
}
