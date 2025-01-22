
public class Leetcode733 {
      public int[][] helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol) {
            //Left
            helper(image, sr, sc-1, color, vis, orgCol);
            //Right
            helper(image, sr, sc+1, color, vis, orgCol);
            //Up
            helper(image, sr-1, sc, color, vis, orgCol);
            //Down
            helper(image, sr+1, sc, color, vis, orgCol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      boolean vis[][] = new boolean[image.length][image[0].length];
      helper(image, sr, sc, color, vis, image[sr][sc]);
      return image;
    }

    public static void main(String[] args) {

    }
}
