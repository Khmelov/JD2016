package by.it.sinkevich.jd01_12.TaskA;

import java.util.Set;

/**
 * VariantB1 class for testing tasks N1, N2, N3.
 *
 * @author Sinkevich Denis
 */
class Main {

    public static void main(String[] args) {

        System.out.println("Задание №1: ");
        TaskA1 taskA1 = new TaskA1();
        taskA1.initListWithRandomMarks(0, 10);
        System.out.print("Первоначальный список: ");
        taskA1.printList();
        taskA1.deleteUnsatisfactoryMarks();
        System.out.print("Список после удаления неудовлетворительных оценок: ");
        taskA1.printList();

        System.out.println("\nЗадание №2: ");
        TaskA2 taskA2 = new TaskA2();
        Set<Integer> setA = taskA2.getSetA();
        Set<Integer> setB = taskA2.getSetB();
        System.out.println("Множество А: " + setA);
        System.out.println("Множество В: " + setB);
        System.out.println("Пересечение множеств: " + MyCollect.getCross(setA, setB));
        System.out.println("Объединение множеств: " + MyCollect.getUnion(setA, setB));

        System.out.println("\nЗадание №3: ");
        TaskA3 taskA3 = new TaskA3();
        System.out.println("Первоначальный список: " + taskA3.getNumbers());
        taskA3.descendingSort();
        System.out.println("Список после сортировки: " + taskA3.getNumbers());
    }
}
