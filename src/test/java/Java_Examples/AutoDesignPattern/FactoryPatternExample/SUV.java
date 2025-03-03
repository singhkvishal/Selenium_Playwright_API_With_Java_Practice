package Java_Examples.AutoDesignPattern.FactoryPatternExample;

public class SUV implements Car{
    @Override
    public void assemble() {
        System.out.println("SUV --- Assemble here");
    }
}
