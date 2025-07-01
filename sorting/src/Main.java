import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Men> list = new ArrayList<>();
        list.add(new Men("Mohammad","Ahmed",20));
        list.add(new Men("Syed","Bilal",23));
        list.add(new Men("Danish","Siddiqui",50));
        list.add(new Men("Ahmer","Saleem",16));
        list.add(new Men("Zuhair","Ahmed",22));

        System.out.println("============= List ==================");
        show(list,men -> true, System.out::println);


        System.out.println("============= With A ==================");
        Predicate<Men> startwithA = men -> men.getFirstName().startsWith("A");
        show(list,startwithA, System.out::println);

        System.out.println("============= Age  Sorted ==================");
        list.stream().sorted(Comparator.comparing(Men :: getAge).reversed()).forEach(System.out::println);

        System.out.println("============= Sorted by first name ==================");

        list.stream().sorted(Comparator.comparing(Men::getFirstName)).forEach(System.out::println);

    }

//    private static void firstNameAlphabetical(List<Men> list) {
//       list.stream()
//               .sorted(Comparator.comparing(Men::getFirstName))
//               .forEach(System.out::println);
//    }
//
//    private static void ageSort(List<Men> list) {
//     list.stream()
//             .sorted(Comparator.comparing(Men::getAge)
//                     .reversed()).forEach(System.out::println);
//    }
//    public static void firstnamesWithA(List<Men> list) {
//      list.stream().filter(men-> men.getFirstName().startsWith("A"))
//              .forEach(System.out::println);
//    }

    public static void show(List<Men> list, Predicate<Men> pre, Consumer<Men> cons) {
//        list.stream().forEach(System.out::println);

        list.stream().filter(pre).forEach(cons);
    }

    }
