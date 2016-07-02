package by.it.novik.jd02_08.builders;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Kate Novik.
 */
public class PaymentsHandler extends DefaultHandler {
    //Поле табуляции
    private static String tab = "\t";
    //Поле текста между элементами документа
    private static String text = "";

    /**
     * Начало документа (переопределенный метод)
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Begin of Document!");
    }

    /**
     * Конец документа (переопределенный метод)
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document!");
    }

    /**
     * Тег начальный элемента (переопределенный метод)
     * @param uri URI
     * @param localName Полное имя тега
     * @param qName Имя тега
     * @param attributes аттрибуты
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName);
        tab = tab.concat("\t");
        text = "";
        //Печать атрибутов
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" " + attributes.getLocalName(i) + "=");
            System.out.print("\"" + attributes.getValue(i) + "\"");

        }
        System.out.println(">");
    }

    /**
     * Тег конечный элемента (переопределенный метод)
     * @param uri URI
     * @param localName Полное имя тега
     * @param qName Имя тега
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //Печатаем при наличии текста между тегами
        if (!text.isEmpty()) {
            System.out.println(tab + text);
        }
        //Удаляем табуляцию
        tab = tab.substring(1);
        //Печатаем конечный элемент
        System.out.println(tab + "</" + qName + ">");
        text = "";
    }

    /**
     * Получение текста между тегами (переопределенный метод)
     * @param ch Массив символов
     * @param start Начальная позиция
     * @param length Конечная позиция
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text = text.concat(new String(ch, start, length).trim());
    }
}
