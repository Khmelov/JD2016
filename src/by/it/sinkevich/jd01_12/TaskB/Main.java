package by.it.sinkevich.jd01_12.TaskB;

/**
 * VariantB1 class for testing tasks N1, N2.
 *
 * @author Sinkevich Denis
 */
class Main {

    public static void main(String[] args) {

        System.out.println("Задание №1: ");
        TaskB1 taskB1 = new TaskB1();
        taskB1.fillMapWithWords();
        taskB1.printMap();

        System.out.println("\nЗадание №2: ");
        TaskB2 taskB2 = new TaskB2(100000);
        System.out.print("Время выполнения задачи при помощи ArrayList в наносекундах: ");
        long arrayTime = taskB2.processArray();
        System.out.println(arrayTime);
        System.out.print("Время выполнения задачи при помощи LinkedList в наносекундах: ");
        long linkedTime = taskB2.processLinked();
        System.out.println(linkedTime);
        System.out.println("ArrayList медленнее, чем LinkedList в " + (double) arrayTime / linkedTime + " раз(а)!");
    }
}
