package Java_Examples.AutoDesignPattern.StrategyPattern.JavaExample;

public class DebitCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Payment Amount : " + amount);
    }

}
