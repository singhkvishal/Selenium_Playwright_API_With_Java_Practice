package Java_Examples.AutoDesignPattern.FactoryPatternExample;

import java.sql.SQLOutput;

public class Sedan implements Car{
    @Override
    public void assemble() {
        System.out.println("Sadan --- Assemble here");
    }
}
