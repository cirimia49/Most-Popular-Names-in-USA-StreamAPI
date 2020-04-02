import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    public String name;
    public List<Integer> decade;


    public Person(String name, List<Integer> eachRank){
        this.name = name;
        this.decade = List.copyOf(eachRank);

    }


    public String getName() {
        return this.name;
    }


    public List<Integer> getDecade() { return this.decade; }


    public static List<Person> allPerson(int decades, List<String> onlyNames){

        List<Person> personNamesList = onlyNames.stream()
                .map(s -> s.split(" "))
                .map(s -> new Person(s[0], readStreamInList(1, decades + 1, s)))
                .collect(Collectors.toList());

        return personNamesList;
    }


    public static List<Integer>readStreamInList(int beginning, int end, String [] s){

        List<Integer> li= new ArrayList<>();
        for(int i = beginning; i< end; i++) {
            if(i<s.length){
                int k = Integer.valueOf(s[i]);
                li.add(k);
            }
            else
                li.add(0);
        }
        return li;
    }


    public static boolean noZero(List<Integer> li){
        for(int i = 0; i < li.size(); i++){
            if(li.get(i) == 0)
                return false;
        }
        return true;
    }
}
