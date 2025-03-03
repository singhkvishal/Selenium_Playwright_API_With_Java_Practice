package Java_Examples.AutoDesignPattern.FactoryPatternExample;

public class CarTest {
    public static void main(String[] args) {
        CarFactory carFactory=new CarFactory();

        Car suvChar=carFactory.getCar("SUV");
        suvChar.assemble();

        Car miniCar=carFactory.getCar("Mini");
        miniCar.assemble();

        Car sedanChar=carFactory.getCar("Sedan");
        sedanChar.assemble();
    }
}
