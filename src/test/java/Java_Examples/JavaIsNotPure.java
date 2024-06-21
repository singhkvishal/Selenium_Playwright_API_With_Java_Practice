package Java_Examples;

public class JavaIsNotPure {
    public static void main(String[] args) {

            Integer i =   Integer.valueOf(10);
            Integer j =   Integer.valueOf(20);
            Integer k =   Integer.valueOf(i.intValue() + j.intValue());
            System.out.println("Output: "+ k);

            String a= new String("Test");
            String b= new String("Test");
            if(a.equals(b)){
                System.out.println("A is Equals to B");
            }else {
                System.out.println("A is Equals to B");
            }
        }

}
