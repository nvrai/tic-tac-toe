package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testHorizontalWin() {
        String[] board = {"X", "X", "X", "4", "5", "6", "7", "8", "9"};
        assertTrue(App.checkWin(board));
    }

    @Test
    void testVerticalWin() {
        String[] board = {"O", "2", "3", "O", "5", "6", "O", "8", "9"};
        assertTrue(App.checkWin(board));
    }

    @Test
    void testDiagonalWin() {
        String[] board = {"X", "2", "3", "4", "X", "6", "7", "8", "X"};
        assertTrue(App.checkWin(board));
    }

    @Test
    void testNoWin() {
        String[] board = {"X", "O", "X", "X", "O", "O", "O", "X", "X"};
        assertFalse(App.checkWin(board));
    }

    @Test
    void testEmptyBoardNoWin() {
        String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        assertFalse(App.checkWin(board));
    }
}
