package by.it.luksha.jd02_09.taskAxml2html;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by MMauz on 30.06.2016.
 */
public class GeneratorXML2HTML {
    public void convertXML2HTML(String fileXML) {
        String fileHTML = fileXML.substring(0, fileXML.length() - 3) + "html";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(fileXML.substring(0, fileXML.length() - 3) + "xsl"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileXML),
                    new StreamResult(fileHTML));
            transformer.transform(new StreamSource(fileXML),
                    new StreamResult(System.out));

            System.out.println("Преобразование " + fileXML + " завершено");
        } catch (TransformerException e) {
            System.err.println("Ошибка преобразования файла " + fileXML + ": " + e);
        }
    }
}
