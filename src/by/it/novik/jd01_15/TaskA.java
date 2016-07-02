package by.it.novik.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by Kate Novik.
 */
public class TaskA {

    /**
     * Печать матрицы
     * @param array Матрица для печати
     * @param out Поток вывода
     */
    private static void printMatrix (int[][] array, PrintStream out) {
        for (int[] row : array) {
            for (int value : row) {
                out.printf ("%3d ", value);
            }
            out.println();
        }
        out.println();
    }

    public static void main(String[] args) {
        //Создаем файл для хранения матрицы
        String src = System.getProperty("user.dir") + "/src/by/it/novik/";
        String filename = src + "jd01_15/matrix.txt";
        File file = new File (filename);
        //Создаем матрицу 4x4
        int[][] array = new int [4][4];
        for (int i = 0; i<4; i++) {
            for (int j=0; j<4; j++){
                array[i][j] = (int)(Math.random()*31-15);
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
        //Вывод в консоль
        printMatrix(array, System.out);
        //Вывод в файл
        try {
            PrintStream out = new PrintStream(file);
            printMatrix(array,out);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка вывода" + e);
        }
        //Вывод в поток err
        // printMatrix(array, System.err);
    }
}
