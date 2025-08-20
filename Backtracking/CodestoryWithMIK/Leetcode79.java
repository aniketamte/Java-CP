
public class Leetcode79 {

    // Function to check if the word exists in the board
    public static boolean exist (char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Try starting the search from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start DFS if the first character matches
                if (board[i][j] == word.charAt(0) && find(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Directions: right, left, down, up
    static int directions[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // DFS search
    public static boolean find(char[][] board, int i, int j, String word, int idx) {
        int m = board.length;
        int n = board[0].length;

        // ✅ If we matched all characters of word, return true
        if (idx == word.length()) {
            return true;
        }

        // Out of bounds or character mismatch
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(idx)) {
            return false;
        }

        // Mark this cell as visited
        char temp = board[i][j];
        board[i][j] = '$';

        // Explore all 4 directions
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (find(board, newRow, newCol, word, idx + 1)) {
                return true;
            }
        }

        // Backtrack (unmark this cell)
        board[i][j] = temp;

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        boolean result = exist(board, word);
        System.out.println("Does the word exist? " + result); // true
    }
}
