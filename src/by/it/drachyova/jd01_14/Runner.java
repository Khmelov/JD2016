
package by.it.drachyova.jd01_14;


import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        System.out.println("Task A");
        TaskA.writeReadPrintAndFindAverage();
        System.out.println();
        System.out.println("TaskB");
        TaskB.countWordsAndPunctuation();
        System.out.println();
        System.out.println("TaskC");
        TaskC.printFilesAndDirectories();
    }
}


