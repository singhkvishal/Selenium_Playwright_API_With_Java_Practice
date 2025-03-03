package Java_Examples.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProrgamStartWithChar {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Java","Java Script","C","Python"));
        List<String> filteredList = new ArrayList<>();
        for(String s:list) {
            if(s.startsWith("J")) {
                filteredList.add(s);
            }
        }
        System.out.println(Arrays.toString(filteredList.toArray()));

        List<String> list1 = new ArrayList<>(Arrays.asList("Jzzz","Java","Java Script","C","Python"));
        System.out.println(list1.stream().filter(n->n.startsWith("J")).sorted().toList());
    }
}
