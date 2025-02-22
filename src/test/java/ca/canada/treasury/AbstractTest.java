package ca.canada.treasury;

import ca.canada.driver.DriverProvider;
import org.testng.annotations.AfterClass;

public abstract class AbstractTest {
    @AfterClass
    public void quitDriver() {
        DriverProvider.getDriver().quit();
    }
}
