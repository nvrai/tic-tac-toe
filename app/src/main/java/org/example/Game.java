package org.example;

public class Game {
    public static int xWins = 0;
    public static int oWins = 0;
    public static int ties = 0;

    private Board board;
    private Player player1;
    private Player player2;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        boolean win = false;

        while (!win && !board.isBoardFull()) {
            board.displayBoard();
            player1.makeMove(board, new java.util.Scanner(System.in));
            if (checkWin()) {
                System.out.println(player1.getSymbol() + " has won!");
                xWins++;
                win = true;
                break;
            }
            if (board.isBoardFull()) break;

            board.displayBoard();
            player2.makeMove(board, new java.util.Scanner(System.in));
            if (checkWin()) {
                System.out.println(player2.getSymbol() + " has won!");
                oWins++;
                win = true;
                break;
            }
        }

        if (!win && board.isBoardFull()) {
            System.out.println("It's a tie!");
            ties++;
        }
    }

    public boolean checkWin() {
        return new Player(player1.getSymbol(), Player.Type.HUMAN).checkWin(board.getBoard(), player1.getSymbol()) ||
                new Player(player2.getSymbol(), Player.Type.HUMAN).checkWin(board.getBoard(), player2.getSymbol());
    }
}
