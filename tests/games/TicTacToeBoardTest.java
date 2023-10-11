package games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {
    private static final String BOARD = "1 | 2 | 3 \n__ ___ __\n4 | 5 | 6 \n__ ___ __\n7 | 8 | 9 \n";

    private static final String WINX = "X | 2 | 3 \n__ ___ __\n4 | X | 6 \n__ ___ __\n7 | 8 | X \n";
    private static final String WINX2 = "1 | 2 | 3 \n__ ___ __\n4 | 5 | 6 \n__ ___ __\nX | X | X \n";
    private static final String WINX3 = "X | X | X \n__ ___ __\n4 | 5 | 6 \n__ ___ __\n7 | 8 | 9 \n";
    private static final String WINX4 = "1 | 2 | 3 \n__ ___ __\nX | X | X \n__ ___ __\n7 | 8 | 9 \n";
    private static final String WINX5 = "1 | 2 | X \n__ ___ __\n4 | X | 6 \n__ ___ __\nX | 8 | 9 \n";

    private static final String WINO1 = "1 | 2 | 3 \n__ ___ __\nO | O | O \n__ ___ __\n7 | 8 | 9 \n";
    private static final String WINO2 = "1 | 2 | 3 \n__ ___ __\n4 | 5 | 6 \n__ ___ __\nO | O | O \n";
    private static final String WINO3 = "1 | 2 | O \n__ ___ __\n4 | O | 6 \n__ ___ __\nO | 8 | 9 \n";
    private static final String WINO4 = "O | O | O \n__ ___ __\n4 | 5 | 6 \n__ ___ __\n7 | 8 | 9 \n";
    private static final String WINO5 = "O | 2 | 3 \n__ ___ __\n4 | O | 6 \n__ ___ __\n7 | 8 | O \n";

    @Test
    void markWinX() {
        TicTacToeBoard b = new TicTacToeBoard();
        b.mark(1, 'X');
        b.mark(2, 'X');
        b.mark(3, 'X');
        assertEquals(WINX3, b.toString());
        assertTrue(b.checkWinner());

        b = new TicTacToeBoard();
        b.mark(4, 'X');
        b.mark(5, 'X');
        b.mark(6, 'X');
        assertEquals(WINX4, b.toString());
        assertTrue(b.checkWinner());

        b = new TicTacToeBoard();
        b.mark(7, 'X');
        b.mark(8, 'X');
        b.mark(9, 'X');
        assertEquals(WINX2, b.toString());
        assertTrue(b.checkWinner());

        b = new TicTacToeBoard();
        b.mark(1, 'X');
        b.mark(5, 'X');
        b.mark(9, 'X');
        assertEquals(WINX, b.toString());
        assertTrue(b.checkWinner());

        b = new TicTacToeBoard();
        b.mark(3, 'X');
        b.mark(5, 'X');
        b.mark(7, 'X');
        assertEquals(WINX5, b.toString());
        assertTrue(b.checkWinner());

    }

    @Test
    void markWinO() {
        TicTacToeBoard b = new TicTacToeBoard();
        b.mark(1, 'O');
        b.mark(2, 'O');
        b.mark(3, 'O');
        assertEquals(WINO4, b.toString());
        assertTrue(b.checkWinner());

        b = new TicTacToeBoard();
        b.mark(4, 'O');
        b.mark(5, 'O');
        b.mark(6, 'O');
        assertEquals(WINO1, b.toString());
        assertTrue(b.checkWinner());

        b = new TicTacToeBoard();
        b.mark(7, 'O');
        b.mark(8, 'O');
        b.mark(9, 'O');
        assertEquals(WINO2, b.toString());
        assertTrue(b.checkWinner());

        b = new TicTacToeBoard();
        b.mark(1, 'O');
        b.mark(5, 'O');
        b.mark(9, 'O');
        assertEquals(WINO5, b.toString());
        assertTrue(b.checkWinner());

        b = new TicTacToeBoard();
        b.mark(3, 'O');
        b.mark(5, 'O');
        b.mark(7, 'O');
        assertEquals(WINO3, b.toString());
        assertTrue(b.checkWinner());

    }

    @Test
    void isFull() {
        TicTacToeBoard b = new TicTacToeBoard();
        b.mark(3, 'O');
        b.mark(5, 'O');
        b.mark(7, 'O');
        b.mark(1, 'X');
        b.mark(2, 'X');
        b.mark(9, 'X');
        b.mark(4, 'X');
        b.mark(8, 'X');
        b.mark(6, 'O');
        assertTrue(b.isFull());

        b = new TicTacToeBoard();
        assertFalse(b.isFull());
    }


    @Test
    void isGameOver() {
        TicTacToeBoard b = new TicTacToeBoard();
        b.mark(3, 'O');
        b.mark(2, 'X');
        b.mark(5, 'O');
        b.mark(9, 'X');
        b.mark(7, 'O');
        assertTrue(b.isGameOver());

        b = new TicTacToeBoard();

        b.mark(5, 'X');
        b.mark(3, 'O');
        b.mark(2, 'X');
        b.mark(8, 'O');
        b.mark(9, 'X');
        b.mark(1, 'O');
        b.mark(4, 'X');
        b.mark(6, 'O');
        b.mark(7, 'X');
        assertTrue(b.isFull());
    }

    @Test
    void testToString() {
        TicTacToeBoard b = new TicTacToeBoard();
        assertEquals(BOARD, b.toString());
    }
}