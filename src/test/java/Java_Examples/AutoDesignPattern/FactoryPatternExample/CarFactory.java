package Java_Examples.AutoDesignPattern.FactoryPatternExample;

public class CarFactory {
    public Car getCar(String carType){
        if(carType==null){
            return null;
        }
        if(carType.equalsIgnoreCase("SEDAN")){
            return new Sedan();
        }
        if(carType.equalsIgnoreCase("MINI")){
            return new Mini();
        }
        if(carType.equalsIgnoreCase("SUV")){
            return new SUV();
        }
        return null;
    }
}
