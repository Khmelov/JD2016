package by.it.novik.jd01_13.taskA;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Kate Novik.
 */
public class RunConsole {

    public static void main(String[] args) {
        BufferedReader line = null;
    try {
        line = WorkWithConsole.input();
        WorkWithConsole.parsingStringInDoubleAndMathCalculate(line);
    }
    catch (IOException e) {
        System.out.println("Ошибка чтения строки : " + e);
    }
    finally {
        if (line != null) {
            try {
                line.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }
}
