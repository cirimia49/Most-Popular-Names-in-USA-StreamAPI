import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BecameDecreasePopular {

    public static void hasBecameDecreasePopular(Path path, List<String> file) {

        for (String s : file) {
            System.out.println(" ");

            String[] arrayOfString = s.split(" ");
            String[] arrayOfRanks = new String[arrayOfString.length - 1];

            for (int i = 0; i < arrayOfString.length - 1; i++) {arrayOfRanks[i] = arrayOfString[i + 1]; }

            // Create a list of original ranks
            List<String> eachLine = Arrays.asList(arrayOfRanks);
            List<String> ranks = eachLine.stream()
                    .collect(Collectors.toList());

            // Create a list of sorted ranks
            List<String> ranksSortedDecreasing = ranks.stream()
                    .sorted()
                    .collect(Collectors.toList());

            String has = "";

            if (isSorted(ranks, ranksSortedDecreasing))
                has = " (true) ---> HAS became decreasingly popular over each decade";
            else
                has = " (false) ---> HAS NOT became decreasingly popular over each decade";

            System.out.println("The name: " + arrayOfString[0] + has);
        }
    }


    public static boolean isSorted(List<String> ranks, List<String> ranksSorted){
        return ranks.equals(ranksSorted);
    }
}
