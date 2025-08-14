public class Leetcode2264 {
    public static String largestGoodInteger(String num) {
      int n = num.length();
      char maxChar = ' ';
      for(int i=2; i<n; i++){
            if(num.charAt(i) == num.charAt(i-1) && num.charAt(i) == num.charAt(i-2)){
                  maxChar = (char)Math.max(maxChar, num.charAt(i));
            }
      }
      if(maxChar == ' '){
            return "";
      }
      return new String(new char[] {maxChar, maxChar, maxChar});
    }
    public static void main(String[] args) {
      String num = "6777133339";
      System.out.println(largestGoodInteger(num));
    }
}
