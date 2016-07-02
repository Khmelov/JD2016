package by.it.novik.jd02_05.inout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kate Novik.
 */
public class Input {
    /**
     * Чтение строки, введенной с клавиатуры
     * @return Строка ввода
     * @throws IOException
     */
    public static String input() throws IOException {
        System.out.println("Выберите язык en/ru/be. Для выхода нажмите Enter:");
        BufferedReader line= new BufferedReader(new InputStreamReader(System.in));
        return line.readLine();
    }


}
