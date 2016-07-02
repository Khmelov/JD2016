package by.it.sinkevich.jd01_09.variables;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс для хранения имён и значений переменных созданных в процессе работы программы
 *
 * @author Sinkevich Denis
 */
public class VariablesStorage {
    /**
     * Поле для хранения переменных, созданных во время работы программы
     */
    private final static Map<String, MathLabVariable> variablesStorage = new HashMap<>();

    /**
     * Добавляет переменную в список, если переменная существует, то перезаписывает её значение
     *
     * @param variableName  имя переменной тип {@code String}
     * @param variableValue Значение переменной тип {@code MathLabVariable}
     */
    public static void add(String variableName, MathLabVariable variableValue) {
        variablesStorage.put(variableName, variableValue);
    }

    /**
     * Возвращает значение переменной из списка
     *
     * @param variableName имя переменной тип {@code String}
     * @return Значение переменной тип {@code MathLabVariable}
     */
    public static MathLabVariable get(String variableName) {
        return variablesStorage.get(variableName);
    }

    /**
     * Выводит список всех переменных и их значений на консоль
     */
    public static void printVariables() {
        System.out.println(variablesStorage);
    }

    /**
     * Выводит отсортированный список всех переменных на консоль
     */
    public static void printSortedvariables() {
        Map<String, MathLabVariable> sortedMap = new TreeMap<>(variablesStorage);
        System.out.println(sortedMap);
    }
}
