package by.it.luksha.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ParserDOM {
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private String space = ""; //переменная для табуляции

    public ParserDOM() {
        this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            this.documentBuilder = this.documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.print("Ошибка в создании DocumentBuilder: " + e);
        }
    }

    /**
     * читает XML файл
     *
     * @param pathXML путь к файлу
     */
    public void readXML(String pathXML) {
        Document document = null;
        try {
            document = this.documentBuilder.parse(pathXML);
        } catch (SAXException e) {
            System.err.print("Ошибка в создании Document: " + e);
        } catch (IOException e) {
            System.err.print("Ошибка IO: " + e);
        }

        //корневой элемент документа
        Element elementRoot = document.getDocumentElement();
        parseXML(elementRoot); //вызов рекурсивного прохода по файлу
        System.out.printf("</%s>", elementRoot.getNodeName().trim());
    }

    /**
     * проходит по элементам XML файла
     *
     * @param node корневой элемент
     */
    private void parseXML(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.printf("%s<%s", space, node.getNodeName().trim());
            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.printf(" %s=\"%s\"", ((Attr) attributes.item(i)).getName(), ((Attr) attributes.item(i)).getValue());
                }
            }
            System.out.printf(">\n");
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            if (!node.getTextContent().isEmpty()) {
                /**
                 * обрезка пустых строк (слова через пробел выводит с новой строки)
                 */
                String[] strings = node.getTextContent().split("\\s");
                for (int i = 0; i < strings.length; i++) {
                    if (!strings[i].isEmpty()) {
                        System.out.printf("%s%s\n", space, strings[i].trim());
                    }
                }
            }
            if (node.getPreviousSibling() != null) {
                System.out.printf("%s</%s>\n", space, node.getPreviousSibling().getNodeName()); //вывод закрывающего тэга
            }
        }

        //получение дочерних элементов
        NodeList children = node.getChildNodes();
        //увеличение табуляции, на уровень вниз
        space += "\t";
        for (int i = 0; i < children.getLength(); i++) {
            parseXML(children.item(i));
        }
        //уменьшение табуляции, на уровень вверх
        space = space.substring(1);
    }

}
