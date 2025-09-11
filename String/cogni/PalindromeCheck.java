public class PalindromeCheck {
      static void checkPalindrome(int num){
            if(num < 0){
                  System.out.println("Invalid Input");
            }

            //reverse
            int original = num;
            int reverse = 0;

            while(num > 0){
                  int digit = num % 10;
                  reverse = reverse * 10 + digit;
                  num = num/10;
            }

            if(reverse == original){
                  System.out.println("Palindrome");
            } else{
                  System.out.println("Not a Palindrome");
            }
      }

      public static void main(String[] args) {
            int num = 6186;
            checkPalindrome(num);
      }
}
