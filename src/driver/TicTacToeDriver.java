package driver;

import java.util.*;
import games.*;

/**
 * This class drives a console based game of TicTacTow
 */
public class TicTacToeDriver {
    public static final char PLAYER_1 = 'X';
    public static final char PLAYER_2 = 'O';
    private static final Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        TicTacToeBoard board = new TicTacToeBoard();
        boolean isPlayer1 = true;

        do {
            System.out.println(board);
            playerTurn(board, isPlayer1);
            // switch to Player2
            isPlayer1 = !isPlayer1;
        } while (!board.isGameOver());

        System.out.println();
        System.out.println("Good game!");
        System.out.println(board);
    }

    private static void playerTurn(TicTacToeBoard board, boolean isPlayer1) {
        //set player to the person's turn using a ternary operator
        // if isPlayer1 == true then(?) set player to PLAYER_1 else(:) set player to PLAYER_@
        char player = isPlayer1 ? PLAYER_1 : PLAYER_2;
        String prompt = "\nPlayer " + player + ", where would you like to go? > ";


        int spot = getValidSpot(prompt);

        //set that spot to the player's letter (char player)
        board.mark(spot, player);
    }

    private static int getValidSpot(String prompt){
        int spot = readInt(prompt);
        while(spot < 1 || spot > 9){
            spot = readInt(prompt);
        }
        return spot;
    }

    private static int readInt(String prompt)
    {
        //prompt and read
        System.out.print(prompt);

        //test whether we have an integer or not
        while (!console.hasNextInt())
        {
            System.out.println("Enter a valid integer: ");

            //clear out bad characters from the scanner
            console.nextLine();
        }

        int value = console.nextInt();
        console.nextLine(); //clear the buffer

        return value;
    }
}
