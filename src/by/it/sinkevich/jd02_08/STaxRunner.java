package by.it.sinkevich.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Class for jd02_08. Using STaxParser
 *
 * @author Sinkevich Denis
 */
public class STaxRunner {

    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/";
        String filePath = src + "by/it/sinkevich/jd02_08/HorseRaceForXSD.xml";
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int element = reader.next();
                switch (element) {
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Начало парсинга документа!");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        stringBuilder.append(tab).append("<").append(reader.getLocalName());
                        int atrCount = reader.getAttributeCount();
                        for (int i = 0; i < atrCount; i++) {
                            stringBuilder.append(" ").append(reader.getAttributeLocalName(i));
                            stringBuilder.append("=\"").append(reader.getAttributeValue(i)).append("\"");
                        }
                        stringBuilder.append(">\n");
                        tab = tab + "\t";
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String text = reader.getText().trim();
                        if (!text.isEmpty()) {
                            stringBuilder.append(tab).append(text).append("\n");
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tab = tab.substring(1);
                        stringBuilder.append(tab).append("</").append(reader.getLocalName()).append(">\n");
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.print(stringBuilder.toString());
                        System.out.println("Конец парсинга документа!");
                        break;
                }
            }
        } catch (XMLStreamException | IOException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }

    private static StringBuilder stringBuilder = new StringBuilder();
    private static String tab = "";
}
