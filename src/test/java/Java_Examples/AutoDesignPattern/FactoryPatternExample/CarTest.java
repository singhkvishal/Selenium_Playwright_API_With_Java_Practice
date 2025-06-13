package Java_Examples.AutoDesignPattern.FactoryPatternExample;

public class CarTest {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        carFactory.getCar("SUV").assemble();

        carFactory.getCar("Mini").assemble();

        carFactory.getCar("Sedan").assemble();
    }
}
