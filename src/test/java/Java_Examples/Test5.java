package Java_Examples;

public class Test5 {
    public static void main(String[] args) {
        int x = 5;
        int y = 7;
        boolean result = (x > y) && (x++ < y--);
        System.out.println(x);
        System.out.println(y);
        System.out.println(result);
    }
}
