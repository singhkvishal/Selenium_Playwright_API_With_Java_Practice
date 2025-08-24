package Java_Examples.InterviewPrograms;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        System.out.println("Prime number "+ isPrime(13));
    }
    public static boolean isPrime(int num){
        for(int i=2;i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
