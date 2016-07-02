package by.it.drachyova.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class ValidatorXSD {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "src/by/it/drachyova/jd02_07/Hotel_XSD.xml";
        String schemaName = "src/by/it/drachyova/jd02_07/Hotel.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println(fileName + " валиден.");
        } catch (SAXException e) {
            System.err.print("Валидация " + fileName + " не выполена: "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName + " не валиден:"
                    + e.getMessage());
        }
    }
}
