import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

public static void main(String[] args) {

        Path fileName = Path.of("Day_7_The_Phone_Call/src/hyperskill-dataset.txt");

        try {
            String content = Files.readString(fileName).trim();


            long phone = Long.parseLong(content);
            long doubleWord = 4294967296L; // 2^32
            int overflows = 0;


            while (phone >= doubleWord) {
                phone -= doubleWord;
                overflows++;
            }


            String binary = Long.toBinaryString(phone);


            System.out.println(overflows + "," + binary);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number in file: " + e.getMessage());
        }
    }
}
