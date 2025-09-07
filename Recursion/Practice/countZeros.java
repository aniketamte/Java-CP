public class countZeros {
      public static int count(int num){
            return helper(num, 0);
      }

      private static int helper(int num, int countOfZero) {
            if(num == 0){
                  return countOfZero;
            }
            int rem = num % 10;
            if(rem == 0){
                  return helper(num/10, countOfZero+1);
            }
            return helper(num/10, countOfZero);
      }
      public static void main(String[] args) {
            int num = 302104;
            System.out.println(count(num));
      }
}
