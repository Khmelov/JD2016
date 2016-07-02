package by.it.novik.jd02_06.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kate Novik.
 */
public class DateTime {

    /**
     * Получить строковое представление даты и времени
     * @return строка текущей даты и времени
     */
    public static String getDateTime () {
        //Создаем формат даты и времени, используя шаблон
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss",new Locale("be","BY"));
        return dateFormat.format(new Date());
    }
}
