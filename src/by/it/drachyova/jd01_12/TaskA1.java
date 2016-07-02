package by.it.drachyova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**     Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками. Удалить
        неудовлетворительные оценки из списка. Вывести на консоль оба варианта.
 */
class TaskA1 {
    static ArrayList<Integer> createMarkList() {   //создаем список оценок
        ArrayList<Integer> marksList = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            marksList.add(new Random().nextInt(10) + 1);
        }
        return marksList;
    }

    static void printList(ArrayList<Integer> markList) {  //вывод оценок в консоль
        System.out.println(markList);
    }

    static ArrayList<Integer> deleteBadMarks(ArrayList<Integer> markList) {  //удаление неудовлетворительных оценок
        Iterator<Integer> iterator = markList.iterator();
        while (iterator.hasNext()) {
            Integer mark = iterator.next();
            if (mark < 4) {
                iterator.remove();
            }
        }
        return markList;
    }
}

