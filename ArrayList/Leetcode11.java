import java.util.*;
public class Leetcode11 {
      public static int maxArea(ArrayList<Integer> height){
            int maxWater = 0;
            for(int i=0; i<height.size(); i++){
                  for(int j=i+1; j<height.size(); j++){
                        int ht = Math.min(height.get(i), height.get(j));
                        int width = j-i;
                        int currWater = ht * width;
                        maxWater = Math.max(maxWater, currWater);
                  }
            }
            return maxWater;
      }
      
      //Using two pointer approach

      public static int max(ArrayList<Integer> height){
            int maxWater = 0;
            int lp = 0;
            int rp = height.size() - 1;
            while (lp < rp) {
                  int w = rp - lp;
                  int ht = Math.min(height.get(lp), height.get(rp));
                  int currWater = w * ht;
                  maxWater = Math.max(maxWater, currWater);

                  if (height.get(lp) < height.get(rp)) {
                        lp++;
                  } else {
                        rp--;
                  }
            }
            return maxWater;
      }
      public static void main(String[] args) {
            ArrayList<Integer> height = new ArrayList<>();
            height.add(1);
            height.add(8);
            height.add(6);
            height.add(2);
            height.add(5);
            height.add(4);
            height.add(8);
            height.add(3);
            height.add(7);

            System.out.println(maxArea(height));
            System.out.println(max(height));
      }
}
