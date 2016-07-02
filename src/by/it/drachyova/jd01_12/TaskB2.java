package by.it.drachyova.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

/**
  В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый
 второй человек, пока не останется один. Составить два метода processArray и prоcessLinked
 моделирующие процесс. Первый должен использовать класс ArrayList, а второй — LinkedList. Какой из
 двух методов работает быстрее? Почему? Докажите.
 */
public class TaskB2 {
    static ArrayList<Integer> createArrayList(int n) { //создаем и заполняем ArrayList от 1 до n
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    static LinkedList<Integer> createLinkedList(int n) { //создаем и заполняем LinkedList от 1 до n
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }

    static long processArray(ArrayList<Integer> arrayList) { //удаляем каждый второй элемент, пока не останется 1
        long start = System.nanoTime();
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        long end = System.nanoTime();
        return end - start;                                  //возвращаем время затраченное на выполнение
    }
    static long processLinked(LinkedList<Integer> linkedList) {//удаляем каждый второй элемент, пока не останется 1
        long start = System.nanoTime();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        long end = System.nanoTime();                       //возвращаем время затраченное на выполнение
        return end - start;
    }

}
