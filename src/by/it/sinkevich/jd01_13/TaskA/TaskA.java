package by.it.sinkevich.jd01_13.TaskA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Класс для задания jd01_13 TaskA
 *
 * @author Sinkevich Denis
 */
class TaskA {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        double sum = 0;
        do {
            try {
                line = reader.readLine();
                if (line.equals("END")) break;
                double number = Double.parseDouble(line);
                double root = Math.sqrt(number);
                if (Double.isNaN(root)) {
                    throw new ArithmeticException("Нельзя вычислить квадратный корень из отрицательного числа!");
                }
                sum += Math.sqrt(number);
                System.out.println("Введённое число равно " + number + " . Сумма корней всех ранее введённых чисел равна " + sum);

            } catch (NumberFormatException e) {
                System.out.println("Неправильный парсинг ввода! Пожалуйста, введите число.");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
