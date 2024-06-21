package Java_Examples;

public class Test4 {
    public static void main(String[] args) {
        System.out.println(recursiveMethod("Vishal Singh"));
    }
    static String recursiveMethod(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return recursiveMethod(str.substring(1)) + str.charAt(0);
    }

}
