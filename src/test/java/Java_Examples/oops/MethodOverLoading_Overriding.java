package Java_Examples.oops;

class Demo {
    public int get(int a) {
        return 10;
    }
}

class MethodOverLoading_Overriding extends Demo {
    //int and Integer are two different types. Autoboxing blurs the distinction at the source code
    // The reason the override doesn't work because Integerand int are two different things.
    // Integer is an object, whereas int is a primitive type. Java does the implicit typecasting for you. For example:
    //int myInteger = new Integer(5);
    public int get(Integer a) {
        return 20;
    }

    public static void main(String[] args) {
        Demo d = new MethodOverLoading_Overriding();
        System.out.println(d.get(1));
    }
}