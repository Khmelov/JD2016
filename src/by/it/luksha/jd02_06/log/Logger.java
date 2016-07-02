package by.it.luksha.jd02_06.log;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by MMauz on 02.07.2016.
 */
public class Logger {
    private static volatile Logger instance;
    private static final String root = "src/by/it/luksha/jd02_06/log/log.txt"; //путь для логов

    private Logger() {
    }

    public static Logger getInstance() {
        Logger localInstance = instance;
        if (localInstance == null) {
            synchronized (Logger.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Logger();
                }
            }
        }
        return localInstance;
    }

    public static void logError(Exception e) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(root, true);
            //строка для записи в файл время + сообщение об ошибке
            String error = String.format("::%s::    Ошибка: %s\n", new SimpleDateFormat("dd.MM.yyyy hh:mm:ss",new Locale("ru", "RU")).format(new Date()), e.getMessage());
            fileWriter.append(error);
            fileWriter.flush();
        } catch (IOException e1) {
            System.out.printf("Ошибка логирования: %s", e1);
        }
    }
}
