public class TargetSearch {
    public static boolean search(int arr[], int target, int index) {
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || search(arr, target, index + 1);
    }

    public static int search2(int arr[], int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else {
            return search2(arr, target, index + 1);
        }
    }

    public static int search3(int arr[], int target, int index) {
        if (index == -1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else {
            return search2(arr, target, index - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        int target = 40;
        System.out.println(search(arr, target, 0));
        System.out.println(search2(arr, target, 0));
        System.out.println(search3(arr, target, arr.length-1));
    }
}
