package by.it.sinkevich.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Class for jd02_08. Using SaxParser
 *
 * @author Sinkevich Denis
 */
public class SaxRunner extends DefaultHandler {

    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/";
        String filePath = src + "by/it/sinkevich/jd02_08/HorseRaceForXSD.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File(filePath), new SaxRunner());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }

    private StringBuilder stringBuilder = new StringBuilder();
    private String tab = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало парсинга документа!");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.print(stringBuilder.toString());
        System.out.println("Конец парсинга документа!");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.append(tab).append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            stringBuilder.append(" ").append(attributes.getLocalName(i));
            stringBuilder.append("=\"").append(attributes.getValue(i)).append("\"");
        }
        stringBuilder.append(">\n");
        tab = tab + "\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tab = tab.substring(1);
        stringBuilder.append(tab).append("</").append(qName).append(">\n");
        //System.out.print(stringBuilder.toString());
        //stringBuilder.delete(0, stringBuilder.length());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length).trim();
        if (!text.isEmpty()) {
            stringBuilder.append(tab).append(text).append("\n");
        }
    }
}
