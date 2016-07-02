package by.it.novik.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Kate Novik.
 */
public class TaskB {
//    static final String text =  "Is it possible to live without traveling? Probably yes, but very difficult.\n" +
//                                "Millions of people travel around the world just for fun.\n" +
//                                "Travels broaden the mind, make a person be more friendly and open.\n" +
//                                "Journeys could be made in different ways.\n" +
//                                "You might travel by plane, by bus, by rail or by your own car.\n" +
//                                "As for me, I'm just crazy about travelling by sea.\n" +
//                                "I believe that this voyage gives you a lot of unforgettable emotions and impressions.\n" +
//                                "If you make for the open sea by ferry, in this case you have a wonderful opportunity\n" +
//                                "to see the depth of the sea, the purity of water and living marine animals in all their beauty.\n" +
//                                "Besides, a good opportunity arises - swimming in pure water.\n" +
//                                "Nevertheless, I do not like jellyfish too much and at any case try to avoid their presence.";

    /**
     * Процедура подсчета количества слов в тексте
     */
    static void countWordsInText () {
        try {
            //Получаем объект Scanner с файлом текста
            Scanner scan1 = getScannerForTextFile();
            //Задаем разделитель (регулярное выражение) для отбора слов
            scan1.useDelimiter("[^a-zA-Z]+");
            int i = 0; //Количество слов в тексте
            while (scan1.hasNext()) {
                scan1.next();
                i++;
            }
            scan1.close();
            System.out.println("Количество слов в тексте: " + i);
        }
        catch (FileNotFoundException e) {
            System.err.println("Файл не найден" + e);
        }
    }

    /**
     * Процедура подсчета количества знаков препинания
     */
    static void countPunctuationMarksInText () {
        try {
            //Получаем объект Scanner с файлом текста
            Scanner scan2 = getScannerForTextFile();
            //Задаем разделитель (регулярное выражение) для отбора знаков препинания
            scan2.useDelimiter("[^,\\.?!]+");
            int j = 0; //Количество знаков препинания в тексте
            while (scan2.hasNext()) {
                scan2.next();
                j++;
            }
            scan2.close();
            System.out.println("Количество знаков препинания в тексте: " + j);
        }
        catch (FileNotFoundException e) {
            System.err.println("Файл не найден" + e);
        }
    }

    /**
     * Получение объекта Scanner с файлом текста
     * @return Объект Scanner
     * @throws FileNotFoundException
     */
    private static Scanner getScannerForTextFile () throws FileNotFoundException {
        //Задаем путь к файлу с текстом
        String src = System.getProperty("user.dir") + "/src/by/it/novik/";
        File text = new File(src + "jd01_14/text.txt");
        //Создаем объект сканер и передаем ему текст
        return new Scanner(text);
    }
}
