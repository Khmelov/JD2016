package by.it.novik.jd01_09.utils;

import by.it.novik.jd01_09.entity.Variable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Kate Novik.
 */
public class PrintValues {

    /**
     * Вывод созданных в ходе присваивания переменных
     */
    public static void printVars () {
        Map<String,Variable> mapVar = MapValues.getInstance();
        if (!mapVar.isEmpty()) {
            System.out.println("Список соданных переменных:");
            for (String key : mapVar.keySet()) {
                System.out.println(key);
            }
        }
        else System.out.println("Сохраненных переменных нет!");
    }

    /**
     * Вывод созданных в ходе присваивания переменных в отсортированном виде по ключу
     */
    public static void sortVars () {
        Map<String,Variable> mapVar = new TreeMap<>(MapValues.getInstance());
        if (!mapVar.isEmpty()) {
            System.out.println("Список соданных переменных и их значений с сортировкой по имени:");
        for (Map.Entry<String,Variable> entry : mapVar.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        }
        else System.out.println("Сохраненных переменных нет!");
    }
}
