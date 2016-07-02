package by.it.novik.jd02_06.matlab.builder;

import java.io.PrintWriter;

/**
 * Created by Kate Novik.
 */
public abstract class ReportBuilder {
    //Объект потока записи в файл операций
    protected PrintWriter printWriter = ReportOperations.getInstance();

    /**
     * Метод записи заголовка в файл
     * @param header
     */
    public void buildHeader(String header){
            printWriter.println(header);

    }

    /**
     * Метод записи времени начала работы Матлаб в файл
     */
    void buildStartTime (){  }

    /**
     * Метод записи времени окончания работы Матлаб в файл
     */
    void BuildEndTime(){ }

    /**
     * Метод записи выполняемой операции в файл
     * @param operation Выполняемая операция
     */
    void buildOperation(String operation){  }

}
