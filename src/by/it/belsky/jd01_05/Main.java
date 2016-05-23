
package by.it.belsky.jd01_05;

import javafx.concurrent.Task;

import static java.lang.Math.pow;
import static java.lang.StrictMath.atan;

/**
 * Created by misha on 12.05.2016.
 */
public class Main {
    public static void main(String args[]) {
//Задание 1

        double mainz = 1.8;//необходимо задать любое значение для z
        double x = 3.24;
        double m = atan(pow(x, 2));
        System.out.println("m= " + m);
        System.out.print("Число, вычисленное первым способом: ");
        System.out.println(Task1.variantA(mainz));
        System.out.print("Число, вычисленное вторым способом: ");
        System.out.println(Task1.variantB(mainz));
// задание 2
        double y = 0;
        System.out.println("Первый способ ввода данных: " + Task2.calculateA(y));
        System.out.println("Второй способ ввода данных: " + Task2.calculateB(0.21E2));
//задание 3
        Task3.printTable();
    }

}