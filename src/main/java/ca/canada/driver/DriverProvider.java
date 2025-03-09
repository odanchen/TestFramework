package ca.canada.driver;

import ca.canada.config.FrameworkConfig;
import ca.canada.utils.FrameworkException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;

public class DriverProvider {
    private static WebDriver driver;

    private DriverProvider() {
        throw new RuntimeException("New instance not permitted");
    }

    private static DriverManagerType getBrowserType(String browser) {
        return Arrays.stream(DriverManagerType.values())
                .filter(item -> item.getBrowserName().equalsIgnoreCase(browser))
                .findFirst()
                .orElseThrow(() -> new FrameworkException(String.format("The following browser %s is not supported", browser)));
    }

    private static WebDriver createChromeDriver(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        if (isHeadless) {
            options.addArguments("--headless=new");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean isHeadless) {
        var options = new FirefoxOptions();
        options.addArguments("--window-size=1920,1080");
        if (isHeadless) {
            options.addArguments("-headless");
        }
        return new FirefoxDriver(options);
    }

    public static WebDriver createDriver() {
        String browser = FrameworkConfig.getConfig().getBrowser();
        boolean isHeadless = FrameworkConfig.getConfig().isHeadless();
        WebDriverManager.getInstance(getBrowserType(browser)).setup();
        switch (getBrowserType(browser)) {
            case CHROME:
                return driver = createChromeDriver(isHeadless);
            case FIREFOX:
                return driver = createFirefoxDriver(isHeadless);
            default:
                throw new FrameworkException(String.format("The following browser %s is not supported", browser));
        }
    }

    public static WebDriver getDriver() {
        return driver == null ? createDriver() : driver;
    }
}
