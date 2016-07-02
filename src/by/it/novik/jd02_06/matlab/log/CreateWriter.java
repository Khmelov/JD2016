package by.it.novik.jd02_06.matlab.log;

import java.io.*;

/**
 * Created by Kate Novik.
 */
public class CreateWriter {

    /**
     * Создание BufferedWriter для записи в файл
     * @return Объект BufferedWriter
     */
    public static BufferedWriter createWriter () {
        //Путь к файлу логер
        String src = System.getProperty("user.dir") + "/src/by/it/novik/";
        String path = src + "jd02_06/matlab/log/log.txt";
        //Создаем объект файл
        File file = new File (path);
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new PrintWriter(new FileWriter(file,true)));
        } catch (IOException e) {
            System.out.println("Ошибка записи!" + e);
        }
        return bf;
    }
}

