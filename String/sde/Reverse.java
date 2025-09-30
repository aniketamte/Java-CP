public class Reverse{
      public static String reverse(String s){
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            for(int i=n-1; i>=0; i--){
                  sb.append(s.charAt(i));
            }
            return sb.toString();
      }

      static String stringReverse(String s) {
        StringBuilder res = new StringBuilder(s);
        res.reverse();
        return res.toString();
      }
      
      public static void main(String[] args) {
            String s = "Aniket";
            System.out.println(reverse(s));
            System.out.println(stringReverse(s));
      }
}