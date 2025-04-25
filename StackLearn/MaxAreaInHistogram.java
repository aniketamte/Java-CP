import java.util.Stack;
public class MaxAreaInHistogram {
    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next smaller Right
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                //-1 ==> n
                nsr[i] = arr.length;
            } else {
                //top
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        //Next Smaller Left

        s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                //-1 ==> n
                nsl[i] = -1;
            } else {
                //top
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //Current Area :
        //width : j-i-1 => nsr[i] - nsl[i] - 1;

        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("Maximum area in Histogram : " + maxArea);
    }

    public static void main(String[] args) {
      //int arr[] = {2, 1, 5, 6, 2, 3};
      int arr[] = {2, 4};
      maxArea(arr);
    }
}
