package by.it.luksha.jd02_10.converter;

public class Runner {
    public static void main(String[] args) {
        ConverterFactory converterFactory = new ConverterFactory();
        AbstractConverter converter = converterFactory.createConverterBuilder("xml_2_json");
        converter.buildConverter("src/by/it/luksha/jd02_07/CarRent-xsd.xml");
        String json = converter.getConvertResult();
        System.out.println(json);
    }
}
