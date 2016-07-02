package by.it.novik.jd02_08.builders;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Kate Novik.
 */
public class PaymentsDOMBuilder extends AbstractPaymentsBuilder {
    //Поле табуляции
    private String tab = "";

    /**
     * Парсинг XML документа DOM-парсером
     *
     * @param filename Путь к XML документу
     */
    public void buildPayments(String filename) {
        //Создаем фабрику и парсер DOM
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document doc = builder.parse(filename);
            Element element = doc.getDocumentElement();
            //Печатаем корневой элемент начало
            printRootElement(element,true);
            //Печатаем элементы с атрибутами
            printDOM(element);
            //Печатаем корневой элемент конец
            printRootElement(element,false);
        } catch (ParserConfigurationException e) {
            System.out.println("Ошибка создания парсера DOM" + e);
        } catch (SAXException e) {
            System.out.println("Ошибка парсера DOM" + e);
        } catch (IOException e) {
            System.out.println("Ошибка вывода" + e);
        }
    }

    /**
     * Печать корневого элемента XML документа
     *
     * @param root Корневой элемент типа Node
     */
    private void printRootElement(Node root, boolean start) {
        String parentNode = root.getNodeName();
        if (parentNode != null) {
            if (!start){
                System.out.print("</" + parentNode.trim());
            } else {
                System.out.print("<" + parentNode.trim());
                if (root.hasAttributes()) {
                    NamedNodeMap listAttr = root.getAttributes();
                    for (int j = 0; j < listAttr.getLength(); j++) {
                        //Печать атрибутов
                        System.out.print(" ");
                        System.out.print(((Attr) listAttr.item(j)).getName() + "=\"" + ((Attr) listAttr.item(j)).getValue() + "\"");
                    }
                }
            }
            System.out.print(">");
            tab = tab + '\t'; //Прибавляем табуляцию
        }
    }

    /**
     * Печать дочерних элементов и их атрибутов в XML документе
     *
     * @param node Элемент типа Node
     */
    private void printDOM(Node node) {
        //Получаем список дочерних элементов
        NodeList childrenNode = node.getChildNodes();
        for (int i = 0; i < childrenNode.getLength(); i++) {
            if (childrenNode.item(i).getNodeType() == Node.ELEMENT_NODE) { //Проверка на соответствие элементу
                System.out.print(tab + "<" + childrenNode.item(i).getNodeName().trim());
                if (childrenNode.item(i).hasAttributes()) {
                    NamedNodeMap listAttr = childrenNode.item(i).getAttributes();
                    for (int j = 0; j < listAttr.getLength(); j++) {
                        //Печать атрибутов
                        System.out.print(" ");
                        System.out.print(((Attr) listAttr.item(j)).getName() + "=\"" + ((Attr) listAttr.item(j)).getValue()+"\"");
                    }
                }
                System.out.println(">");
                tab = tab + '\t'; //Прибавляем табуляцию
            } else if (childrenNode.item(i).getNodeType() == Node.TEXT_NODE) { //Проверка на соответствие тексту между элементами
                System.out.println(tab + childrenNode.item(i).getTextContent().trim());
                if (i != 0) {
                    //Удаляем один табулятор из поля табуляции
                    tab = tab.substring(1);
                    //Вывод закрывающегося элемента
                    System.out.println(tab + "</" + childrenNode.item(i - 1).getNodeName().trim() + ">");
                }
            }
            //Рекурсивный вызов печати дочерних элементов и их атрибутов у данного элемента
            printDOM(childrenNode.item(i));
        }
    }
}
