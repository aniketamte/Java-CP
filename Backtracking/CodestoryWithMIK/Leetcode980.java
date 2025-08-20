public class Leetcode980 {
    int m, n;
    int emptyCells;   // total number of empty cells + start cell
    int result = 0;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(int[][] grid, int currCount, int i, int j) {
        // Out of bounds or obstacle check
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return;
        }

        // If we reach the ending square
        if (grid[i][j] == 2) {
            // Check if we covered all empty cells
            if (currCount == emptyCells) {
                result++;
            }
            return;
        }

        // Mark cell as visited
        int temp = grid[i][j];
        grid[i][j] = -1;

        // Explore all 4 directions
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            dfs(grid, currCount + 1, newRow, newCol);
        }

        // Backtrack (restore original value)
        grid[i][j] = temp;
    }

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        emptyCells = 0;
        result = 0;

        int startX = 0, startY = 0;

        // Count empty cells and find starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    emptyCells++;
                }
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        // Include the starting square also
        emptyCells += 1;

        // Start DFS from the starting cell
        dfs(grid, 0, startX, startY);

        return result;
    }

    // Test the code
    public static void main(String[] args) {
        Leetcode980 sol = new Leetcode980();
        int[][] grid = {
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 2, -1}
        };

        System.out.println("Unique Paths: " + sol.uniquePathsIII(grid));
        // Expected Output: 2
    }
}
