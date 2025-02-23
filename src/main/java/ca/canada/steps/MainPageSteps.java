package ca.canada.steps;

import ca.canada.data.MainMenuDataProvider;
import ca.canada.pageobject.MainPage;
import ca.canada.utils.PageHolder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageSteps {
    private final MainPage mainPage = PageHolder.getPage(MainPage.class);

    public MainPageSteps openMainPage() {
        mainPage.open();
        return this;
    }

    public MainPageSteps clickMenuButton() {
        mainPage.clickMenuButton();
        return this;
    }

    public void checkMainButton() {
        String buttonText = mainPage.getMenuButtonText();
        assertThat(buttonText)
                .as("Button text is not expected")
                .isEqualToIgnoringCase("Menu");
    }

    public void checkMenuItems() {
        List<String> actualMenuItems = mainPage.getMenuItems();
        assertThat(actualMenuItems)
                .as("Unexpected menu items")
                .containsExactlyInAnyOrderElementsOf(MainMenuDataProvider.getListOfMenuItems());
    }
}
