package ca.canada.steps;

import ca.canada.data.MainMenuDataProvider;
import ca.canada.pageobject.MainPage;
import ca.canada.utils.PageHolder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageSteps {

    public MainPageSteps openMainPage() {
        PageHolder.getPage(MainPage.class).open();
        return this;
    }

    public MainPageSteps clickMenuButton() {
        PageHolder.getPage(MainPage.class).clickMenuButton();
        return this;
    }

    public void checkMainButton() {
        String buttonText = PageHolder.getPage(MainPage.class).getMenuButtonText();
        assertThat(buttonText)
                .as("Button text is not expected")
                .isEqualToIgnoringCase("Menu");
    }

    public void checkMenuItems() {
        List<String> actualMenuItems = PageHolder.getPage(MainPage.class).getMenuItems();
        assertThat(actualMenuItems)
                .as("Unexpected menu items")
                .containsExactlyInAnyOrderElementsOf(MainMenuDataProvider.getListOfMenuItems());
    }
}
