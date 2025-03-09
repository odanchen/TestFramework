package ca.canada.actions;

import ca.canada.utils.WaitUtil;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementActions {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementActions.class);
    private ElementActions() {
        throw new RuntimeException("New instance is not permitted");
    }

    public static String getText(WebElement element, String elementName) {
        LOGGER.info("Getting text from element {}", elementName);
        return element.getText();
    }

    public static void clickElement(WebElement element, String elementName) {
        LOGGER.info("Clicking element {}", elementName);
        element.click();
    }

    public static boolean isElementVisible(WebElement element, String elementName) {
        LOGGER.info("Checking if {} is displayed", elementName);
        return element.isDisplayed();
    }

    public static WebElement waitUntilVisible(WebElement element, String elementName) {
        LOGGER.info("Waiting for {} to be displayed", elementName);
        return WaitUtil.waitFor(element).until(e -> {
            if (isElementVisible(e, elementName)) return element;
            return null;
        });
    }
}
