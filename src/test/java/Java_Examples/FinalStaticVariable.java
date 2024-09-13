package Java_Examples;

public class FinalStaticVariable {
    int a;
    static int b;
    final int c=1;
    final static int d=2;

    public  static void main(String arg[]){
        FinalStaticVariable o=new FinalStaticVariable();

        System.out.println(o.a);
        System.out.println(b);// no need to use object for static variables
        System.out.println(o.c);
        System.out.println(d);
    }
}
