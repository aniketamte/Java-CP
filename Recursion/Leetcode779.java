public class Leetcode779 {
      public static int kthGrammar(int n, int k) {
            //Base case
            if(n==1 && k==1){
                  return 0;
            }
            //Recurence Relation
            int length = (int)Math.pow(2,n-1);
            int mid = length/2;

            if(k <= mid){
                  return kthGrammar(n-1,k);
            } else{
                  return 1 - kthGrammar(n-1,k-mid);
            }
      }
      public static void main(String[] args) {
            System.out.println(kthGrammar(2,2));
      }
}
