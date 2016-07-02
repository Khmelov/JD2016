package by.it.drachyova.jd01_14;

//В файле с текстом подсчитать в тексте количество знаков препинания и слов.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TaskB {

    static void countWordsAndPunctuation() throws FileNotFoundException {
        int counterPunctuation = 0;                                                //счетчик для знаков препинания
        int counterWords = 0;                                                      //счетчик для слов
        String src = System.getProperty("user.dir") + "/src/by/it/drachyova/";     //путь к файлу
        String filename = src + "jd01_14/TaskBText.txt";                           //имя файла
        File file = new File(filename);
        Scanner scanPunctuation = new Scanner(file);                           //открывае поток чтения
        scanPunctuation.useDelimiter("[^.!?,-:;'\"]*");                        //читаем знаки препинания
        while (scanPunctuation.hasNext()) {                                    //пока это не последний знак препинания
            scanPunctuation.next();                                            //переходим к следующему
            ++counterPunctuation;                                              //увеличиваем счетчик
        }
        scanPunctuation.close();                                               //закрываем поток чтения
        System.out.println("Количество знаков препинания " + counterPunctuation); //вывод результата
        Scanner scanWords = new Scanner(file);                                  //открываем поток чтения
        scanWords.useDelimiter("[^a-zA-z]*");                                   //читаем слова
        while (scanWords.hasNext()) {                                           //пока это не последнее слово
            scanWords.next();                                                   //переходим к следующему
            ++counterWords;                                                     //увеличиваем счетчик
        }
        scanWords.close();                                                     //закрываем поток чтения
        System.out.println("Количество слов " + counterWords);                  //вывод результата

    }
}


