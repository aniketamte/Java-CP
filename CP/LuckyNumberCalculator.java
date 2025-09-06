public class LuckyNumberCalculator {
    public static int calculateLuckyNumber(int L, String N) {
      int luckyNo = 0;
      for(int i=0; i<L; i++){
            int index = i+1;
            int asciiVal = (int)N.charAt(i);
            if(index%2 == 1 || asciiVal%2==1){
                  luckyNo += (index * asciiVal);
            }
      }
      return luckyNo;
    }

    public static void main(String[] args) {
        int L = 5;
        String N = "JAMES";

        System.out.println(calculateLuckyNumber(L, N)); 
    }
}
