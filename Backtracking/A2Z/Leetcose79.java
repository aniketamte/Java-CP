public class Leetcose79 {
      public static char[][] direction = new char[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
      public static boolean exist(char[][] board, String word){
            int m = board.length;
            int n = board[0].length;
            for(int i=0; i<m; i++){
                  for(int j=0; j<n; j++){
                        if(board[i][j] == word.charAt(0) && find(board, i, j, 0, word)){
                              return true;
                        }
                  }
            }
            return false;
      }
      public static boolean find(char [][] board, int i, int j, int idx, String word){
            if(idx == word.length()){
                  return true;
            }
            if(i<0 || i>= board.length || j <0 || j>= board[0].length || board[i][j] != word.charAt(idx) || board[i][j] == '$'){
                  return false;
            }
            
      }
}
