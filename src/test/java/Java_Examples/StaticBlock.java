package Java_Examples;

public class StaticBlock {

    // Constructor of the class StaticBlock3
    StaticBlock() {
        System.out.println("Inside the constructor of the class.");
    }

    public static void foo() {
        System.out.println("Inside the method foo.");
    }

    static int st = 9;

    // static block
    static {
        foo();
        System.out.println(st);
        System.out.println("Inside the static block. - 1");
    }

    // main method
    public static void main(String[] args) {
// instantiating the class StaticBlock3
        StaticBlock sbObj = new StaticBlock();
    }
}
