package games;

/**
 * This class represents a two-dimensional game grid which can be used as a foundation for games
 * like tictactoe, connect4, checkers, etc. The Board constructor creates a 2D grid of proper size
 * and fills with characters digits in each grid location. Note: it is assumed that all rows will have the same
 * number of columns
 *
 * Example: rows = 3 and columns = 3, then the board would contain
 *  '1' '2' '3'
 *  '4' '5' '6'
 *  '7' '8' '9'
 *
 */
public class Board {
    protected char[][] board;

    /**
     * Constructs a 2d representation of a game board and populates with
     * ascending character digits in all locations
     *
     * @param rows number of rows for board
     * @param columns number of columns for board
     */
    public Board(int rows, int columns) {
        board = new char[rows][columns];
        // place charcter digits in grid (ex. '1', '2', ...)
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = ("" + ((r * 3) + c + 1)).charAt(0);
            }
        }
    }

    /**
     * Return the number of rows in the game board
     * @return number of rows
     */
    public int numRows(){
        return board.length;
    }

    /**
     * Return the number of columns in first row of the game board
     * @return number of columns
     */
    public int numColumns(){
        return board[0].length;
    }

    @Override
    public String toString(){
        String grid = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                grid += board[i][j] + " ";
            }
            grid += "\n";
        }
        return grid;
    }

}
