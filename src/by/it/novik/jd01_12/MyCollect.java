package by.it.novik.jd01_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kate Novik.
 */
public class MyCollect {

    /**
     * Определение пересечения двух множеств
     * @param setA Множество А
     * @param setB Множество В
     * @return Результат пересечения множеств А и В
     */
    public static Set<Integer> getCross (Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> listCrossing = new HashSet<>(setA);
        listCrossing.retainAll(setB); // Метод возвращает пересечение множеств
        return listCrossing;
    }

    /**
     * Объединение двух множеств
     * @param setA Множество А
     * @param setB Множество В
     * @return Результат объединения множеств А и В
     */
    public static Set<Integer> getUnion (Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> listUnion = new HashSet<>(setA);
        listUnion.addAll(setB); // Метод возвращает объединение множеств
        return listUnion;
    }
}
