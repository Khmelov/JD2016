package by.it.sergeev.jd01_05.TaskC;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        double[] A = Utils.CreateArray();
        Utils.PrintArray(A,"A");
        double[] B = Utils.ArrayK(A);
        Utils.PrintArray(B,"B");
        Utils.PrintHorizontal(A, "A");
        Utils.PrintVertical(B,"B");
        Arrays.sort(Utils.CreateArray());
    }
}
