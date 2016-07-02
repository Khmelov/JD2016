package by.it.belsky.jd01_15.TaskA;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.SocketPermission;

/**
 * Created by misha on 08.06.2016.
 */
public class VariantA1 {

    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/by/it/belsky/";
        String filename = src + "jd01_15/TaskA/matrix.txt";
        int [][] m = new int [4][4];
        for (int i = 0; i<4; i++) {
            for (int j = 0; j<4; j++) {
                m[i][j]= (int)(Math.random()*32-16);
               // System.out.printf("%3d", m[i][j]);
            }
            System.out.println();
        }
        printMatrix(m, System.out);

        try {
            PrintStream out = new PrintStream(filename);
            printMatrix(m, out);
        }catch (FileNotFoundException e) {
            System.err.println("Ошибка вывода"+filename);
        }
    }
    static void printMatrix (int[][] matrix, PrintStream ourOut) {
        for (int [] row:matrix) {
            for (int value:row) {
                ourOut.printf("%3d",value);
            }
            ourOut.println();
        }
        ourOut.println();
    }
}
