package by.it.kust.jd01_12;

import by.it.kust.jd01_12.taskA.MyCollect;
import by.it.kust.jd01_12.taskA.TaskA1;
import by.it.kust.jd01_12.taskA.TaskA2;
import by.it.kust.jd01_12.taskA.TaskA3;
import by.it.kust.jd01_12.taskB.TaskB1;
import by.it.kust.jd01_12.taskB.TaskB2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Tanya Kust.
 */
public class Runner {
    public static void main(String[] args) {
        /**
         A1. Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками. Удалить
         неудовлетворительные оценки из списка. Вывести на консоль оба варианта.
         **/
        System.out.println("TaskA1");
        ArrayList<Integer> marksList = TaskA1.createMarksList(15);
        Utils.printData("Список всех оценок (15-ти учеников):", marksList);
        ArrayList<Integer> newList = TaskA1.deleteBadMarks(marksList);
        Utils.printData("Список удовлетворительных оценок (не меньше 4):", newList);

        /**
         * A2. Определить два множества (A и B) на основе целых чисел. Создать отдельный класс MyCollect и
         статические методы в нем для определения пересечения множеств getCross и объединения множеств
         getUnion. Показать работу этих методов на примере двух множеств (A и B).
         */
        System.out.println("\nTaskA2");
        Set<Integer> set1 = TaskA2.createNewSet(10,0);
        Utils.printData("Множество A:", set1);
        Set<Integer> set2= TaskA2.createNewSet(8,5);
        Utils.printData("Множество B:", set2);
        Utils.printData("Пересечение множеств А и В:", MyCollect.getCross(set1,set2));
        Utils.printData("Объединение множеств А и В:", MyCollect.getUnion(set1,set2));

        /**
         * A3. Не используя вспомогательных объектов (т.е. без обмена местами переменных), переставить
         отрицательные элементы произвольного списка чисел в конец, а положительные — в начало списка.
         */
        System.out.println("\nTaskA3");
        ArrayList<Integer> list = TaskA3.createList(15);
        Utils.printData("Список с положительными элементами в начале, а " +
                "отрицательными в конце", TaskA3.sortedAndReversed(list));
        System.out.println("--------------------------------------------------------------------");

        /**
         * B1. Задать текст на английском языке (100 и более слов). Вывести все различные слова. Для каждого слова
         подсчитать частоту его встречаемости. Слова, отличающиеся регистром букв, считать различными.
         Использовать класс HashMap.
         */
        System.out.println("\nTaskB1");
        HashMap<String,Integer> hm = TaskB1.createHashMap();
        Utils.printData("Кол-во повторений различных слов в тексте:", hm);

        /**
         * B2. В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый
         второй человек, пока не останется один. Составить два метода processArray и prоcessLinked
         моделирующие процесс. Первый должен использовать класс ArrayList, а второй — LinkedList. Какой из
         двух методов работает быстрее? Почему? Докажите. (см. пример на слайдах).
         */
        System.out.println("TaskB2");
        System.out.println(TaskB2.processArray(20));
        System.out.println(TaskB2.processLinked(20));
    }
}
