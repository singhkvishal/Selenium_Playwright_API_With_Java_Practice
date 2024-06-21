package Java_Examples;

public class InternExample {
    public static void main(String args[]) {
        String s1 = new String("hello");
        String s2 = "hello";
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);

        String s3 = s1.intern();//returns string from pool, now it will be same as s2
        System.out.println(s2 == s3);//true because reference variables are pointing to same instance

        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
    }
}