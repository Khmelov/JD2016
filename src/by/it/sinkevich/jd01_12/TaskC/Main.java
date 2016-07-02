package by.it.sinkevich.jd01_12.TaskC;

import java.util.Set;

/**
 * VariantB1 class for testing tasks №1, №2, №3
 *
 * @author Sinkevich Denis
 */
class Main {

    public static void main(String[] args) {

        System.out.println("Задание №1: ");
        TaskC1 taskC1 = new TaskC1();
        System.out.println("Отсортированный список с наименованиями объектов: ");
        taskC1.fillMapWithObjectNames();
        taskC1.printMap();
        System.out.println("\nОтсортированный список без повторяющихся наименований объектов: ");
        taskC1.compressList();
        taskC1.printMap();

        System.out.println("\nЗадание №2: ");
        TaskC2 taskC2 = new TaskC2();
        Set<Integer> setA = taskC2.getSetA();
        Set<Integer> setB = taskC2.getSetB();
        GenericMyCollect<Integer> typeInt = new GenericMyCollect<>();
        Set<String> setStrA = taskC2.getSetStrA();
        Set<String> setStrB = taskC2.getSetStrB();
        GenericMyCollect<String> typeStr = new GenericMyCollect<>();
        System.out.println("Пример работы класса для Integer: ");
        System.out.println("Множество А: " + setA);
        System.out.println("Множество В: " + setB);
        System.out.println("Пересечение множеств: " + typeInt.getCross(setA, setB));
        System.out.println("Объединение множеств: " + typeInt.getUnion(setA, setB));
        System.out.println("Пример работы класса для String: ");
        System.out.println("Множество А: " + setStrA);
        System.out.println("Множество В: " + setStrB);
        System.out.println("Пересечение множеств: " + typeStr.getCross(setStrA, setStrB));
        System.out.println("Объединение множеств: " + typeStr.getUnion(setStrA, setStrB));

        System.out.println("\nЗадание №3: ");
        TaskC3 taskC3 = new TaskC3("({[()(({{[()]}}))]})");
        System.out.println(taskC3.checkLine());
    }
}
