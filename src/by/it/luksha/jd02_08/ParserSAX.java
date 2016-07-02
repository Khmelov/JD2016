package by.it.luksha.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by MMauz on 02.07.2016.
 */
public class ParserSAX extends DefaultHandler {
    private String space = ""; //переменная для табуляции
    private String value;

    public ParserSAX() {
    }

    public void readXML(String pathXML) {
        try {
            //создадим фабрику и стандартный парсер
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            //создадим собственный вариант SAX-класса
            ParserSAX myImplementationSax = new ParserSAX();
            //пуск парсера
            parser.parse(new File(pathXML), myImplementationSax);
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }

    @Override
    public void startDocument() throws SAXException {
        //System.out.println("Начало обработки");
    }

    @Override
    public void endDocument() throws SAXException {
        //System.out.println("Конец обработки");
    }

    @Override //тут печатаем начало тега (и его атрибуты в цикле)
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(space + "<" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" " + name + "=\"" + value + "\"");
        }
        System.out.println(">");
        space = '\t' + space; //добавим табулятор
        value = "";
    }

    @Override //печатаем конец тега
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty())
            System.out.println(space + value);
        value = "";
        space = space.substring(1); //уберем один табулятор
        System.out.println(space + "</" + qName + ">");
    }

    @Override //а здесь собираем из кусочков value. Обрывы будут на символах ' " &
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value.concat(new String(ch, start, length).trim());
    }
}

