public class Leetcode11 {
      //Brute Force Approach
      public static int maxArea(int[] height){
            int maxWater = 0;
            for(int i=0;  i<height.length; i++){
                  for(int j=i+1; j<height.length; j++){
                        int width = j-i;
                        int ht = Math.min(height[i], height[j]);
                        int currWater = width * ht;

                        maxWater = Math.max(maxWater, currWater);
                  }
            }
            return maxWater;
      }
      public static void main(String[] args) {
            int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
            System.out.println(maxArea(height));
      }
}
