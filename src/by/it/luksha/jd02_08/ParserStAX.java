package by.it.luksha.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

/**
 * Created by MMauz on 02.07.2016.
 */
public class ParserStAX {
    private String space = ""; //переменная для табуляции

    public ParserStAX() {

    }

    public void readXML(String pathXML) {
        try {
            //создадим фабрику и стандартный парсер
            FileInputStream fileInputStream = new FileInputStream(pathXML);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = inputFactory.createXMLStreamReader(fileInputStream);
            //пуск парсера
            String el = "";
            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.print(space + "<" + xmlStreamReader.getLocalName());
                        space = space + "\t";
                        int countAttr = xmlStreamReader.getAttributeCount();
                        for (int i = 0; i < countAttr; i++) {
                            System.out.print(" " + xmlStreamReader.getAttributeLocalName(i) + "=");
                            System.out.print("\"" + xmlStreamReader.getAttributeValue(i) + "\"");
                        }
                        System.out.println(">");

                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        el = el.concat(xmlStreamReader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (!el.isEmpty())
                            System.out.println(space + el);
                        space = space.substring(1);
                        el = "";
                        System.out.println(space + "</" + xmlStreamReader.getLocalName() + ">");
                        break;
                    }
                }
            }


        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }
}
