
package by.it.drachyova.jd01_14;

//Записать в двоичный файл 20 случайных чисел.
// Прочитать записанный файл, распечатать числа и их среднее арифметическое.

import java.io.*;
import java.util.Random;

public class TaskA {
    static void writeReadPrintAndFindAverage() throws IOException {
        Random random = new Random();
        int[] randomNumbers = new int[20];                              //создаем массив из 20-ти элементов
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(20);                      //заполняем массив случайными числами от 0 до 20
        }
        String src = System.getProperty("user.dir") + "/src/by/it/drachyova/";              //куда будем записывать
        String filename = src + "jd01_14/randomNumbers.dat";                                //имя файла
        File file = new File(filename);                                                     //создаем файл
        FileOutputStream fos = null;
        FileInputStream is;
        try {
            fos = new FileOutputStream(file);                             //открываем поток записи в файл
            for (int element : randomNumbers) {                           //каждый элемент массива
                fos.write(element);                                       //записываем в файл
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи " + e);
        } finally {
            try {
                if (fos != null) {
                    fos.close();                                         //закрываем поток записи
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия потока " + e);
            }
        }
        try{
           is=new FileInputStream(file);                                //открываем поток чтения
            int number;
            double sum=0;
            double count=0;
            while ((number=is.read())!=-1) {                             //чтение файла
                sum+=number;                                             //считаем сумму чисел
                count++;                                                 //считаем количество чисел
                System.out.print(number+" ");                            //вывод чисел в консоль
            }
            System.out.println();
            System.out.println("Среднее арифметическое " + sum / count);  //вывод среднего арифметического
        }
        catch (IOException e){
            System.err.println("Ошибка файла "+e);
        }
    }
}