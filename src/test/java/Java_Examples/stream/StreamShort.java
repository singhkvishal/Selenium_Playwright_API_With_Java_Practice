package Java_Examples.stream;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamShort {
    @Test
    public void ShortList() {
        List<String> list = new ArrayList<>(Arrays.asList("Vishal", "Singh"));

        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
    }

    @Test
    public void ReverseMyWorlds() {
        String text = "My name is Vishal Singh";

        Stream<String> s = Arrays.stream(text.split(" "));
        //System.out.println(s.forEach();
    }

    @Test
    public void Test() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer sum = list.stream().reduce(5, (a, b) -> a + b);
        System.out.println(sum);
       // Integer psum = list.parallelStream().reduce(5, (a, b) -> a + b);
        Integer psum = list.parallelStream().reduce(5, Integer::sum);
        System.out.println(psum);
        System.out.println(sum == psum);

        ArrayList<Integer> a = new ArrayList<>();
    }

    @Test
    public void Test1() {
        List<String> list = Arrays.asList("Hello ", "G", "E", "E", "K", "S!");
        list.forEach(System.out::print);
        list.stream().forEach(System.out::print);
        list.parallelStream().forEach(System.out::print);
        list.parallelStream().forEachOrdered(System.out::print);
    }
}