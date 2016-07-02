package by.it.novik.jd02_05.resources;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Kate Novik.
 */
public class Resources {
    //Константное поле пути к ресурсам
    private static final java.lang.String PATH_RESOURCES = "by.it.novik.jd02_05.resources.Message";
    //Поле для создания объекта ресурсов
    private static Resources resources = new Resources();
    //Поле создания локали по умолчанию
    private static Locale locale = new Locale("en","US");
    //Поле объекта ResourceBundle для связывания ресурсов и локали
    private static ResourceBundle resourсeBundle = ResourceBundle.getBundle(PATH_RESOURCES,locale);

    /**
     * Получение одного экземпляра объекта Resources (сингелтон)
     * @return объект Resources
     */
    public static Resources getInstance(){
        return resources;
    }

    /**
     * Получение одного экземпляра объекта Resources (сингелтон) с новой локалью
     * @param locale Локаль
     * @return объект Resources
     */
    public static Resources getInstance(Locale locale){
        changeLocal(locale);
        return resources;
    }

    /**
     * Установика локали
     * @param locale Локаль
     */
    private static void setLocale (Locale locale){
        resources.locale = locale;
    }

    /**
     * Изменение локали
     * @param locale Локаль
     */
    public static void changeLocal (Locale locale) {
        setLocale(locale);
        resourсeBundle = ResourceBundle.getBundle(PATH_RESOURCES,locale);
    }

    /**
     * Метод получения строки по ключу из файла ресурсов
     * @param key Ключ
     * @return Строка, соответствующая ключу
     */
    public static String getString (String key){
        return resourсeBundle.getString(key);
    }

    /**
     * Получение строки даты для текущей локали
     * @return строка дата
     */
    public static String getDateFormat () {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,resources.locale);
        return df.format(new Date());
    }


}
