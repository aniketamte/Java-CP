public class Leetcode3000 {
      public static int areaOfMaxDiagonal(int[][] dimensions){
            int n = dimensions.length;

            int maxDiag = 0;
            int maxArea = 0;

            for(int i=0; i<n; i++){
                  int length = dimensions[i][0];
                  int width = dimensions[i][1];

                  int diagonal = length*length + width*width;
                  int area = length * width;

                  if(diagonal > maxDiag){
                        maxDiag = diagonal;
                        maxArea = area;
                  } else if(diagonal == maxDiag){
                        maxArea = Math.max(maxArea, area);
                  }
            }
            return maxArea;
      }
      
      public static void main(String[] args) {
            int dimensions[][] = {
                  {9, 3},
                  {8, 6}
            };
            System.out.println(areaOfMaxDiagonal(dimensions));
      }
}
