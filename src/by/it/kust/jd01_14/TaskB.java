package by.it.kust.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Tanya Kust on 12.06.2016.
 */
public class TaskB {
    /**
     * Метод читает файл, считает кол-во слов и знаков препинания в файле
     */
    static void countWordsAndPunctuation(){
        String src = System.getProperty("user.dir") + "/src/by/it/kust/jd01_14/";
        String filename = src + "files/text.txt";
        int delimiter = 0, words = 0;
        try {
            Scanner scan = new Scanner(new File(filename));
            scan.useDelimiter("[^.,!?\"()-;:]+");
            while (scan.hasNext()){
                scan.next();
                delimiter++;
            }
            scan.close();
            System.out.println("Количество знаков препинания в тексте файла = " + delimiter);

            Scanner scan2 = new Scanner(new File(filename));
            scan2.useDelimiter("[^a-zA-Z]+");
            while (scan2.hasNext()){
                scan2.next();
                words++;
            }
            scan2.close();
            System.out.println("Количество слов в тексте файла = " + words);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filename);
        }
    }
}
