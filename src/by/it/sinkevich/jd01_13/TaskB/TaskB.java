package by.it.sinkevich.jd01_13.TaskB;

/**
 * Класс для задания jd01_13 TaskB
 *
 * @author Sinkevich Denis
 */
class TaskB {

    void doFirstMethod() throws IllegalArgumentException {
        System.out.println("Начало первого метода!");
        doSecondMethod();
        int a = (int) Math.rint(Math.random() * 4 - 2);
        try {
            if (Double.isNaN(Math.sqrt(a))) throw new IllegalArgumentException("Корень квадратный из отрицательного числа!");
            double b = 1 / a;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль в первом методе!");
            e.printStackTrace();
        }
        System.out.println("Конец первого метода!");
    }

    private void doSecondMethod() throws IllegalArgumentException {
        System.out.println("Начало второго метода!");
        doThirdMethod();
        int a = (int) Math.rint(Math.random() * 4 - 2);
        try {
            if (Double.isNaN(Math.sqrt(a))) throw new IllegalArgumentException("Корень квадратный из отрицательного числа!");
            double b = 1 / a;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль во втором методе!");
            e.printStackTrace();
        }
        System.out.println("Конец второго метода!");
    }

    private void doThirdMethod() throws IllegalArgumentException {
        System.out.println("Начало третьего метода!");
        int a = (int) Math.rint(Math.random() * 4 - 2);
        try {
            if (Double.isNaN(Math.sqrt(a))) throw new IllegalArgumentException("Корень квадратный из отрицательного числа!");
            double b = 1 / a;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль в третьем методе!");
            e.printStackTrace();
        }
        System.out.println("Конец третьего метода!");
    }
}
