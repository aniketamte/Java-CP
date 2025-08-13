public class Leetcode326 {
      public static boolean isPowerOfThree(int n){
            while(n >= 3){
                  if(n%3 != 0){
                        return false;
                  } else{
                        n = n/3;
                  }
            }
            return n == 1;
      }

      
      public static void main(String[] args) {
            int n = 0;
            System.out.println(isPowerOfThree(n));
      }
}
