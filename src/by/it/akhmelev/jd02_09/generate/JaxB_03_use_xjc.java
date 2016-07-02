package by.it.akhmelev.jd02_09.generate;
//тут нужно указать путь к сгенерированным классам

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxB_03_use_xjc {
        public static void main(String[ ] args) {
            try {

                JAXBContext jc = JAXBContext.newInstance(Students.class);
                Unmarshaller u = jc.createUnmarshaller();
                FileReader reader = new FileReader("src/by/it/akhmelev/jd02_09/generate/xml_data.xml");
                System.out.println("XML-файл прочитан:");
                Students students = (Students) u.unmarshal(reader);
                System.out.println(students);

            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }