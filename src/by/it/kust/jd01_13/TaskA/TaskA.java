package by.it.kust.jd01_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Tanya Kust.
 */
public class TaskA {
    /**
     * открывает консоль;
     § считывает данные из консоли построчно;
     § переводит каждую строку в число и выводит в консоль данное число и сумму корней
     всех ранее введенных чисел, включая введенное;
     § если перевести ввод в число невозможно или невозможно извлечь корень, то
     программа обрабатывает ошибку и показывает на русском языке соответствующее
     сообщение в консоли;
     § закрывается при вводе в консоль слова END.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String line;
        Double number;
        Double sum = .0;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                System.out.println("Введите число");
                line = buff.readLine();
                if (line.equals("end")) break;
                number = Double.parseDouble(line);
                double root = Math.sqrt(number);
                if (Double.isNaN(root)){throw new ArithmeticException();}
                sum += root;
                System.out.println("Вы ввели число: "+number+" Сумма корней = "+sum);

            } catch (NumberFormatException e){
                System.out.println("Некорректный ввод. Вы ввели не число.");
            }catch (ArithmeticException e){
                System.out.println("Арифметическая ошибка. Невозможно извлечь корень из введенного числа.");
            }

        } while (true);
        buff.close();
    }
}
