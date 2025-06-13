package TestNG_Examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Example {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "data one" }, { "data two" }, { "data three" } };
    }

    @Test(dataProvider = "data-provider")
    public void testMethod(String data) {
        System.out.println("Data is: " + data);
    }
}
