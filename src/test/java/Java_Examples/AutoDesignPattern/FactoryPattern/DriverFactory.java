package Java_Examples.AutoDesignPattern.FactoryPattern;

public class DriverFactory {
    public static BrowserDriver getDriver(String BrowserType) {
        // Enhanced Switch Statement
        return switch (BrowserType.toLowerCase()) {
            case "chrome" -> new ChromeDriverManager();
            case "firefox" -> new FireFoxDriverManager();
            case "edge" -> new EdgeDriverManager();
            default -> throw new IllegalArgumentException("Invalid Browser Passed:" + BrowserType);
        };
    }
}
