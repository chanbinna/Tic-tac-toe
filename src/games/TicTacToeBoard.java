package games;

/**
 * This TicTacToeBoard objects represents a Tic Tac Toe Board which can have X's and O's placed in it
 * The object can determine if all places have been marked and if there is a winner.
 */
public class TicTacToeBoard extends Board{
   protected int marked; // how many spots have the players marked


   /**
    * Constructs a TicTacToe 3x3 Game Board
    * Board is filled with primitive char digits
    * '1' '2' '3'
    * '4' '5' '6'
    * '7' '8' '9'
    */
   public TicTacToeBoard() {
      super(3,3);
      marked = 0;
   }

   /**
    *
    * @param spot a number in the range 1 to 9, inclusive
    * @param marker
    * @return true if the spot was found in the grid, false otherwise
    */
   public boolean mark(int spot, char marker) {
      // convert the integer spot number to a primitive char Ex '1' becomes 1
      final int ASCII_ZERO = 48;
      char cSpot = (char)(spot + ASCII_ZERO);

      for (int r = 0; r < board.length; r++) {
         for (int c = 0; c < board[0].length ; c++) {
            // if the desired spot has not been marked yet
            if(board[r][c] == cSpot){
               // place a marker in the spot ('X' or 'O'
               board[r][c] = marker;
               // increment the number of spots marked
               marked++;
               return true;
            }
         }
      }
      // spot was not found to mark, return false
      return false;
   }

   /**
    * Checks if all spaces have been marked
    * @return true, if players picked all spots, false otherwise
    */
   public boolean isFull() {
      // return true if marked = number of rows * number of columns
      return marked == board.length * board[0].length;
   }

   /**
    * Checks if player 1 or player 2 has gotten three in a row or on one of the two diagonals
    * @return true, if a player has won, false otherwise
    */
   public boolean checkWinner() {
      return (board[0][0] == board[0][1] && board[0][2] == board[0][0]) ||
              (board[1][0] == board[1][1] && board[1][2] == board[1][0]) ||
              (board[2][0] == board[2][1] && board[2][2] == board[2][0]) ||
              (board[0][0] == board[1][1] && board[0][0] == board[2][2]) || // diagonal
              (board[0][2] == board[1][1] && board[0][2] == board[2][0]);


   }

   /**
    * Checks if there is a winner or all spaces have been filled. In either case, the game is over.
    * @return true if the game is over
    */
   public boolean isGameOver() {
      return isFull() || checkWinner();
   }

   public String toString() {
      return board[0][0] +" | " + board[0][1] + " | " + board[0][2] + " \n"
              + "__ ___ __\n"
              + board[1][0] +" | " + board[1][1] + " | " + board[1][2] + " \n"
              + "__ ___ __\n"
              + board[2][0] +" | " + board[2][1] + " | " + board[2][2] +" \n";

	}

}
