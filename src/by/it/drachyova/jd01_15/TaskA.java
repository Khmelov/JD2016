package by.it.drachyova.jd01_15;

//Создайте матрицу 4 на 4 из целых случайных чисел от -15 до 15.
// Выведите матрицу на консоль и в текстовый файл matrix.txt, расположенный в папке задания JD01_15.
// При выводе для каждого числа рекомендуется предусмотреть для него три знакоместа, а между числами – один пробел.
// Итого: матрица займет 4 строки по 16 символов.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TaskA {

    private static void printMatrix(int[][] matrix, PrintStream ourOut) {
        for (int[] row : matrix) {
            for (int value : row) {
                ourOut.printf("%3d ", value);
            }
            ourOut.println();
        }
        ourOut.println();
    }

    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/by/it/drachyova/";
        String filename = src + "jd01_15/matrix.txt";
        File file = new File(filename);
        int[][] matrix = new int[4][4];                               //создаем матрицу 4 на 4
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 32 - 16);      //заполняем случайными числами от -15 до 15.
            }
        }
        printMatrix(matrix, System.out);                             //вывод в консоль
        try (PrintStream out = new PrintStream(file)) {              //запись в текстовый файл
            printMatrix(matrix, out);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка вывода" + e);
        }
    }
}
