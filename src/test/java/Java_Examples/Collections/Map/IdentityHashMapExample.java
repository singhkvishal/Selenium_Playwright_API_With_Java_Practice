package Java_Examples.Collections.Map;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put("A", 1);
        identityHashMap.put(new String("A"), 2);
        System.out.println(identityHashMap.size()); // 2
        System.out.println(identityHashMap.get("A")); // 1

        Map<String, Integer> hm = new IdentityHashMap<>();
        hm.put(new String("A"), 1);
        hm.put(new String("A"), 1);
        System.out.println(hm);
    }
}
