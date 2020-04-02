import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PopularNames {

    public static void popularNamesByDecade(List<Person> persons, int year, int decade){
        try {
           int index = ((year - decade) / 10) + 1;

           List<String> popularNames = persons.stream()
                   .map(s -> new Person(s.getName(), listOneValue(s.getDecade().get(index))))
                   .filter(s -> Person.noZero(s.getDecade()))
                   .sorted(Comparator.comparing(o -> String.valueOf(o.getDecade().get(0))))
                   .map(s -> s.getName() + " ")
                   .collect(Collectors.toList());

           System.out.println("The most popular names(from most popular to least), for this decade are: ");
           System.out.println(popularNames);

       }catch(ArrayIndexOutOfBoundsException e){
           System.out.println("Please enter a a valid decade for the file you have selected !!!");
       }
    }


    public static List<Integer> listOneValue(Integer i) {
        List<Integer> oneVal = new ArrayList<>();
        oneVal.add(i);

        return oneVal;

    }


}
