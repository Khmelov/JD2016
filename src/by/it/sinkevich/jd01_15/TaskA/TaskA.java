package by.it.sinkevich.jd01_15.TaskA;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

/**
 * Class for jd01_15 TaskA
 *
 * @author Sinkevich Denis
 */
class TaskA {

    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/by/it/sinkevich/";
        String fileName = src + "jd01_15/TaskA/TaskA.txt";
        Random random = new Random(System.currentTimeMillis());
        int[][] matrix = new int[4][4];
        for (int rows = 0; rows < 4; rows++) {
            for (int cols = 0; cols < 4; cols++) {
                matrix[rows][cols] = random.nextInt(31) - 15;
            }
        }
        printMatrix(matrix, System.out);
        try (PrintStream out = new PrintStream(fileName)) {
            printMatrix(matrix, out);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printMatrix(int[][] matrix, PrintStream ourOut) {
        for (int[] row : matrix) {
            for (int value : row) {
                ourOut.printf("%3d ", value);
            }
            ourOut.println();
        }
        ourOut.println();
    }
}
