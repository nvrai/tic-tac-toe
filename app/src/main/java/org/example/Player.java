package org.example;

import java.util.Random;
import java.util.Scanner;

public class Player {
    public enum Type {
        HUMAN, COMPUTER
    }

    private String symbol;
    private Type type;

    public Player(String symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public Type getType() {
        return type;
    }

    public void makeMove(Board board, Scanner scanner) {
        if (this.type == Type.HUMAN) {
            chooseMove(board, scanner);
        } else {
            computerMove(board);
        }
    }

    private void chooseMove(Board board, Scanner scanner) {
        System.out.print("Choose where to play " + symbol + ": ");
        int move;
        while (true) {
            try {
                move = scanner.nextInt();
                if (move < 1 || move > 9 || board.getBoard()[move - 1].equals("X") || board.getBoard()[move - 1].equals("O")) {
                    System.out.println("Invalid move! Try again.");
                } else {
                    break;
                }
            } catch (Exception e) {
                scanner.nextLine(); // Clear buffer
                System.out.println("Invalid input. Try again.");
            }
        }
        board.getBoard()[move - 1] = symbol;
    }

    private void computerMove(Board board) {
        int move = -1;

        move = findWinningMove(board, symbol);
        if (move == -1) move = findBlockingMove(board, symbol.equals("X") ? "O" : "X");
        if (move == -1) move = getRandomMove(board);

        board.getBoard()[move - 1] = symbol;
    }

    private int findWinningMove(Board board, String player) {
        for (int i = 0; i < 9; i++) {
            if (board.getBoard()[i].equals(String.valueOf(i + 1))) {
                board.getBoard()[i] = player;
                if (checkWin(board.getBoard(), player)) {
                    board.getBoard()[i] = String.valueOf(i + 1);
                    return i + 1;
                }
                board.getBoard()[i] = String.valueOf(i + 1);
            }
        }
        return -1;
    }

    private int findBlockingMove(Board board, String opponent) {
        for (int i = 0; i < 9; i++) {
            if (board.getBoard()[i].equals(String.valueOf(i + 1))) {
                board.getBoard()[i] = opponent;
                if (checkWin(board.getBoard(), opponent)) {
                    board.getBoard()[i] = String.valueOf(i + 1);
                    return i + 1;
                }
                board.getBoard()[i] = String.valueOf(i + 1);
            }
        }
        return -1;
    }

    private int getRandomMove(Board board) {
        Random random = new Random();
        int move;
        do {
            move = random.nextInt(9) + 1;
        } while (!board.getBoard()[move - 1].equals(String.valueOf(move)));
        return move;
    }

    public boolean checkWin(String[] board, String player) {
        for (int i = 0; i <= 6; i += 3) {
            if (board[i].equals(board[i + 1]) && board[i + 1].equals(board[i + 2])) return true;
        }
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(board[i + 3]) && board[i + 3].equals(board[i + 6])) return true;
        }
        if (board[0].equals(board[4]) && board[4].equals(board[8])) return true;
        if (board[2].equals(board[4]) && board[4].equals(board[6])) return true;
        return false;
    }
}
