package ca.canada.utils;

import ca.canada.listeners.ScreenshotListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotTaker {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScreenshotListener.class);
    private static final String SCREENSHOT_FOLDER = String.join(File.separator, "build", "logs", "screenshots");

    private ScreenshotTaker() {
        throw new FrameworkException("Creating instance is not allowed");
    }

    private static void createDirs(Path path) {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            LOGGER.error("Failed to create directory to store page DOMs!", e);
        }
    }

    public static Path takeScreenshot(String testName, WebDriver driver) {
        byte[] screenshotFileBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        String screenshotFileName = "SCR_" + testName + "_" + System.currentTimeMillis();
        Path targetDirPath = Paths.get(SCREENSHOT_FOLDER);
        createDirs(targetDirPath);
        Path screenshotFilePath = Paths.get(SCREENSHOT_FOLDER, screenshotFileName + ".png");
        try {
            Files.write(screenshotFilePath, screenshotFileBytes);
            LOGGER.info("Screenshot saved");
            return screenshotFilePath.toAbsolutePath();
        } catch (IOException e) {
            LOGGER.error("Failed to create a screenshot");
            return null;
        }
    }
}
