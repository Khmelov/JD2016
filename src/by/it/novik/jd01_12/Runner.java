package by.it.novik.jd01_12;


import java.util.*;

import static by.it.novik.jd01_12.MyCollect.*;
import static by.it.novik.jd01_12.Utils.*;

/**
 * Created by Kate Novik.
 */
public class Runner {
    public static void main(String[] args) {
        //Создадим объект класса TaskA - задачи A
        TaskA taskA = new TaskA();

        /**
         * A1. Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками. Удалить
         * неудовлетворительные оценки из списка. Вывести на консоль оба варианта.
         */
        System.out.println("TaskA.1");
        List<Integer> listOfMarks = taskA.createListOfMarksOfPupils();
        printCollection(listOfMarks);
        printCollection(taskA.deleteUnsatisfactoryMarks(listOfMarks));

        /**
         * A2. Определить два множества (A и B) на основе целых чисел. Создать отдельный класс MyCollect и
         * статические методы в нем для определения пересечения множеств getCross и объединения множеств
         * getUnion. Показать работу этих методов на примере двух множеств (A и B).
         */
        System.out.println("TaskA.2");
        Set<Integer> setA = taskA.getSetA();
        Set<Integer> setB = taskA.getSetB();
        printCollection(setA);
        printCollection(setB);
        printCollection(getCross(setA, setB));
        printCollection(getUnion(setA, setB));

        /**
         * A3. Не используя вспомогательных объектов (т.е. без обмена местами переменных), переставить
         * отрицательные элементы произвольного списка чисел в конец, а положительные — в начало списка.
         */
        System.out.println("TaskA.3");
        List<Integer> list = taskA.createList();
        printCollection(list);
        printCollection(taskA.sortDescList(list));

        //Создадим объект класса TaskB - задачи B
        TaskB taskB = new TaskB();

        /**
         * B1. Задать текст на английском языке (100 и более слов). Вывести все различные слова. Для каждого слова
         * подсчитать частоту его встречаемости. Слова, отличающиеся регистром букв, считать различными.
         * Использовать класс HashMap.
         */
        System.out.println("TaskB.1");
        printMap(taskB.frequencyOfWords());

        /**
         * B2. В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый
         * второй человек, пока не останется один. Составить два метода processArray и prоcessLinked,
         * моделирующие процесс. Первый должен использовать класс ArrayList, а второй — LinkedList. Какой из
         * двух методов работает быстрее? Почему? Докажите.
         */
        System.out.println("TaskB.2");
        System.out.println("Затраченное время на удаление с помощью ArrayList " + taskB.processArray(taskB.createArray(100000)) + " ms");
        System.out.println("Затраченное время на удаление с помощью LinkedList " + taskB.processLinked(taskB.createArray(100000)) + " ms");

        //Создадим объект класса TaskC - задачи C
        TaskC taskC = new TaskC();

        /**
         * C1. Во входном тексте хранятся наименования некоторых объектов. Построить список C1, элементы которого
         * содержат наименования и шифры данных объектов, причем элементы списка должны быть упорядочены по
         * возрастанию шифров. Затем «сжать» список C1, удаляя дублирующие наименования объектов.
         */
        System.out.println("TaskC.1");
        Map<Integer,Set<String>> c1 = taskC.getObjectsWithHashCode();
        printMap(c1);
        // Используем сжатие при случайном выборе шифра
        printMap(taskC.compressionMap(c1));

        /**
         * C2. Определить два множества (A и B) на основе целых чисел. Создать отдельный класс MyCollect и
         * статические методы в нем для определения пересечения множеств getCross
         * getUnion. Показать работу этих методов на примере двух множеств (A и B).
         */
        System.out.println("TaskC.2");
        Set<Object> set1 = new HashSet<>();
        set1.add(6);
        set1.add("true");
        set1.add(45);
        set1.add("false");
        set1.add('t');
        printCollection(set1);
        Set<Object> set2 = new HashSet<>();
        set2.add("yes");
        set2.add("true");
        set2.add(45);
        set2.add("false");
        set2.add('t');
        set2.add('n');
        set2.add(-23.6);
        printCollection(set2);
        printCollection(taskC.getCross(set1,set2));
        printCollection(taskC.getUnion(set1,set2));

        /**
         * C3. Задана строка, состоящая из выражений и символов «(», «)», «[», «]» «{», «}».
         * Проверить корректность расстановки скобок с помощью коллекций.
         */
        System.out.println("TaskC.3");
        System.out.println(taskC.checkExp("a+(2-5)+8+{{1,2},{2,3}}"));

    }

}
