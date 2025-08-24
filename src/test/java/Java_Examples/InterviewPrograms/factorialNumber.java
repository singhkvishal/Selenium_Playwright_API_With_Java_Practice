package Java_Examples.InterviewPrograms;

public class factorialNumber {
    public static void main(String[] args) {
        System.out.println("factorial value is 4 " + Factorial(4));
    }

    public static int Factorial(int num) {
        int fact = 1;
        for (int i = 0; i < num; i++) {
            fact = fact + fact * i;
        }
        return fact;
    }
}
