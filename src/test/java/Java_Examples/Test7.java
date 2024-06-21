package Java_Examples;

public class Test7 {
    public static void main(String[] args) {
//Range of byte data in java is -128 to 127. But the byte data type in java is cyclic in nature.
        byte x = 127;
        x++;
        System.out.print(x);
    }
}

