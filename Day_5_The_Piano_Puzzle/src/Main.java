import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path fileName= Path.of("Day_5_The_Piano_Puzzle/src/hyperskill-dataset.txt");
        try {
            String fileContent = Files.readString(fileName);
            String musicalNotes = "ABCDEFG";



            for(int i=0;i<fileContent.length()-7;i++){
                String sequences = fileContent.substring(i,i+7);
                boolean contains = musicalNotes.chars().allMatch(c -> sequences.indexOf(c) >= 0);
                if (contains){
                    System.out.println(sequences);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }


    }
}