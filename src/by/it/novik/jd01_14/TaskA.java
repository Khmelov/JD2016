package by.it.novik.jd01_14;

import java.io.*;

/**
 * Created by Kate Novik.
 */
public class TaskA {

    /**
     * Метод записи в файл случайных чисел
     * @return Объект типа File
     * @throws IOException
     */
    static File writeInFile () throws IOException {
        //Создаем файл для хранения двоичных данных
        String src = System.getProperty("user.dir") + "/src/by/it/novik/";
        String filename = src + "jd01_14/randomdate.dat";
        File file = new File (filename);
        //Откроем поток для записи случайных чисел
        DataOutputStream out = null;
        try
        {
            out = new DataOutputStream (new FileOutputStream(file));
            for (int i = 0;i < 20;i++)
            {
                out.writeInt((int) Math.round(Math.random() * 20) + 10);
                i++;
            }
        }
             catch (FileNotFoundException e) {
            System.err.println("Файла нет: " + filename);
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
            }
            catch (IOException ex) {
                System.err.println("Ошибка закрытия" + ex);
            }
        }
    return file;
    }

    /**
     * Метод чтения из файла с вычислением среднего арифметического
     * @param file Объект типа File для чтения
     * @throws IOException
     */
    static void readOutFile (File file) throws IOException {
        DataInputStream in = null;
        int count = 0;
        int sum = 0;
        int num;
        try {
            //Создаем поток для вывода из файла
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            while (in.available() > 0) {
                num = in.readInt();
                count++;
                sum += num;
                System.out.print(num + " ");
            }
            System.out.println("\nAverage = " + sum/count); //Вывод среднего арифметического чисел

        }
        catch (FileNotFoundException e) {
            System.err.println("Файла нет: " + file.getName());
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException ex) {
                System.err.println("Ошибка закрытия" + ex);
            }
        }
    }
}
