import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        Path fileName = Path.of("Day_6_Lets_do_the_Runtime_Warp_again/src/hyperskill-dataset.txt");
        try {
            String fileContent = Files.readString(fileName);
            String[] lines = fileContent.split("\n", 0);
            int counter = 0;
            int totalDistance = 0;
            int[][] numbers = new int[lines.length][];

            for(String line : lines) {
                numbers[counter] = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
                counter++;
            }

            for (int i = 0; i < numbers.length - 1; i++) {
                int[] a = numbers[i];
                int[] b = numbers[i + 1];


                double distance = Math.sqrt(
                        Math.pow(b[0] - a[0], 2) +
                        Math.pow(b[1] - a[1], 2) +
                        Math.pow(b[2] - a[2], 2) +
                        Math.pow(b[3] - a[3], 2)
                );


                int rounded = (int) Math.ceil(distance);

                totalDistance += rounded;

            }

            System.out.println("Total distance: " + totalDistance);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }


    }

}