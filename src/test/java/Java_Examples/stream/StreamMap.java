package Java_Examples.stream;

import java.util.*;
import java.util.stream.Collectors;


public class StreamMap {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>(Arrays.asList("Vishal","Singh"));
        //List<String> listUpper = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
       List<String> listUpper = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(listUpper);
    }
}