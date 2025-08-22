public class Leetcode3195 {
    public static int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int x1 = n, x2 = -1;
        int y1 = m, y2 = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0) {
                    continue;
                }
                x1 = Math.min(x1, i);
                x2 = Math.max(x2, i);
                y1 = Math.min(y1, j);
                y2 = Math.max(y2, j);
            }
        }
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }

    public static void main(String[] args) {
        int grid[][] = {
            {0, 1, 0},
            {1, 0, 1}
        };
        System.out.println(minimumArea(grid));
    }
}
