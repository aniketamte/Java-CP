
public class selectionSorting {
    //Print Array in Increasing Order

    public static void SelectionSortInc(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    //Print Array in Decreasing Order
    public static void SelectionSortDec(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] < arr[j]) {
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    //print arr 
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 1, 3, 2};
        SelectionSortInc(arr);
        printArr(arr);
        SelectionSortDec(arr);
        printArr(arr);
    }
}
