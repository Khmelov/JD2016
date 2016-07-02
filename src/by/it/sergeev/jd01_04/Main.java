package by.it.sergeev.jd01_04;

import java.io.IOException;

public class Main {
    public static void main (String [] args ) throws IOException {
        String line = "71 12 14 789 6 565 76 712";
        double v[] = InOut.stringLineToIntArray(line);
        System.out.println("Массив v");
        InOut.arrayPrint(v, "v", 5);

        v=Util.sortIntArray(v, true);
        System.out.println("Массив v отсортирован по возрастанию");
        InOut.arrayPrint(v, "v", 5);

        v=Util.sortIntArray(v, false);
        System.out.println("Массив v отсортирован по убыванию");
        InOut.arrayPrint(v, "v", 5);

        System.out.println("Максимум массива Max = " + Util.maxIntArray(v));
        System.out.println("Максимум массива Min = " + Util.minIntArray(v));

        double[] y = {20, 11, 40, 37};
        double[][] m = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };
        double [] x = Util.findRoot(m,y,false);
        InOut.arrayPrint(x, "X", 1);
        InOut.arrayPrint(Util.arrayMulArray(m,x),"yy",4);

        System.out.println("Детерминант = " + Util.findDeterminant(m));

    }
}
