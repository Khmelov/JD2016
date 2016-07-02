package by.it.sergeev.jd01_15;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TaskA {

    public static void main (String[] arg) {
        String src=System.getProperty("user.dir")+"/src/by/it/sergeev/";
        String filename = src+"jd01_15/text.txt";
        int[][] m = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = (int) (Math.random() * 32 - 16);
            }
        }
        printMatrix(m, System.out);
        try
        {
            PrintStream out = new PrintStream(filename);
            printMatrix(m,out);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Ошибка");
        }
        System.out.println();
    }
        static void printMatrix (int[][]matrix,PrintStream ourOut){
            for (int[]row:matrix)
            {
                for(int value:row)
                {
                    ourOut.printf("%3d",value);
                }
                ourOut.println();
            }
        }
    }


