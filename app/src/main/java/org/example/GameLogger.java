package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class GameLogger {
    public static void saveLogToFile() {
        try (FileWriter writer = new FileWriter("game_log.txt")) {
            writer.write("Final Game Summary:\n");
            writer.write("X wins: " + Game.xWins + "\n");
            writer.write("O wins: " + Game.oWins + "\n");
            writer.write("Ties: " + Game.ties + "\n");
        } catch (IOException e) {
            System.out.println("Error saving game log.");
        }
    }
}
