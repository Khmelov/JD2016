package by.it.akhmelev.jd02_08.Demo;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class StAX {

    public static void main(String[] args) {
        String tab="";
        String content="";
        String name="";
        String filename = "src/by/it/akhmelev/jd02_07/04+XSD.xml";
        try (FileInputStream fileReader = new FileInputStream(filename)) {
            XMLInputFactory inputFactory=XMLInputFactory.newInstance();
            XMLStreamReader reader=inputFactory.createXMLStreamReader(fileReader);
        while (reader.hasNext()) {
            int oper=reader.next();
            switch (oper) {

                case XMLStreamConstants.START_ELEMENT:
                {
                    name=reader.getLocalName();
                    System.out.print(tab+"<"+name);
                    int attrCount=reader.getAttributeCount();
                    for (int i = 0; i < attrCount; i++) {
                        System.out.print(" "+reader.getAttributeLocalName(i)+"=\"");
                        System.out.print(reader.getAttributeValue(i)+"\"");
                    }
                    System.out.println(">");
                    tab=tab.concat("\t");
                    content="";
                    break;
                }
                case XMLStreamConstants.END_ELEMENT:
                {
                    if (!content.isEmpty())
                        System.out.println(tab+content);
                    content="";
                    tab=tab.substring(1);
                    System.out.println(tab+"</"+name+">");
                    break;
                }
                case XMLStreamConstants.CHARACTERS:
                {
                    content=content.concat(reader.getText().trim());
                    break;
                }

                case XMLStreamConstants.ATTRIBUTE: {
                    System.out.println(tab + "ATTR - ERROR!!!!! for Git");
                    break;
                }
            }
        }

        } catch (Exception e) {
        }
    }
}
