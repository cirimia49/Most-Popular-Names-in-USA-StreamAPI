import java.util.List;

public class DecadesInfo {

    // Methods to get the first decade and the number of decades specified in file
    public static int getNumDecade(List<String> first2Lines){

        return first2Lines.stream()
                .filter(s -> s.length() < 4)
                .findFirst()
                .map(n -> Integer.parseInt(n))
                .orElse(0);
    }


    public static int getFirstDecade(List<String> first2Lines){

        return first2Lines.stream()
                .findFirst()
                .map(n -> Integer.parseInt(n))
                .orElse(0);
    }
}
