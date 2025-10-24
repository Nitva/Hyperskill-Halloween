import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Path fileName = Path.of("Day_3_The_Game_Begins/src/hyperskill-dataset.txt");

        String[] alphabet = new String[]{
                "a","b","c","d","e","f","g","h","i","j","k","l",
                "m","n","o","p","q","r","s","t","u","v","w","x","y","z"
        };
        int[] number = new int[alphabet.length];

        try {
            String fileContent = Files.readString(fileName);

            for (int i = 0; i < fileContent.length(); i++) {
                char c = fileContent.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    number[c - 'a']++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }


        List<Map.Entry<String, Integer>> list = new ArrayList<>();

        for (int i = 0; i < alphabet.length; i++) {
            if (number[i] > 0) {
                list.add(Map.entry(alphabet[i], number[i]));
            }
        }


        list.sort(Comparator.comparingInt(Map.Entry::getValue));


        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
