package by.it.novik.jd01_12;


import java.util.Collection;
import java.util.Map;

/**
 * Created by Kate Novik.
 */
public class Utils {

    /**
     * Печать коллекции
     * @param list переданная коллекция
     * @param <T> тип параметров коллекции
     */
    public static <T> void printCollection (Collection<T> list) {
        int i = 0;
        for (T elem: list) {
            System.out.print(i + ":" + elem + " ");
            i++;
        }
        System.out.println("");
    }

    /**
     * Печать MapValues
     * @param map MapValues типа <String,Integer>
     */
    public static <K,V> void printMap (Map<K,V> map) {
        int k = 1;
        for (Map.Entry<K,V> setEntry: map.entrySet()) {
            System.out.print(setEntry.getKey() + ":" + setEntry.getValue() + " ");
            if (k%10==0) {
                System.out.println("");
            }
            k++;
        }
        System.out.println("");
    }

    /**
     * Вычисление стартового времени операции
     * @return стартовое время операции
     */
    public static long startTimeProcess () {
        long start = System.currentTimeMillis(); // Вычисляем стартовое время операции
        return start;
    }

    /**
     * Вычисление времени, потраченного на операцию
     * @param start стартовое время операции
     * @return время, потраченное на операцию
     */
    public static String deltaTimeProcess (long start) {
        long end = System.currentTimeMillis(); // Вычисляем конечное время операции
        Double delta = (double) (end - start); // Вычисляем время, потраченное на операцию
        return delta.toString();
    }
}
