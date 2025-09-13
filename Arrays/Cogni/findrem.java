public class findrem {
      public static int rem2(String num){
            int rem = 0;
            for(int i=0; i<num.length(); i++){
                  int digit = num.charAt(i) - '0';
                  rem = (rem * 10 + digit) % 11;
            }
            return rem;
      }
      public static void main(String[] args) {
            System.out.println(rem2("3435346456547566345436457867978"));
      }
}
