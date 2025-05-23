
import java.util.*;
//Revise

public class LIS {
    //Longest increasing Subsequence

    public static int lis(int arr[]) {

        //step 1 => create hashset to store unique element
        HashSet<Integer> set = new HashSet<>();

        //add unique element in set
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        //create arr2 with equal to size of arr1
        int arr2[] = new int[set.size()];

        int i = 0;

        for (int num : set) {
            arr2[i] = num;
            i++;
        }

        //sort in Ascending order
        Arrays.sort(arr2);

        return lcs(arr, arr2);
    }

    //code for lcs
    public static int lcs(int arr[], int arr2[]) {
        int n = arr.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];

        //Initialization for 0th row and 0th column
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        //bottom up code
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    //print table
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        System.out.println(lis(arr));
    }
}
