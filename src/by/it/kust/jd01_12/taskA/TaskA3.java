package by.it.kust.jd01_12.taskA;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tanya Kust.
 */
public class TaskA3 {
    /**
     * Создает список и заполняет случ.целыми числами от -10 до 10
     * @param length - заданныая размерность списка
     * @return заполненный список
     */
    public static ArrayList<Integer> createList(int length) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<length; i++){
            list.add((int)(Math.random()*21-10));
        }
        return list;
    }

    /**
     * Сортирует список по возрастанию, а потом "переворачивает" его
     * @param list - список
     * @return отсортированный и перевернутый список
     */
    public static ArrayList<Integer> sortedAndReversed(ArrayList list){
        ArrayList<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        return sortedList;
    }


}
