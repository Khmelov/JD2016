package by.it.kust.jd01_12.taskA;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Tanya Kust.
 */
public class TaskA1 {
    /**
     * Создает список заданной размерности и заполняет его целыми случ.числами от 0 до 10
     * @param length - заданная размерность списка
     * @return заполненный список
     */
    public static ArrayList<Integer> createMarksList(int length) {
        ArrayList<Integer> marks = new ArrayList<>();
        for (int i=0; i<length; i++){
            marks.add((int)(Math.random()*11));
        }
        return marks;
    }

    /**
     * Удаляет из списка оценки, меньше 4
     * @param list - исходный список со всеми оценками
     * @return список без оценок < 4
     */
    public static ArrayList<Integer> deleteBadMarks(ArrayList<Integer> list){
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer mark = it.next();
            if (mark < 4) {it.remove();}
        }
        list.trimToSize();
        return list;
    }
}
