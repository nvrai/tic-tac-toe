package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static String[] tBoard;
    public static boolean win = false;

    // Game statistics
    public static int xWins = 0;
    public static int oWins = 0;
    public static int ties = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        boolean xFirst = true;

        System.out.println("Welcome to my Tic Tac Toe game!");

        while (playAgain) {
            resetBoard();
            win = false;

            while (!win && !isBoardFull()) {
                displayBoard();

                if (xFirst) {
                    chooseNum(scanner, "X");
                    if (checkWin(tBoard)) {
                        System.out.println("X has won!");
                        xWins++;
                        win = true;
                        xFirst = false; // Loser goes first next round
                        break;
                    }
                    if (isBoardFull()) break;

                    displayBoard();
                    chooseNum(scanner, "O");
                    if (checkWin(tBoard)) {
                        System.out.println("O has won!");
                        oWins++;
                        win = true;
                        xFirst = true;
                        break;
                    }
                } else {
                    chooseNum(scanner, "O");
                    if (checkWin(tBoard)) {
                        System.out.println("O has won!");
                        oWins++;
                        win = true;
                        xFirst = true;
                        break;
                    }
                    if (isBoardFull()) break;

                    displayBoard();
                    chooseNum(scanner, "X");
                    if (checkWin(tBoard)) {
                        System.out.println("X has won!");
                        xWins++;
                        win = true;
                        xFirst = false;
                        break;
                    }
                }
            }

            if (!win && isBoardFull()) {
                System.out.println("It's a tie!");
                ties++;
            }

            displayBoard();
            System.out.println("\nCurrent Score:");
            System.out.println("X wins: " + xWins);
            System.out.println("O wins: " + oWins);
            System.out.println("Ties: " + ties);

            System.out.print("Do you want to play again? (y/n): ");
            String answer = scanner.next();
            playAgain = answer.equalsIgnoreCase("y");
        }

        saveLogToFile();
        System.out.println("Thanks for playing! Saved final statistics to game_log.txt.");
        scanner.close();
    }

    public static void resetBoard() {
        tBoard = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    public static void displayBoard() {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0) {
                System.out.print("\n" + tBoard[i] + " ");
            } else {
                System.out.print(tBoard[i] + " ");
            }
        }
        System.out.println();
    }

    public static void chooseNum(Scanner scanner, String player) {
        System.out.print("Choose where to play " + player + ": ");
        int x;
        try {
            x = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Clear buffer
            System.out.println("Invalid input. Try again.");
            chooseNum(scanner, player);
            return;
        }

        if (x < 1 || x > 9 || tBoard[x - 1].equals("X") || tBoard[x - 1].equals("O")) {
            System.out.println("Invalid move! Try again.");
            chooseNum(scanner, player);
        } else {
            tBoard[x - 1] = player;
        }
    }

    public static boolean checkWin(String[] board) {
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

    public static boolean isBoardFull() {
        for (String s : tBoard) {
            if (!s.equals("X") && !s.equals("O")) {
                return false;
            }
        }
        return true;
    }

    public static void saveLogToFile() {
        try (FileWriter writer = new FileWriter("game_log.txt")) {
            writer.write("Final Game Summary:\n");
            writer.write("X wins: " + xWins + "\n");
            writer.write("O wins: " + oWins + "\n");
            writer.write("Ties: " + ties + "\n");
        } catch (IOException e) {
            System.out.println("Error saving game log.");
        }
    }
}
