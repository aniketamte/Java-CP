public class Leetcode3307 {
      public static char kthCharacter(long k, int[] operations) {
            if(k == 1) return 'a';
            int n = operations.length;
            long len = 1;
            long newK = -1;
            int operationsType = -1;

            for(int i=0; i<n; i++){
                  len *= 2;

                  if(len >= k){
                        operationsType = operations[i];
                        newK = k - (len/2);
                        break;
                  }
            }

            char ch = kthCharacter(newK, operations);
            if(operationsType == 0) return ch;
            return ch == 'z' ? 'a' : (char)(ch + 1);
      }

      public static void main(String[] args) {
            int[] operations = { 0, 0, 0 };
            System.out.println(kthCharacter(3, operations));
      }
}
