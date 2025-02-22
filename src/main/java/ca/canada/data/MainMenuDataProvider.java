package ca.canada.data;

import java.util.List;

public class MainMenuDataProvider {
    private MainMenuDataProvider() {
        throw new RuntimeException("Creating instance is not allowed");
    }

    public static List<String> getListOfMenuItems() {
        return List.of("Jobs and the workplace",
                "Immigration and citizenship",
                "Travel and tourism",
                "Business and industry",
                "Benefits",
                "Health",
                "Taxes",
                "Environment and natural resources",
                "National security and defence",
                "Culture, history and sport",
                "Policing, justice and emergencies",
                "Transport and infrastructure",
                "Canada and the world",
                "Money and finances",
                "Science and innovation");
    }
}
