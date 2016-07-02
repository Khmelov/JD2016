package by.it.novik.jd02_08.builders;

/**
 * Created by Kate Novik.
 */
public abstract class AbstractPaymentsBuilder {
    /**
     * Абстрактный метод парсинга документа XML
     * @param filename Путь к XML документу
     */
    public abstract void buildPayments (String filename);
}
