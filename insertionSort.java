
public class insertionSort {

    public static void InsertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int previous = i - 1;

            //Finding out the correct pos to insert
            while (previous >= 0 && arr[previous] > current) {
                arr[previous + 1] = arr[previous];
                previous--;
            }
            //insertion
            arr[previous + 1] = current;
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
        InsertionSort(arr);
        printArr(arr);
    }
}
