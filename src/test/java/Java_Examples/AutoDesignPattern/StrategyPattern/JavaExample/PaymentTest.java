package Java_Examples.AutoDesignPattern.StrategyPattern.JavaExample;

public class PaymentTest {
    public static void main(String[] args) {
        PaymentContext context=new PaymentContext(new CreditCardPayment());
        context.pay(123.123);

        context.setPaymentStrategy(new OnlinePayment());
        context.pay(345435.45);

        context.setPaymentStrategy(new DebitCardPayment());
        context.pay(345);
    }
}
