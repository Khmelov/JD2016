package by.it.novik.jd01_13.taskB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kate Novik.
 */
public class RunCalculator {

    public static void main(String[] args) {

    BufferedReader line= new BufferedReader(new InputStreamReader(System.in));
        String out = null;
        try {
            out = line.readLine(); // Чтение строки ввода
            Calculator.calcOne(out); //Вызываем процедуру1
        } catch (IOException e) {
            System.out.println("Ошибка чтения строки!" + e);
            //e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Недопустимое преобразование строки в числовой формат!" + e);
            //e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Недопустимое использование нулевой ссылки!" + e);
            //e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс массива находится вне границ!" + e);
            //e.printStackTrace();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс находится вне границ!" + e);
            //e.printStackTrace();
        }
        finally {
            if (out != null) {
                try {
                    line.close(); // Закрытие потока при наличии строки
                } catch (IOException e) {
                    System.out.println("Ошибка закрытия потока!");
                    e.printStackTrace();
                }
            }
        }
    }
}
