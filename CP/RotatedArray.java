import java.util.*;
public class RotatedArray{
      public static int findMin(final List<Integer> a) {
        int low = 0, high = a.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a.get(mid) > a.get(high)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return a.get(low);
    }
    public static void main(String[] args) {
        RotatedArray solution = new RotatedArray();
      List<Integer> a = Arrays.asList(7, 2, 4, 5);
      System.out.println(solution.findMin(a));
    }
}