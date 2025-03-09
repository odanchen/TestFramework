package ca.canada.utils;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitUtil {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    private WaitUtil() {
        throw new FrameworkException("Creating instance is not allowed");
    }

    public static <T> FluentWait<T> waitFor(T subject, Duration duration) {
        return new FluentWait<>(subject)
                .ignoring(WebDriverException.class)
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(duration);
    }

    public static <T> FluentWait<T> waitFor(T subject) {
        return waitFor(subject, DEFAULT_TIMEOUT);
    }
}
