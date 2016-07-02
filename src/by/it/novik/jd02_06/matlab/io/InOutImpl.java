package by.it.novik.jd02_06.matlab.io;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kate Novik.
 */
public class InOutImpl implements IInOut {
    /**
     * Метод получения строки ввода из потока
     * @return Строка ввода
     * @throws IOException
     */
    @Override
    public String input() throws IOException {
        BufferedReader line= new BufferedReader(new InputStreamReader(System.in));
        String out=line.readLine();
        //line.close();
        return out;
    }

    /**
     * Метод печати строки для вывода
     * @param value Строка вывода
     */
    @Override
    public void output(String value) {
        if (value!=null) {
            System.out.println(value);
        }
        else System.out.println("Выражение неверное!");
    }
}
