package by.it.novik.jd02_08.builders;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Kate Novik.
 */
public class PaymentsSTAXBuilder extends AbstractPaymentsBuilder {

    //Поле табуляции
    private String tab = "";
    //Поле текста между элементами документа
    private String text = "";

    /**
     * Парсинг XML документа STAX-парсером
     *
     * @param filename Путь к XML документу
     */
    public void buildPayments(String filename) {
        //Создаем фабрику и объект итератора
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader;
        try {
            xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(filename));
            //Читаем документ пока есть элементы
            while (xmlStreamReader.hasNext()) {
                //Получаем id элемента
                int value = xmlStreamReader.next();
                //Печатаем элемент в соответствии с id
                switch (value) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.print(tab + "<" + xmlStreamReader.getLocalName());
                        int attrCount = xmlStreamReader.getAttributeCount();
                        for (int i = 0; i < attrCount; i++) {
                            System.out.print(" ");
                            System.out.print(xmlStreamReader.getAttributeLocalName(i) + "=\"" + xmlStreamReader.getAttributeValue(i) + "\"");
                        }
                        System.out.println(">");
                        tab = tab.concat("\t");
                        text = "";
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (!text.isEmpty())
                            System.out.println(tab + text);
                        text = "";
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + xmlStreamReader.getLocalName() + ">");
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        text = text.concat(xmlStreamReader.getText().trim());
                        break;
                    }
                }
            }
        } catch (XMLStreamException e) {
            System.out.println("Ошибка потока чтения XML" + e);
        } catch (FileNotFoundException e) {
            System.out.println("Файл XML не найден" + e);
        }
    }
}
