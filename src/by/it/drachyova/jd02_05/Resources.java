package by.it.drachyova.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Resources {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "by.it.drachyova.jd02_05.greetings";

    Resources() {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.ENGLISH);
    }

    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}
