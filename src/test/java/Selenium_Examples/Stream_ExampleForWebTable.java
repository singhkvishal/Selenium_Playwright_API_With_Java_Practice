package Selenium_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Stream_ExampleForWebTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
        // click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // capture all webelements into list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        // capture text of all webelements into new(original) list
        List<String> originalList = elementsList.stream().map(WebElement::getText).toList();

        // sort on the original list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().toList();

        // compare original list vs sorted list
        Assert.assertEquals(sortedList, originalList);

        List<String> price;

        // scan the name column with getText ->Beans->print the price of the Rice
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(Stream_ExampleForWebTable::getPriceVeggie).toList();

            price.forEach(System.out::println);
            if (price.isEmpty()) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.isEmpty());
    }

    private static String getPriceVeggie(WebElement s) {
        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return pricevalue;
    }
}
