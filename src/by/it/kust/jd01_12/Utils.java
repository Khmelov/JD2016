package by.it.kust.jd01_12;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Tanya Kust.
 */
public class Utils {
    /**
     * Выводит на консоль списки
     * @param description - описание выводимой коллекции
     * @param data - сама коллекция
     * @param <T> - тип пар-ров коллекции
     */
    public static <T> void printData(String description, Collection<T> data){
        System.out.println(description);
        for (T i: data){
            System.out.printf("%3d ", i);
        }
        System.out.println();
    }

    /**
     * Выводит на консоль HashMap
     * @param description - описание выводимых данных
     * @param data карта(слово, кол-во повторений)
     */
    public static void printData(String description, HashMap<String,Integer> data){
        System.out.println(description);
        for (HashMap.Entry<String,Integer> i: data.entrySet()){
            System.out.println(i.getKey() + "    " + i.getValue() + " раз(а)");
        }
        System.out.println();
    }


}
