package by.it.novik.jd01_13.taskB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class Calculator {

    /**
     * Тестовая прцедура 1
     * @param exp Строка ввода
     * @throws NumberFormatException
     */
    public static void calcOne(String exp) throws NumberFormatException {
        try {
            System.out.println("Start - procedure 1");
            List<Double> list = new ArrayList<>();
            // Может быть деление на ноль и NumberFormatException при парсинге
            Double div = Double.parseDouble(exp) / Math.round (Math.random() + 5);
            if (div.isNaN()) {
                throw new ArithmeticException (); // Бросаем исключение при деление на ноль
            }
            list.add(div);
            System.out.println(list);
            calcTwo(list); // Вызов процедуры2
        } catch (ArithmeticException e) {
            System.out.println("Division on null" + e);
        } finally {
            System.out.println("End - procedure 1");
        }
    }

    /**
     * Тестовая прцедура 2
     * @param list Лист типа Double
     * @throws IndexOutOfBoundsException
     */
    public static void calcTwo (List<Double> list) throws IndexOutOfBoundsException {
        try {
            System.out.println("Start - procedure 2");
            System.out.println(list.get(0).toString());
            Double div = list.get(0) / Math.round (Math.random() + 8); // Может быть деление на ноль
            if (div.isNaN()) {
                throw new ArithmeticException (); // Бросаем исключение при деление на ноль
            }
            if (list.get(0) < 5) {
                for (int i = 1; i < 20; i++) {
                    list.add((double) Math.round(Math.random() + 8));
                }
            }
            Double r = list.get(8); // Может быть IndexOutOfBoundsException при list.get(0) > 5
            list.add (r);
            calcThree(list); // Вызов процедуры3
        }
        catch (ArithmeticException e) {
            System.out.println("Division on null" + e.getLocalizedMessage());
        }
        finally {
            System.out.println("End - procedure 2");
        }
    }

    /**
     * Тестовая прцедура 3
     * @param list Лист типа Double
     * @throws NullPointerException
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void calcThree (List<Double> list) throws NullPointerException, ArrayIndexOutOfBoundsException {
        try {
            System.out.println("Start - procedure 3");
            Double div = list.get(0) / Math.round (Math.random() + 8);
            if (div.isNaN()) {
                throw new ArithmeticException (); // Бросаем исключение при деление на ноль
            }
            list.set(0,div);
            Double[] array = new Double [5];
            for (int i =0; i<list.size(); i++) {
                // Может быть ArrayIndexOutOfBoundsException при длине массива array меньше, чем list и
                // NullPointerException при длине массива array больше, чем list
                array[i] = list.get(i);
            }
            for (double var : array) {
                System.out.print( "Массив array: " + var + " ");
            }
            System.out.println("");
        }
        catch (ArithmeticException e) {
            System.out.println("Division on null" + e.getLocalizedMessage());
        }
        finally {
            System.out.println("End - procedure 3");
        }
    }
}
