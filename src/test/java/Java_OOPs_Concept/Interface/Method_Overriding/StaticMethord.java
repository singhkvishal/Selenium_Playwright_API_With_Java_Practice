
package Java_OOPs_Concept.Interface.Method_Overriding;

class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}

public class StaticMethord extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }

    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        StaticMethord myCat = new StaticMethord();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}
