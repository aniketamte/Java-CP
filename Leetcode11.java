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

      //optimal Approach ------> Two Pointer Approach

      public static int maxArea2(int height[]){  //O(n)
            int maxWater = 0;
            int lp = 0;
            int rp = height.length-1;
            while(lp<rp){
                  int w = rp -lp;
                  int ht = Math.min(height[lp], height[rp]);
                  int currWater = w * ht;
                  maxWater = Math.max(maxWater, currWater);

                  if(height[lp] < height[rp]){
                        lp++;
                  } else{
                        rp--;
                  }
            }
            return maxWater;
      }

      public static void main(String[] args) {
            int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
            System.out.println(maxArea(height));
            System.out.println(maxArea2(height));
      }
}
