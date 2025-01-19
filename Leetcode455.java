import java.util.Arrays;

public class Leetcode455 {

    //Leetcode 168
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && contentChildren < g.length) {
            if (s[cookieIndex] >= g[contentChildren]) {
                contentChildren++;
            }
            cookieIndex++;
        }
        return contentChildren;
    }

    public static void main(String[] args) {
        int g[] = {1, 2, 3};
        int s[] = {1, 1};
        System.out.println(findContentChildren(g, s));
    }
}
