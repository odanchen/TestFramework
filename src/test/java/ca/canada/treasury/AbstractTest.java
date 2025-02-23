package ca.canada.treasury;

import ca.canada.driver.DriverProvider;
import ca.canada.listeners.LoggerListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@Listeners({LoggerListener.class})
public abstract class AbstractTest {
    @AfterClass
    public void quitDriver() {
        DriverProvider.getDriver().quit();
    }
}
