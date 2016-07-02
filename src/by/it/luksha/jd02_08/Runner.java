package by.it.luksha.jd02_08;

public class Runner {
    public static void main(String[] args) {
        String pathXML = "src/by/it/luksha/JD02_07/CarRent-xsd.xml";

        System.out.println("Parser DOM:");
        ParserDOM parserDOM = new ParserDOM();
        parserDOM.readXML(pathXML);

        System.out.println("\n");
        System.out.println("Parser StAX:");
        ParserStAX parserStAX = new ParserStAX();
        parserStAX.readXML(pathXML);

        System.out.println("\n");
        System.out.println("Parser SAX:");
        ParserSAX parserSAX = new ParserSAX();
        parserSAX.readXML(pathXML);
    }
}
