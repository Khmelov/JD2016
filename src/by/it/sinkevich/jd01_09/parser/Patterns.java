package by.it.sinkevich.jd01_09.parser;

/**
 * Класс содержит список паттернов для поиска парсером нужных элементов в строке
 *
 * @author Sinkevich Denis
 */
public class Patterns {
    /**
     * Паттерн для поиска в строке целого числа, лиюо числа с плавающей точкой, может использоваться и для валидации
     */
    public static String regexFloat = "[+-]?(((([1-9][0-9]*)|0)\\.[0-9]+)|(([1-9][0-9]*)|0)|((([1-9][0-9]*)|0)\\.)|(\\.[0-9]+))";
    /**
     * Паттерн для поиска вектора в строке
     */
    public static String regexVector = "\\{( *" + regexFloat + ",)( *" + regexFloat + ",?)+\\}";
    /**
     * Паттерн для поиска матрицы в строке
     */
    public static String regexMatrix = "\\{( *" + regexVector + ",)( *" + regexVector + ",?)+\\}";
    /**
     * Паттерн для поиска любой переменной в строке типа {@code MathLabVariable}
     */
    public static String regexAnyMathLabVariable = "(" + regexFloat + ")|(" + regexVector + ")|(" + regexMatrix + ")";
    /**
     * Паттерн для скобок
     */
    public static String regexBrackets = "[\\(\\)]";
    /**
     * Паттерн для класса Parser
     */
    public static String regexForParser = "(" + regexAnyMathLabVariable + ")|(" + regexBrackets +")";
    /**
     * Паттерн для арифметических операций
     */
    public static String regexOperators = "[+-/*]";

}
