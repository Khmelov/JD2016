package by.it.novik.jd02_06.matlab.builder;

/**
 * Created by Kate Novik.
 */
public class Director {

    private ReportBuilder reportBuilder;

    /**
     * Установка билдера
     * @param reportBuilder Билдер для записи в файл
     */
    public void setReportBuilder (ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    /**
     * Запуск билдера
     * @param header Заголовок документа
     * @param operation Операция в Матлабе
     */
    public void build (String header, String operation) {
        reportBuilder.buildHeader(header);
        reportBuilder.buildStartTime();
        reportBuilder.buildOperation(operation);
        reportBuilder.BuildEndTime();
    }
}
