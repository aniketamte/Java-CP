
public class Leetcode709 {

    public static String toLowerCase(String s) {

      return s.toLowerCase();
    }
    public static void main(String[] args) {
        String input1 = "Hello";
        String input2 = "here";
        String input3 = "LOVELY";

        System.out.println("Output 1: " + toLowerCase(input1));  // "hello"
        System.out.println("Output 2: " + toLowerCase(input2));  // "here"
        System.out.println("Output 3: " + toLowerCase(input3));  // "lovely"

    }
}
