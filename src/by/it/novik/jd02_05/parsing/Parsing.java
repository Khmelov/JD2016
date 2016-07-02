package by.it.novik.jd02_05.parsing;

import java.util.Locale;

/**
 * Created by Kate Novik.
 */
public class Parsing {
    /**
     * Парсинг строки ввода для получения названия требуемого языка и создания локали
     * @param in Строка ввода
     * @return Локаль
     */
    public static Locale parsingLocale (String in) {
        Locale locale = null;
        if (in != null) {
           if (in.equals("en")) {
               locale = new Locale("en","EN");
           } else if (in.equals("ru")) {
               locale = new Locale("ru","RU");
           } else if (in.equals("be")) {
               locale = new Locale("be","BY");
           }
        }
        return locale;
    }
}
