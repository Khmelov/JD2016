package by.it.luksha.jd02_10.converter;

public class ConverterFactory {
    private enum Direction {
        XML_2_JSON, JSON_2_XML
    }

    public AbstractConverter createConverterBuilder(String typeParser) {
        Direction direction = Direction.valueOf(typeParser.toUpperCase());
        switch (direction) {
            case XML_2_JSON:
            {
                return new ConverterXML2JSONBuilder();
            }
            case JSON_2_XML:
            {
                return new ConverteJSON2XMLBuilder();
            }
            default: throw new EnumConstantNotPresentException(
                    direction.getDeclaringClass(), direction.name()
            );
        }
    }
}
