
import java.util.*;

public class inBuiltSort {
    //Print Array

    public static void printArr(Integer arr[]) {
        for (Integer i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer arr[] = {5, 4, 1, 3, 2};
        Arrays.sort(arr);
        printArr(arr);

        Arrays.sort(arr, 0, 3);
        printArr(arr);

        //print in reverse order
        Arrays.sort(arr, Collections.reverseOrder());
        printArr(arr);

        Arrays.sort(arr, 0, 4, Collections.reverseOrder());
        printArr(arr);
    }
}
