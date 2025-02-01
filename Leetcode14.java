
import java.util.Arrays;

public class Leetcode14 {

      //Leetcode : 14 ---> Longest Common Prefix

    public static String longestCommonPrefix(String[] strs) {
        //First sort the array
        Arrays.sort(strs);
        //First String
        String str1 = strs[0];
        //Last String 
        String str2 = strs[strs.length - 1];

        //comapre index by index
        int index = 0;
        while (index < str1.length()) {
            if (str1.charAt(index) == str2.charAt(index)) {
                index++;
            } else {
                //if doesn't match
                break;
            }
        }
        return index == 0 ? "" : str1.substring(0, index);
    }

    public static void main(String[] args) {
        String strs[] = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
