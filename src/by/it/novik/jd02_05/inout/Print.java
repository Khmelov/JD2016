package by.it.novik.jd02_05.inout;

import by.it.novik.jd02_05.resources.Resources;


/**
 * Created by Kate Novik.
 */
public class Print {
    public static void printData (Resources resources) {
        //Печатаем строку по ключу
        System.out.println(resources.getString("helloMessage"));
        //Печатаем дату в соответствии с текущей локалью
        System.out.println(resources.getDateFormat());
    }
}
