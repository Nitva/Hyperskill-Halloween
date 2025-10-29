import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Path fileName = Path.of("Day_8_The_Eldritch_Horror/src/hyperskill-dataset.txt");

        try {

            String content = Files.readString(fileName).trim();
            String[] words = content.split("\\s+");


            Map<String, Integer> anagramCounts = new HashMap<>();


            for (String word : words) {
                String signature = sortLetters(word);
                anagramCounts.put(signature, anagramCounts.getOrDefault(signature, 0) + 1);
            }


            for (String word : words) {
                String signature = sortLetters(word);
                if (anagramCounts.get(signature) == 1) {
                    System.out.println(word);
                    return;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }


    private static String sortLetters(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
