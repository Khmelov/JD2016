package by.it.novik.jd01_13.taskA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kate Novik.
 */
public class WorkWithConsole {

    /**
     * Метод создания BufferedReader
     *
     * @return объект BufferedReader
     */
    public static BufferedReader input() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Парсинг входной строки в double с вычислением корня квадратного и суммы корней
     *
     * @param line Строка ввода
     * @throws IOException           Ошибка чтения строки
     * @throws ArithmeticException   Ошибка вычисления корня квадратного
     * @throws NumberFormatException Ошибка парсинга
     */
    public static void parsingStringInDoubleAndMathCalculate(BufferedReader line) throws IOException { //Пробрасываем возможные исключения
        String out = line.readLine();
        double d;
        Double root;
        double sum = 0;
        do {
            try {
                d = Double.parseDouble(out); //Парсинг строки в Double
                System.out.println("d = " + d);
                root = Math.sqrt(d); //Нахождение корня квадратного
                if (root.isNaN()) { //Если извлекается корень из отрицательного числа, то бросаем исключение ArithmeticException
                    throw new ArithmeticException();
                }
            } catch (NumberFormatException e) {
                root = 0.0;
                System.out.println("Ошибка преобразования строки в double : " + e);
            } catch (ArithmeticException e) {
                root = 0.0;
                System.out.println("Ошибка извлечения корня из отрицательного числа : " + e);
            }
            System.out.println("root = " + root);
            sum += root; //Сумма квадратных корней
            System.out.println("sum of roots = " + sum);
            out = line.readLine();
        }
        while (!out.equals("END")); //Считать, пока в строке не окажется END
    }
}
