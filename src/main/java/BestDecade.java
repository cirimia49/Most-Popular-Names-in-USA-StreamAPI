import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestDecade {

    public static void bestDecade(Path path, List<String> list) throws IOException {

            for (String s : list) {
                if(s.length() > 4) {
                    System.out.println(" ");
                    String[] num = s.split(" ");

                    String bestDecade = "";
                    Integer min = Integer.MAX_VALUE;
                    int decade = -1;

                    for (int i = 1; i < num.length; i++) {
                        int k = Integer.parseInt(num[i]);

                        if (k <= min && k != 0) {
                            min = k;
                            decade = i - 1;
                        }
                        if (decade == 11 || decade == 10)
                            bestDecade = "2000";
                        else
                            bestDecade = "19" + decade + "0";
                    }

                    System.out.println("For the Name: " + num[0] + " the best decade was --->  " + bestDecade);
                }
            }
    }
}
