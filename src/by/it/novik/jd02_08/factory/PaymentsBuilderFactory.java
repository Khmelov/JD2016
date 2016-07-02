package by.it.novik.jd02_08.factory;


import by.it.novik.jd02_08.builders.AbstractPaymentsBuilder;
import by.it.novik.jd02_08.builders.PaymentsDOMBuilder;
import by.it.novik.jd02_08.builders.PaymentsSAXBuilder;
import by.it.novik.jd02_08.builders.PaymentsSTAXBuilder;

/**
 * Created by Kate Novik.
 */
public class PaymentsBuilderFactory {
    /**
     * Класс перечисления возможных имен парсеров XML
     */
    private enum TypeOfParser {
        DOM,
        SAX,
        STAX
    }

    /**
     * Метод фабрика создания парсеров
     * @param typeOfParser Название парсера
     * @return Объект парсера
     */
    public AbstractPaymentsBuilder createPaymentsBuilder (String typeOfParser) {
        //Приводим переданное название парсера к типу enum
        TypeOfParser type = TypeOfParser.valueOf(typeOfParser.toUpperCase());
        switch (type) {
            case DOM:
                return new PaymentsDOMBuilder();
            case SAX:
                return new PaymentsSAXBuilder();
            case STAX:
                return new PaymentsSTAXBuilder();
            default: throw new EnumConstantNotPresentException(type.getDeclaringClass(),type.name());
        }
    }
}
