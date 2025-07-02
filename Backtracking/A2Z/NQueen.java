public class NQueen {
      public static void nQueen(char board[][], int row){
            if(row == board.length){
                  printBoard(board);
                  return;
            }
            for(int j=0; j<board.length; j++){
                  board[row][j] = 'Q';
                  nQueen(board, row+1);  //Function call
                  board[row][j] = 'X';   //Backtracking step
            }
      }

      public static void printBoard(char board[][]){
            System.out.println("----------------- Chess Board -----------------");
            for(int i=0; i<board.length; i++){
                  for(int j=0; j<board.length; j++){
                        System.out.print(board[i][j] + " ");
                  }
                  System.out.println();
            }
      }
      public static void main(String[] args){
            int n = 2;
            char board[][] = new char[n][n];

            //initialize
            for(int i=0; i<n; i++){
                  for(int j=0; j<n; j++){
                        board[i][j] = 'X';
                  }
            }

            nQueen(board, 0);
      }
}
