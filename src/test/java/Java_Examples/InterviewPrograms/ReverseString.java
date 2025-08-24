package Java_Examples.InterviewPrograms;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {
    @Test
    public void ReverseString() {
        String str = "My name is Vishal";

        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }

    @Test
    public void ReverseString1() {
        String str = "My name is Vishal";
        char[] rev = str.toCharArray();

        for (int i = rev.length - 1; i >= 0; i--) {
            System.out.print(rev[i]);
        }
    }

    @Test
    public void ReverseStringBuilder() {
        String str = "My name is Vishal";
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println(reversed);
    }

    @Test
    public void ReverseStream() {
        String str = "My name is Vishal";
        String revString = Stream.of(str).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
        System.out.println(revString);
    }
}
