package Java_Examples;

public class StaticMethord {
    public static  boolean PrintHello(){
        System.out.println("Hello Static");
        return false;
    }
    static  boolean p=PrintHello();
    public static void main(String[] args) {
          //boolean p=PrintHello();
    }
}
