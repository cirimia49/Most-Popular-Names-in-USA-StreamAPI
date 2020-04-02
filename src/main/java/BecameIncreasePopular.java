import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BecameIncreasePopular {

    public static void hasBecameIncreasePopular(Path path, List<String> file) {

        for (String s : file) {
            System.out.println(" ");

            String[] line = s.split(" ");
            String[] ranks = new String[line.length - 1];

            for (int i = 0; i < line.length - 1; i++) {
                ranks[i] = line[i + 1];
            }

            List<String> lines = Arrays.asList(ranks);
            List<String> onlyRanks = lines.stream()
                    .collect(Collectors.toList());

            List<String> lookAtFirstElement = lines.stream()
                    .collect(Collectors.toList());


            String isFirstZero = lookAtFirstElement.stream()
                    .filter(l -> l.length() > 0)
                    .findFirst()
                    .orElse("");

            // If first element is 0 replace it with 1001
            if (isFirstZero.equals("0"))
                lookAtFirstElement.set(0, "1001");

            List<String> ranksSortedDecreasing = lines.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

                String has = "";

            if (isSorted(onlyRanks, ranksSortedDecreasing))
                has = " (true) ---> HAS became increasingly popular over each decade";
            else
                has = " (false) ---> HAS NOT became increasingly  popular over each decade";

            System.out.println("The name: " + line[0] + has);

        }
    }


    public static boolean isSorted(List<String> onlyRanks, List<String> ranksSortedDecreasing){
            return onlyRanks.equals(ranksSortedDecreasing);
        }
}
