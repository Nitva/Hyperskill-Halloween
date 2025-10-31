import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path fileName = Path.of("Day_10_The_Good_Ending/src/hyperskill-dataset.txt");

        try {
            String content = Files.readString(fileName).trim();
            String[] lines = content.split("\n");

            for (String line : lines) {

                String left = line.substring(0, 8);
                String right = line.substring(8, 16);

                char leftUnpaired = 0;
                char rightUnpaired = 0;


                for (int i = 0; i < left.length(); i++) {
                    char c = left.charAt(i);
                    if (right.indexOf(c) != -1) {

                        right = right.replaceFirst(Character.toString(c), "");
                    } else {
                        leftUnpaired = c;
                    }
                }

                if (!right.isEmpty()) {
                    rightUnpaired = right.charAt(0);
                }

                System.out.print("" + leftUnpaired + rightUnpaired);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
