package by.it.sinkevich.jd01_12.TaskB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * TaskB2 class
 *
 * @author Sinkevich Denis
 */
class TaskB2 {

    private int number;

    TaskB2(int number) {
        this.number = number;
    }

    TaskB2() {
        this(10000);
    }

    long processArray() {
        List<Integer> list = new ArrayList<>(number);
        for (int i = 1; i <= number; i++) {
            list.add(i);
        }
        return removeElements(list);
    }

    long processLinked() {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= number; i++) {
            list.add(i);
        }
        return removeElements(list);
    }

    private long removeElements(List<Integer> list) {
        //Засекаем время начала метода
        long start = System.nanoTime();
        //position используется для правильного перехода итератора после прохода цикла
        int position = 1;
        //Цикл выполняем до тех пор, пока не останется один элемент в списке
        ListIterator<Integer> iterator;
        while (list.size() != 1) {
            iterator = list.listIterator(position);
            while (iterator.hasNext()) {
                //пропускаем один элемент
                iterator.next();
                //Проверяем есть ли следующий элемент, если он есть, то переходим, удаляем и ставим position для следующего
                //прохода цикла на второй элемент списка, если нету, то на первый
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    position = 1;
                } else {
                    position = 0;
                }
            }
        }
        //Засекаем время кокончания метода
        long end = System.nanoTime();
        return end - start;
    }
}
