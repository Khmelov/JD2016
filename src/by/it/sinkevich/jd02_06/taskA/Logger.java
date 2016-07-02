package by.it.sinkevich.jd02_06.taskA;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

/**
 * Class Logger for jd02_06. Singleton.
 *
 * @author Sinkevich Denis
 */
class Logger {

    private static Logger loggerInstance;
    private String path;

    private Logger() {
        String src = System.getProperty("user.dir") + "/src/by/it/";
        path = src + "sinkevich/jd02_06/taskA/log.txt";
    }

    static Logger getLoggerInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    void writeErrorMessage(String message) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(path, true))) {
            fileWriter.println(message + " " + dateFormat.format(date));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
