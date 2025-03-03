package Java_Examples.stream;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Filter_Examples {
    @Test
    public void CountTheArrayListValues() {
        ArrayList<String> name = new ArrayList<>();
        name.add("Vishal");
        name.add("singh");
        name.add("Chaudhary");

        int count = 0;
        for (int i = 0; i < name.size(); i++) {
            String actual = name.get(i);
            if (actual.startsWith("C")) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void StreamFilter() {
        ArrayList<String> name = new ArrayList<>();
        name.add("Vishal");
        name.add("singh");
        name.add("Chaudhary");
        Long c = name.stream().filter(s -> s.startsWith("C")).count();
        System.out.println(c);
        //Print out all the ArrayList
        name.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

        name.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
    public void StreamFilter1() {
        long d = Stream.of("Vishal", "Singh", "Chaudhary").filter(s -> {
            s.startsWith("C");
            return true;
        }).count();
        System.out.println(d);
    }

    @Test
    public void MapTest() {
        //Print names which have last latter as "y" with uppercase
        Stream.of("Vishal", "Vasu", "Singh", "Chaudhary", "abcy").filter(s -> s.endsWith("y")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //Print names witch have first letter as a with uppercase sorted
        List<String> names = Arrays.asList("Vishal", "Vasu", "Singh", "Chaudhary", "abcy");
        names.stream().filter(s -> s.startsWith("V")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
    }

    @Test
    public void MergeArray() {
        ArrayList<String> names1 = new ArrayList<>();
        names1.add("Vishal");
        names1.add("singh");
        names1.add("Chaudhary");

        List<String> names2 = Arrays.asList("Vishal1", "Vasu1", "Singh1", "Chaudhary1", "abcy");

        Stream<String> newSteram = Stream.concat(names1.stream(), names2.stream());

        //Search value
        boolean found = newSteram.anyMatch(s -> s.equalsIgnoreCase("singh"));
        System.out.println(found);
    }

    @Test
    public void StreamCollect() {
        List<String> ls = Stream.of("Vishal", "Vasu", "Singh", "Chaudhary", "abcy").filter(s -> s.endsWith("y")).map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(ls.get(0));
    }

    @Test
    public void PrintUniqueNumner() {
        List<Integer> Values = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6, 6, 7);
        Values.stream().distinct().forEach(s -> System.out.print(s + " "));
    }

    @Test
    public void PrintAssendingOrder() {
        List<Integer> Values = Arrays.asList(2, 4, 1, 6, 2, 5, 90);
        List<Integer> ListValue = Values.stream().distinct().sorted().collect(Collectors.toList());
        ListValue.stream().forEach(s -> System.out.println(s));
    }

    @Test
    public void PrintdescendingOrder() {
        List<Integer> Values = Arrays.asList(2, 4, 1, 6, 2, 5, 90);
        List<Integer> ListValue = Values.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        ListValue.stream().forEach(s -> System.out.print(s));
    }

    @Test
    public void PrintDistinctValues() {
        List<Integer> Values = Arrays.asList(2, 4, 1, 1, 6, 2, 5, 90);
        List<Integer> ListValue = Values.stream().distinct().collect(Collectors.toList());
        ListValue.stream().forEach(s -> System.out.print(s));
    }

    @Test
    public void SecondLargestNumber() {
        List<Integer> Values = Arrays.asList(2, 4, 1, 1, 6, 2, 5, 90);
        System.out.println(Values.stream().sorted(Collections.reverseOrder()).distinct().limit(2).skip(1).findFirst().get());
    }

}
