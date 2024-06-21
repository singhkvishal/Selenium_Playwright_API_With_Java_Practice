package Java_Examples;

public class Recursive_Function {
    //
    public static void main(String[] args) {
        System.out.println(FactorialNumber(4));
    }

    static int FactorialNumber(int number){
        if(number==0||number==1){
            return number;
        }else {
            return number * FactorialNumber(number -1);
        }
    }
}