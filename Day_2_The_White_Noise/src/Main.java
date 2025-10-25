import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;


public class Main {
    public static void main(String[] args)  {
        Path fileName = Path.of( "Day_2_The_White_Noise/src/hyperskill-dataset.txt");
        int rotation=0;




        try {
            String fileContent = Files.readString(fileName);
            String[] lines = fileContent.split("[,\\s]+");

            for(String line : lines) {
                int temp=Integer.parseInt(line);
                if(temp<=360) {
                    rotation=(rotation+temp)%360;
                }else{ rotation=rotation+(temp%360);}
                }

            System.out.println(rotation<0 ? rotation+360:rotation);



        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
