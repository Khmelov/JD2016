package by.it.sergeev.jd01_05;

import by.it.akhmelev.jd01_05.math.Task6;
import by.it.sergeev.jd01_05.TaskA.*;


public class Main {
    public static void main(String[] args) {
        // A1
        System.out.println("Контрольное задание №6");
        double x = 1.095961246;
        System.out.println("Результат уравнения разбитого на части:");
        System.out.println(A1.equationInPart(x));
        System.out.println("Результат полного уравнения:");
        System.out.println(A1.equationFull(x));
        System.out.println(".о0(Интересный факт) Число PI:");
        System.out.println(Math.PI);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n Контрольное задание №2");

        // A2
        System.out.println(A2.calculate(1, 0));
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n Контрольное задание №3");

        //A3
        A3.printTable();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n Контрольное задание №4");


        //A4
        System.out.println(A4.calculate(2.408));
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n Контрольное задание №5");

        //A5
        A5.calculate();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n Контрольное задание №6");

        //A6
        double a[] = Task6.getArray();
        Task6 task6 = new Task6();
        task6.printArray(a, "Массив", true);
        double b[] = task6.getEveryThirdElement(a);
        task6.printArray(b, "array", true);
    }
}
