package ca.canada.treasury;

import ca.canada.steps.MainPageSteps;
import org.testng.annotations.Test;

public class MainMenuTest extends AbstractTest {
    private final MainPageSteps mainPageSteps = new MainPageSteps();

    @Test(description = "Test main menu button text")
    public void testCheckMainMenuButton() {
        mainPageSteps.openMainPage().checkMainButton();
    }

    @Test(description = "Test main menu items")
    public void testMenuItems() {
        mainPageSteps.openMainPage().clickMenuButton().checkMenuItems();
    }
}
