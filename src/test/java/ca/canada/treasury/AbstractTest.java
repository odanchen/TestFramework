package ca.canada.treasury;

import ca.canada.driver.DriverProvider;
import ca.canada.listeners.LoggerListener;
import ca.canada.listeners.ScreenshotListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@Listeners({LoggerListener.class, ScreenshotListener.class})
public abstract class AbstractTest {
    @AfterClass
    public void quitDriver() {
        DriverProvider.getDriver().quit();
    }
}
