package Java_Examples;

public class LambdaExample {

    public static void main(String[] args) {
        // Using a lambda function to implement the Calculator interface for addition
        Calculator add = (a, b) -> a + b;

        // Using a lambda function to implement the Calculator interface for subtraction
        Calculator subtract = (a, b) -> a - b;

        // Using the lambda functions
        int resultAdd = add.calculate(5, 3); // Result: 8
        int resultSubtract = subtract.calculate(5, 3); // Result: 2

        System.out.println("Addition: " + resultAdd);
        System.out.println("Subtraction: " + resultSubtract);
    }
}
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}


