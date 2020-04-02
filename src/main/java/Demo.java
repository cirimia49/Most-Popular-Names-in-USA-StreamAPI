import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        System.out.println(
                "Please enter 1 for selecting File1" + "\n" +
                "Please enter 2 for selecting File2");

        int input = kb.nextInt();
        Path path = getPath(input);

        if(input == 1 || input == 2) {
            System.out.println(
                            "You have selected your file" + "\n" +
                            "Now you have a list of methods you can select from: " + "\n" +
                            "Press 'a' to see the best decade for each name " + "\n" +
                            "Press 'b' to see the number of decades that a name has been in the top 1000 " + "\n" +
                            "Press 'c' to see whether a name has become increasingly popular " + "\n" +
                            "Press 'd' to see whether a name has become decreasingly popular " + "\n" +
                            "Press 'e' to see the most popular names for a given decade "
            );
            String charInput = kb.next();

            readFile(path, charInput);
        }
    }


    public static Path getPath(int n){

        Path path;
        if(n == 1) {
            path = Paths.get("src", "main", "resources", "names_files", "names.txt");
        }
        else if( n == 2){
            path = Paths.get("src", "main", "resources", "names_files", "names2.txt");
        }
        else {
            System.out.println("File Not Found");
            path = null;
        }

        return path;
    }


    public static void readFile(Path path, String input) {

        try(Stream <String> file = Files.lines(path)) {

            List<String> list = file.collect(Collectors.toList());

            List<String> first2Lines = list.stream()
                    .filter(s -> s.length() < 5)
                    .collect(Collectors.toList());

            int firstDecade = DecadesInfo.getFirstDecade(first2Lines);
            int numOfDecades = DecadesInfo.getNumDecade((first2Lines));

            List <String> onlyNames = getNamesOnly(list);

            try {
                if (input.equals("a"))
                    BestDecade.bestDecade(path, list);
                else if (input.equals("b"))
                    NumberOfDecades.numberOfDecades(path, list);
                else if (input.equals("c"))
                    BecameIncreasePopular.hasBecameIncreasePopular(path, list);
                else if (input.equals("d"))
                    BecameDecreasePopular.hasBecameDecreasePopular(path, list);
                else if(input.equals("e")) {

                      try {
                          Scanner kb = new Scanner(System.in);
                          System.out.println("Enter the decade in form of the whole year: " + "\n" +
                                  "e.g.: 1930 ");
                          int dec = Integer.parseInt(kb.nextLine());

                          List<Person> personNameList = Person.allPerson(numOfDecades, onlyNames);
                          PopularNames.popularNamesByDecade(personNameList, dec, firstDecade);

                      }catch(ArrayIndexOutOfBoundsException e ){
                          System.out.println("Please enter a valid decade for the file you have selected !!!");
                      }
                }
                else
                    throw new InputMismatchException("Please enter a valid character");

            }catch(InputMismatchException e) {
                System.out.println("Please enter a valid character and try again");
            }
        }catch(IOException e){
            System.out.println("File was not Found");
        }

    }


    public static List<String> getNamesOnly(List<String> file){

        List<String> onlyNames = file.stream()
                .filter(s -> s.matches("[A-Za-z].*"))
                .collect(Collectors.toList());

        return onlyNames;
    }


}
