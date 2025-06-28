package org.example;

import java.util.Scanner;

public class App {
    public static String[] tBoard = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static boolean win = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my Tic Tac Toe game!");
        while (!win) {
            displayBoard();
            chooseNum(scanner);
            checkWin();
            if (win) break;
            displayBoard();
            chooseNumOpp(scanner);
            checkWin();
        }
        scanner.close();
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

    public static void chooseNum(Scanner scanner) {
        System.out.print("Choose where to play X: ");
        int x = scanner.nextInt();
        if (x < 1 || x > 9 || tBoard[x - 1].equals("X") || tBoard[x - 1].equals("O")) {
            System.out.println("Invalid move! Try again.");
            chooseNum(scanner);
        } 
        else {
            tBoard[x - 1] = "X";
        }
    }

    public static void chooseNumOpp(Scanner scanner) {
        System.out.print("Choose where to play O: ");
        int x = scanner.nextInt();
        if (x < 1 || x > 9 || tBoard[x - 1].equals("X") || tBoard[x - 1].equals("O")) {
            System.out.println("Invalid move! Try again.");
            chooseNumOpp(scanner);
        } 
        else {
            tBoard[x - 1] = "O";
        }
    }

    public static void checkWin() {
        // Horizontal
        for (int i = 0; i <= 6; i += 3) {
            if (tBoard[i].equals(tBoard[i + 1]) && tBoard[i + 1].equals(tBoard[i + 2])) {
                System.out.println(tBoard[i] + " has won!");
                win = true;
                return;
            }
        }
        // Vertical
        for (int i = 0; i < 3; i++) {
            if (tBoard[i].equals(tBoard[i + 3]) && tBoard[i + 3].equals(tBoard[i + 6])) {
                System.out.println(tBoard[i] + " has won!");
                win = true;
                return;
            }
        }
        // Diagonal
        if (tBoard[0].equals(tBoard[4]) && tBoard[4].equals(tBoard[8])) {
            System.out.println(tBoard[0] + " has won!");
            win = true;
        } else if (tBoard[2].equals(tBoard[4]) && tBoard[4].equals(tBoard[6])) {
            System.out.println(tBoard[2] + " has won!");
            win = true;
        }
    }

    public static boolean checkWin(String[] board) { // For JUNit testing 
    // Horizontal
    for (int i = 0; i <= 6; i += 3) {
        if (board[i].equals(board[i + 1]) && board[i + 1].equals(board[i + 2])) {
            return true;
        }
    }

    // Vertical
    for (int i = 0; i < 3; i++) {
        if (board[i].equals(board[i + 3]) && board[i + 3].equals(board[i + 6])) {
            return true;
        }
    }

    // Diagonal
    if (board[0].equals(board[4]) && board[4].equals(board[8])) {
        return true;
    } else if (board[2].equals(board[4]) && board[4].equals(board[6])) {
        return true;
    }

    return false;
}

}
