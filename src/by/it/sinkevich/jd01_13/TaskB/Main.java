package by.it.sinkevich.jd01_13.TaskB;

/**
 * Класс для проверки задания jd01_13 taskB
 *
 * @author Sinkevich Denis
 */
class Main {

    public static void main(String[] args) {
        try {
            new TaskB().doFirstMethod();
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }

    }
}
