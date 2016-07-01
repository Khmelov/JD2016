package by.it.luksha.jd02_08;

public class Runner {
    public static void main(String[] args) {
        String pathXML = "src/by/it/luksha/JD02_07/CarRent-xsd.xml";
        ParserDOM parserDOM = new ParserDOM();
        parserDOM.readXML(pathXML);
    }
}
