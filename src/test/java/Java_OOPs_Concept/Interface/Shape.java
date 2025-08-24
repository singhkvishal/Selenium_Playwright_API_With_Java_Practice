package Java_OOPs_Concept.Interface;

// Define an interface named Shape
interface Shape {
    double calculateArea(); // Abstract method for
    // calculating the area
    default void Test(){
        System.out.println("This is Default Method");
    }
    public static void TestStatic(){
        System.out.println("This is Static Method");
    }
}