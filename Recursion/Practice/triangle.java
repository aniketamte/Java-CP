public class triangle {
      public static void triang(int row, int col){
            if(row == 0){
                  return;
            }

            if(col < row){
                  System.out.print("*");
                  triang(row, col+1);
            } else{
                  System.out.println();
                  triang(row-1, 0);
            }
      }
      public static void main(String[] args) {
            triang(4, 0);
            int n=10;
            for(int i=n; i>=1; i--){
                  for(int j=1; j<=i; j++){
                        System.out.print(" * ");
                  }
                  System.out.println();
            }

            for(int i = n; i >= 1; i--){
                  for(int j=1; j<n-i; j++){
                        System.out.print(" ");
                  }
                  for(int j=1; j<=i; j++){
                        System.out.print("*");
                  }
                  System.out.println();
            }
      }
}
