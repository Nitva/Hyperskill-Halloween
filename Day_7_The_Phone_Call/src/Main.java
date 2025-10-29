import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        Path fileName = Path.of("Day_7_The_Phone_Call/src/hyperskill-dataset.txt");
        try {
            String fileContent = Files.readString(fileName);
            fileContent=fileContent.trim();
            int phoneNumber = Integer.parseInt(fileContent);
            System.out.println(phoneNumber);


        } catch (IOException  e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (ArithmeticException ex){
            System.err.println("int is too small, falling back to long.");

        }


    }

}