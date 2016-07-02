package by.it.novik.jd02_06.log;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Kate Novik.
 */
public class Logger {
    //Поле объекта Logger Singleton
    private static Logger instance;

    private Logger() {}

    /**
     * Получение объекта Logger
     * @return объект Logger
     */
    public static Logger getInstance () {
        if (instance != null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * Запись ошибок в файл
     * @param exception Сообщение об ошибке в виде строки
     */
    public static void writeLogInFile (String exception) {
        BufferedWriter bf = null;
        try {
            bf = CreateWriter.createWriter();
            String line = DateTime.getDateTime().concat(" ").concat(exception).concat("\n");
            bf.append(line);
        } catch (IOException e) {
            System.out.println("Ошибка записи!" + e);
        }
        finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    System.out.println("Ошибка закрытия!" + e);
                }
            }
        }
    }

}
