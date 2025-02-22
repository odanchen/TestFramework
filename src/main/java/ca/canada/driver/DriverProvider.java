package ca.canada.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {
    private static WebDriver driver;
    private DriverProvider() {
        throw new RuntimeException("New instance not permitted");
    }

    public static WebDriver createDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver == null ? createDriver() : driver;
    }
}
