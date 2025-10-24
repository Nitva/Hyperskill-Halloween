import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {
    public static void main(String[] args)  {
        Path fileName = Path.of( "Day_2_The_White_Noise/src/hyperskill-dataset-117322181.txt");



        try {
            String fileContent = Files.readString(fileName);;
            String[] lines = fileContent.split(",");






        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
