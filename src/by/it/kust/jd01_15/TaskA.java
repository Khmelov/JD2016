package by.it.kust.jd01_15;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by user_2 on 08.06.2016.
 */
public class TaskA {

    static void printMatrix(int[][] matrix, PrintStream ourOut){
        for (int[] row:matrix){
            for (int value:row){
                ourOut.printf("%3d ", value);
            }
            ourOut.println();
        }
        ourOut.println();
    }

    public static void main(String[] args) {
        String src=System.getProperty("user.dir")+"/src/by/it/kust/";
        String filename =  src+"jd01_15/matrix.txt";

        int[][] m=new int[4][4];
        for (int i = 0; i<4; i++){
            for (int j=0; j<4; j++){
                m[i][j]=(int)(Math.random()*31-15);
                System.out.printf("%3d ", m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        printMatrix(m,System.out);

        try {
            PrintStream out = new PrintStream(filename);
            printMatrix(m,out);
        }catch (FileNotFoundException e){
            System.err.println("ошибка вывода " + filename);
        }
    }
}
