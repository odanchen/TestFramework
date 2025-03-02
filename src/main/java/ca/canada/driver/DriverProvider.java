package ca.canada.driver;

import ca.canada.config.FrameworkConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverProvider {
    private static WebDriver driver;
    private DriverProvider() {
        throw new RuntimeException("New instance not permitted");
    }

    public static WebDriver createDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        boolean isHeadless = FrameworkConfig.getConfig().isHeadless();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        if (isHeadless) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver == null ? createDriver() : driver;
    }
}
