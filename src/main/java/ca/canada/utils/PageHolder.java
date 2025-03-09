package ca.canada.utils;

import ca.canada.pageobject.BasePage;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PageHolder {
    private static final Map<Class<? extends BasePage<?>>, BasePage<?>> PAGE_MAP = new HashMap<>();

    private PageHolder() {
        throw new FrameworkException("Creating instance not permitted");
    }

    @SuppressWarnings("unchecked")
    public static <T extends BasePage<T>> T getPage(Class<T> pageClass) {
        if (!PAGE_MAP.containsKey(pageClass)) {
            try {
                PAGE_MAP.put(pageClass, pageClass.getDeclaredConstructor().newInstance());
            } catch (RuntimeException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e) {
                throw new FrameworkException("Unable to create page instance", e);
            }
        }
        return (T) PAGE_MAP.get(pageClass);
    }
}
