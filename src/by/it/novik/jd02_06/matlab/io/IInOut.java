package by.it.novik.jd02_06.matlab.io;

import java.io.IOException;

/**
 * Created by Kate Novik.
 */
public interface IInOut {

    /**
     * Метод получения строки ввода с консоли
     */
    String input() throws IOException;

    /**
     * Метод вывода значения переменной в консоль
     * @param value Строка вывода
     */
    void output(String value);
}
