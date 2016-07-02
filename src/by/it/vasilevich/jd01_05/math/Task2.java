package by.it.vasilevich.jd01_05.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

/**
 * Created by user_2 on 08.06.2016.
 */
public class Task2 {
    public static double optionA(double a, double b) {
        double y = pow(a + 1.5, 3) + pow((a - b), 8) - b / asin(pow(abs(a), 2));
        return y;
    }

    public static double optionB() throws IOException {
        System.out.println("Введите число a");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String rLine = bufferedReader.readLine();
        double a = Double.parseDouble(rLine);
        System.out.println("Введите число b");
        String rLine2 = bufferedReader.readLine();
        bufferedReader.close();
        double b = Double.parseDouble(rLine2);
        double y = pow(a+1.5,3)+pow((a-b),8)-b/asin(pow(abs (a), 2));
        return y;
    }
}
