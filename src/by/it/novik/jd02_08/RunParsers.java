package by.it.novik.jd02_08;

import by.it.novik.jd02_08.builders.AbstractPaymentsBuilder;
import by.it.novik.jd02_08.factory.PaymentsBuilderFactory;

/**
 * Created by Kate Novik.
 */
public class RunParsers {
    public static void main(String[] args) {
        String filename = "src/by/it/novik/jd02_07/payments/payments-xsd.xml";
        System.out.println("DOM-парсер");
        startingPaymentsBuilder("DOM",filename);
        System.out.println("\n\nSAX-парсер");
        startingPaymentsBuilder("SAX",filename);
        System.out.println("\nSTAX-парсер");
        startingPaymentsBuilder("STAX",filename);
    }

    /**
     * Запуск парсера XML-документа
     * @param typeOfParser название парсера
     * @param filename путь к XML-документу
     */
    public static void startingPaymentsBuilder (String typeOfParser, String filename) {
        //Создаем фабрику билдеров-парсеров
        PaymentsBuilderFactory paymentsBuilderFactory = new PaymentsBuilderFactory();
        //Создаем необходимый парсер по названию парсера
        AbstractPaymentsBuilder builder = paymentsBuilderFactory.createPaymentsBuilder(typeOfParser);
        //Запуск парсера XML-документа
        builder.buildPayments(filename);
    }
}
