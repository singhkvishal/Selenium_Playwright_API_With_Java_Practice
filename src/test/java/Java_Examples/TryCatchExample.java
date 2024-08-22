package Java_Examples;

//what will be the output of this code

public class TryCatchExample {
    public static void main(String[] args) {
        int m=getNumber("Vishal");
        System.out.println(m);
    }
    public static int getNumber(String name){
        if(name.equals("Vishal")){
            try{
                int i=9/0;
                return  100;
            }catch (ArithmeticException e){
               // System.exit(1); // System.exit(1) -- JVM will get terminated and control will not move to finally block
                return  60;
            }finally {
                return  40;
            }
        }else {
            System.out.println("Check the name");
            return  0;
        }
    }
}
