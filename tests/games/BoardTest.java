package games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private static final String GRID = "1 2 3 \n4 5 6 \n7 8 9 \n";

    @Test
    void testGetRowsColumns() {
        Board board = new Board(3,4);
        assertEquals(3, board.numRows());
        assertEquals(4, board.numColumns());
    }

    @Test
    void testBoardCreation(){
        Board board = new Board(3,3);
        assertEquals(GRID, board.toString());
    }



}