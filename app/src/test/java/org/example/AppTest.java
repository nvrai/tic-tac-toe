package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testHorizontalWin() {
        String[] board = {"X", "X", "X", "4", "5", "6", "7", "8", "9"};
        Player player = new Player("X", Player.Type.HUMAN);
        assertTrue(player.checkWin(board, "X"));
    }

    @Test
    void testVerticalWin() {
        String[] board = {"O", "2", "3", "O", "5", "6", "O", "8", "9"};
        Player player = new Player("O", Player.Type.HUMAN);
        assertTrue(player.checkWin(board, "O"));
    }

    @Test
    void testDiagonalWin() {
        String[] board = {"X", "2", "3", "4", "X", "6", "7", "8", "X"};
        Player player = new Player("X", Player.Type.HUMAN);
        assertTrue(player.checkWin(board, "X"));
    }

    @Test
    void testNoWin() {
        String[] board = {"X", "O", "X", "X", "O", "O", "O", "X", "X"};
        Player player = new Player("X", Player.Type.HUMAN);
        assertFalse(player.checkWin(board, "X"));
        assertFalse(player.checkWin(board, "O"));
    }

    @Test
    void testEmptyBoardNoWin() {
        String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Player player = new Player("X", Player.Type.HUMAN);
        assertFalse(player.checkWin(board, "X"));
        assertFalse(player.checkWin(board, "O"));
    }

    @Test
    void testPlayerMakesValidMove() {
        Board board = new Board();
        Player player = new Player("X", Player.Type.HUMAN);
        String[] initialBoard = board.getBoard();
        java.util.Scanner scanner = new java.util.Scanner("1\n");
        player.makeMove(board, scanner);
        assertEquals("X", board.getBoard()[0]);
    }


}
