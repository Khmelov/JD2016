package by.it.akhmelev.jd02_05.res_wthout_enum;

import java.util.Locale;
import java.util.ResourceBundle;

public class Properties {
    //путь к файлам локализации *.properties
    public static final String PATH_I18N = "by.it.akhmelev.jd02_05.i18n.Languages.string";
    //локаль по умолчанию
    private static Locale locale = Locale.ENGLISH;
    //ресурсы по умолчанию
    private static ResourceBundle resourceBundle = setLocale(locale);

    //метод получения ресурсов
    public static ResourceBundle setLocale(Locale locale) {
        Properties.locale = locale;
        resourceBundle = ResourceBundle.getBundle(PATH_I18N, locale);
        return resourceBundle;
    }

    //метод получения строк из ресурсов
    public static String getString(String key) {
        return resourceBundle.getString(key);
    }


}
