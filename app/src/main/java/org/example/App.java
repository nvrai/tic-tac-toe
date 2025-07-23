package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (playAgain) {
            Board board = new Board();
            Player player1, player2;

            // Select mode: Human vs Human or Human vs Computer
            System.out.print("Do you want to play against (1) Human or (2) Computer? Enter 1 or 2: ");
            int modeSelection = scanner.nextInt();
            boolean isComputer = modeSelection == 2;

            if (isComputer) {
                System.out.print("Do you want to go first? (y/n): ");
                String computerFirstResponse = scanner.next();
                boolean xFirst = !computerFirstResponse.equalsIgnoreCase("y");

                player1 = new Player("X", xFirst ? Player.Type.COMPUTER : Player.Type.HUMAN);
                player2 = new Player("O", xFirst ? Player.Type.HUMAN : Player.Type.COMPUTER);
            } else {
                player1 = new Player("X", Player.Type.HUMAN);
                player2 = new Player("O", Player.Type.HUMAN);
            }

            Game game = new Game(board, player1, player2);
            game.play();

            System.out.println("\nCurrent Score:");
            System.out.println("X wins: " + Game.xWins);
            System.out.println("O wins: " + Game.oWins);
            System.out.println("Ties: " + Game.ties);

            System.out.print("Do you want to play again? (y/n): ");
            String answer = scanner.next();
            playAgain = answer.equalsIgnoreCase("y");
        }

        GameLogger.saveLogToFile();
        System.out.println("Thanks for playing! Saved final statistics to game_log.txt.");
        scanner.close();
    }
}
