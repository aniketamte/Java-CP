
import java.util.Arrays;

public class GFG22 {

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int idx = 0;

        // Keep incrementing idx till citations[n - 1 - idx] > idx
        while (idx < n && citations[n - 1 - idx] > idx) {
            idx++;
        }
        return idx;
    }

}
