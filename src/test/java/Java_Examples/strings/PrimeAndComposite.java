package Java_Examples.strings;

import org.testng.annotations.Test;

import java.util.Scanner;

public class PrimeAndComposite {

    @Test//a number that can be divided exactly only by itself and 1
    public void CheckPrimeNumber() {
        int n = 19;

        if (n == 0 || n == 1) {
            System.out.println(false);
        }
        if (n == 2) {
            System.out.println(true);
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.println(false);
            }
        }
        System.out.println(true);
    }

    @Test//A number that is divisible by a number apart from 1 and the number itself, is called a composite number.
    // For example, 4 is a number that is divisible by 1, 2, and 4, therefore, it is a composite number.
    public void CheckCompositeNumber() {
      //  System.out.print("Enter any number : ");
       // Scanner in=new Scanner(System.in);

        int number=15;//in.nextInt();
        int i=1,count=0;
        while(i<=number)
        {
            if(number%i==0)
            {
                count++;
            }
            i++;
        }
        if(count>2)
        {
            System.out.println(number+" is composite number ");
        }
        else
        {
            System.out.println(number+" is not composite number");
        }
    }

    @Test//The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones
    public void FibonacciExample(){
        int n1=0,n2=1,n3,i,count=10;
        System.out.print(n1+" "+n2);//printing 0 and 1

        for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }

    }
}

