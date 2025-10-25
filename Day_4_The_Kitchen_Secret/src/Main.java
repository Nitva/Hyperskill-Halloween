import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Path fileName = Path.of("Day_4_The_Kitchen_Secret/src/hyperskill-dataset.txt");

        String[][] keypad = {
                {"A", "B", "C", "D"},
                {"E", "F", "G", "H"},
                {"I", "J", "K", "L"},
                {"M", "N", "O", "P"}
        };

        try {
            String fileContent = Files.readString(fileName);

            String[] lines = fileContent.split("\n", -1);

            StringBuilder result = new StringBuilder();

            for (String line : lines) {
                line = line.trim();
                int x = 0;
                int y = 0;

                if (!line.isEmpty()) {
                    String[] moves = line.split(",");
                    for (String move : moves) {
                        move = move.trim();
                        switch (move) {
                            case "UP":    if (y > 0) y--; break;
                            case "DOWN":  if (y < 3) y++; break;
                            case "LEFT":  if (x > 0) x--; break;
                            case "RIGHT": if (x < 3) x++; break;
                        }
                    }
                }

                result.append(keypad[y][x]);
            }

            System.out.println(result);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
