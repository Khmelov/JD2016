package by.it.akhmelev.jd02_08.Demo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAX extends DefaultHandler {

    public static final String PATH_XML = "src/by/it/akhmelev/jd02_07/04+XSD.xml";
    String tab = "";
    String content;

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAX sax = new SAX();
            saxParser.parse(PATH_XML, sax);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName);
        tab = tab.concat("\t");
        content = "";
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" " + attributes.getLocalName(i) + "=");
            System.out.print("\"" + attributes.getValue(i) + "\"");

        }
        System.out.println(">");

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!content.isEmpty())
            System.out.println(tab + content);
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
        content = "";

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = content.concat(new String(ch, start, length).trim());
    }
}
