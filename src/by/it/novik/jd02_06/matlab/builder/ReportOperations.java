package by.it.novik.jd02_06.matlab.builder;

import java.io.*;


/**
 * Created by Kate Novik.
 */
public class ReportOperations {
    //Поле объекта PrintWriter для записи в файл builder операций
    private static PrintWriter instance = null;

    private ReportOperations() {}

    /**
     * Получение объекта PrintWriter
     * @return
     */
    public static PrintWriter getInstance (){
        if (instance == null){
            String src = System.getProperty("user.dir") + "/src/by/it/novik/";
            String path = src + "jd02_06/matlab/builder/builder.txt";
            try {
                instance = new PrintWriter(new FileWriter(new File(path),true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


}
