
public class Leetcode733 {
     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            helper(image, sr, sc, color, newColor);
        }
        return image;
    }

    public void helper(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) {
                helper(image, r - 1, c, color, newColor);
            }
            if (c >= 1) {
                helper(image, r, c - 1, color, newColor);
            }
            if (r + 1 < image.length) {
                helper(image, r + 1, c, color, newColor);
            }
            if (c + 1 < image[0].length) {
                helper(image, r, c + 1, color, newColor);
            }
        }
    }
    public static void main(String[] args) {
      int image[][] = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
      };
    }
}
