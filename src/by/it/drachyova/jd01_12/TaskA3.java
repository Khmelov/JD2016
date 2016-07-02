package by.it.drachyova.jd01_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
     Не используя вспомогательных объектов (т.е. без обмена местами переменных), переставить
     отрицательные элементы произвольного списка чисел в конец, а положительные — в начало списка.
 */
public class TaskA3 {
    static ArrayList<Integer> listCreator() {
        ArrayList<Integer> list = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            list.add(new Random().nextInt(20) - 10);
        }
        return list;
    }
    static ArrayList<Integer> listSort(ArrayList<Integer> list){
        Collections.sort(list, Collections.<Integer>reverseOrder());
        return list;
        }
}


