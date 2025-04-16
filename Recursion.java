
public class Recursion {
    //print number from n to 1

    public static void printDecNo(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printDecNo(n - 1);
    }

    //print number from 1 to n
    public static void printIncNo(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        printIncNo(n - 1);
        System.out.print(" " + n);
    }

    //Factorial of n
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //print sum of n natural number \
    public static int sumOfn(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return n + sumOfn(n - 1);
    }

    //nth fibonacci number
    public static int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //check if array is sorted or not
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    //First occurence
    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i + 1);
    }

    //Last occurence
    public static int lastOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    //print x to the power n
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    //print x to the power n (Optimized approach)
    public static int powerOptimized(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPowerSq = powerOptimized(x, n / 2) * powerOptimized(x, n / 2); //even

        if (n % 2 != 0) {
            halfPowerSq = x * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void main(String[] args) {
        printDecNo(10);

        printIncNo(10);

        System.out.println();

        System.out.println(factorial(5));

        System.out.println(sumOfn(5));

        System.out.println(fibonacci(26));

        int arr[] = {1, 2, 3, 40, 5, 2};
        System.out.println(isSorted(arr, 0));

        System.out.println(firstOccurence(arr, 2, 0));

        System.out.println(lastOccurence(arr, 2, 0));

        System.out.println(power(2, 3));

        System.out.println(powerOptimized(5, 5));
    }
}
