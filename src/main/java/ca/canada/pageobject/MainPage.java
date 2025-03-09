package ca.canada.pageobject;

import ca.canada.actions.ElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BasePage<MainPage> {
    private static final String MENU_BUTTON_NAME = "Menu button";
    @FindBy(css = "#wb-auto-2 > h2")
    private WebElement menuButtonText;
    @FindBy(css = "#wb-auto-2 > button")
    private WebElement menuButton;
    @FindBy(css = "[property='mainContentOfPage']")
    private WebElement loadingMarker;
    @FindBy(xpath = "//ul[contains(@data-ajax-replace, 'content/dam/canada/sitemenu')]/li[@role='presentation']/a[not(@data-keep-expanded='md-min')]")
    private List<WebElement> menuItems;

    @Override
    public String getURL() {
        return "https://www.canada.ca/en/treasury-board-secretariat.html";
    }

    @Override
    public boolean isLoaded() {
        return super.isLoaded() && ElementActions.isElementVisible(loadingMarker, "loading marker");
    }

    public String getMenuButtonText() {
        return ElementActions.getText(menuButtonText, MENU_BUTTON_NAME);
    }

    public void clickMenuButton() {
        ElementActions.waitUntilVisible(menuButton, MENU_BUTTON_NAME);
        ElementActions.clickElement(menuButton, MENU_BUTTON_NAME);
    }

    public List<String> getMenuItems() {
        return menuItems.stream()
                .map(item -> ElementActions.getText(item, "Menu item"))
                .collect(Collectors.toList());
    }
}
