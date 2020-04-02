import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfDecades {
    public static void numberOfDecades(Path path , List<String> file){

        for (String s: file) {
            if(s.length() > 4) {
                System.out.println(" ");

                String[] line = s.split(" ");

                List<String> lines = Arrays.asList(line);

                List<String> decadesTop1000 = lines.stream()
                        .filter(l -> ! (l.equals("0")))
                        .collect(Collectors.toList());

                int numOfDecades = decadesTop1000.size() - 1;

                System.out.println("The Name: " + line[0] + ", has been in top 1000 for a number of ---> " + numOfDecades + " decades");
            }
        }
    }
}
