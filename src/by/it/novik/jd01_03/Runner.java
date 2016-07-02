package by.it.novik.jd01_03;

import java.io.IOException;

/**
 * Created by Kate Novik.
 */
public class Runner  {
    public static void main(String[] args) throws IOException {
        //Ввод одномерного массива с клавиатуры
        // String line=Input.consoleStringLine();
        String line="71 12 14 789 6 565 76 712";
        double[] v=Util.StringLineToIntArray(line);

        //Сортировка одномерного массива
        System.out.println("Массив v[]");
        InOut.printArray(v,"v",5);

        //Сортировка массива
        Util.sortArray(v,true);
        System.out.println("Массив v[] отсортирован по возрастанию");
        InOut.printArray(v,"v",5);

        Util.sortArray(v,false);
        System.out.println("Массив v[] отсортирован по убыванию");
        InOut.printArray(v,"v",5);

        //Вывод максимального и минимального элемента массива v[]
        System.out.println("Максимум массива v MAX="+Util.maxArray(v));
        System.out.println("Минимум массива v MIN="+Util.minArray(v));

        //Многомерный массив
        double[][] m={
            {2, 5, 4, 1},
            {1, 3, 2, 1},
            {2, 10, 9, 7},
            {3, 8, 9, 2},

        };

        //Печать многомерного массива
        System.out.println("Печать многомерного массива");
        InOut.printArray2D(m);
        InOut.printArray2D(m,"m");

    }

}
