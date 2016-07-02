package by.it.sinkevich.jd02_05.resources;


import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class Singleton for managing resources
 *
 * @author Sinkevich Denis
 */
public class Resources {

    private static Resources resources = null;
    private static ResourceBundle messages = ResourceBundle.getBundle("by\\it\\sinkevich\\jd02_05\\resources\\Message", new Locale("en", "US"));

    private Resources() {
    }

    public static Resources getInstance() {
        if (resources == null) {
            resources = new Resources();
        }
        return resources;
    }

    public static Resources getInstance(Locale locale) {
        messages = ResourceBundle.getBundle("by\\it\\sinkevich\\jd02_05\\resources\\Message", locale);
        return getInstance();
    }

    public String getString(String key) {
        return messages.getString(key);
    }
}
