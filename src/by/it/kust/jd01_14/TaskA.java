package by.it.kust.jd01_14;

import java.io.*;

/**
 * Created by Tanya Kust.
 */
public class TaskA {
    private static final String src = System.getProperty("user.dir") + "/src/by/it/kust/jd01_14/";
    private static String filename = src + "files/rndNumbers.dat";     // имя двоичного файла для записи/чтения чисел
    private static File file = new File(filename);      // создаем файл для записи/чтения

    /**
     * Запись 20 случ.чисел в двоичный файл
     * @throws IOException
     */
    static void createFileWithNumbers() throws IOException {
        DataOutputStream out = null;                                      // создаем поток
        try {
            out = new DataOutputStream(new FileOutputStream(file));       // открываем поток для записи
            for (int i=0; i<20; i++){
                out.writeInt((int) (Math.random()*20+1));                 // записываем в файл числа
            }
            System.out.println("Числа записаны в файл: " + file);
        }catch (FileNotFoundException e){
            System.err.println("Файл не найден: " + filename);
        }finally {
            try {
                if (out != null){out.close();}                      // закрываем поток
            }catch (IOException e){
                System.err.println("Ошибка закрытия: " + e);
            }
        }
    }

    /**
     * Читаем записанный файл, распечатываем числа и их среднее арифметическое
     */
    static void readFileWithNumbers() throws IOException {
        int sum=0, nbr, count=0;
        double average;
        System.out.println("Читаем числа из файла: ");
        try(DataInputStream in = new DataInputStream        // создаем поток для чтения из файла. т.к. оператор с ресурсами,
                (new BufferedInputStream(new FileInputStream(file)))) {   // не надо закрывать поток в finally
            while (in.available() > 0){    // пока есть доступные байты для чтения
                nbr = in.readInt();        // читаем
                sum += nbr;                // считаем сумму
                count++;                   // считаем кол-во чисел
                System.out.print(nbr + " ");    // печатаем числа
            }
            average = sum/count;
            System.out.println("\nСреднее арифметическое = " + average);
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден: " + file);
        }
    }
}
