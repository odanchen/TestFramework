package ca.canada.pageobject;

import ca.canada.driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage<T extends BasePage<T>> {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;

    protected BasePage() {
        this.driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }
    public abstract String getURL();

    @SuppressWarnings("unchecked")
    public T open() {
        LOGGER.info("Navigating to {}", getURL());
        driver.get(getURL());
        return (T) this;
    }
}
