package by.it.akhmelev.jd02_08.Demo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOM {
    public  static void main(String[] args){
        String filename="src/by/it/akhmelev/jd02_07/04+XSD.xml";
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder=factory.newDocumentBuilder();
            Document document=documentBuilder.parse(filename);
            Element element=document.getDocumentElement();
            printElement("","",element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printElement(String prefix, String name, Node node){
        String txt=node.getNodeValue();
        if (txt!=null) System.out.println(prefix+name+"\n"+prefix+txt.trim());
        NodeList nodes=node.getChildNodes();
        prefix=prefix+"\t";
        for (int i = 0; i < nodes.getLength(); i++) {
            printElement(prefix, "<"+node.getNodeName().trim()+">",nodes.item(i));
        }
    }
}
