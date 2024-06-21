package Java_Examples;

public class ReverseString {
    public static void main(String[] args) {

        String name="My Name is Vishal";

        char []rev=name.toCharArray();

        for(int i=rev.length-1;i>=0;i--){
            System.out.print(rev[i]);
        }
    }
}
