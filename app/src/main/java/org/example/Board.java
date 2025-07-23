package org.example;

public class Board {
    private String[] board;

    public Board() {
        resetBoard();
    }

    public void resetBoard() {
        board = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    public void displayBoard() {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0) {
                System.out.print("\n" + board[i] + " ");
            } else {
                System.out.print(board[i] + " ");
            }
        }
        System.out.println();
    }

    public String[] getBoard() {
        return board;
    }

    public boolean isBoardFull() {
        for (String s : board) {
            if (!s.equals("X") && !s.equals("O")) {
                return false;
            }
        }
        return true;
    }
}
