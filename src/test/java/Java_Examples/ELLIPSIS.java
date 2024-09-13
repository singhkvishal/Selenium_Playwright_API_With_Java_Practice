package Java_Examples;

//ELLIPSIS is a series of dots or period(‘…’) that are used in almost all languages (No! Not the programming languages,
// the general languages- English, German and so on) which we usually use intentionally to omit a word, sentence, or
// a whole section from a text without altering its original meaning. The dots are used having no gap in between them.
// An example is English, we say: It is not cold… it is freezing cold.

public class ELLIPSIS {
//Java Varargs (Variable Arguments) - Ellipsis Parameter - Vararg Examples
    public static void main(String[] args) {
        ELLIPSIS e = new ELLIPSIS();
        e.printNumbers(1, 2, 3, 5, 6, 7);
    }

    public void printNumbers(int... numbers) {
        System.out.println("[INT] Number of arguments [values.length]: " + numbers.length);

        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
