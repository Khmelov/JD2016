package by.it.sinkevich.jd01_09.parser;

import by.it.sinkevich.jd01_09.manipulators.ExpressionSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс содержит методы для обработки строки, которую вводит пользователь для поледующих вычислений
 *
 * @author Sinkevich Denis
 */
public class Parser {
    /**
     * Обрабатывает строку введённую пользователем, разделяет переменные, скаляры, векторы,
     * матрицы и операторы со скобками в отдельные элементы
     *
     * @param line строка, которую ввёл пользователь тип {@code String}
     * @return список элементов сроки тип {@code String}
     */
    public static List<String> parseLine(String line) {
        List<String> result = new ArrayList<>();
        //Проверяем наличие знака равно в заданной сроке
        if (checkLineForEqualitySign(line)) {
            int indexOfEqualSign = line.indexOf("=");
            //Часть строки до знака равно будет переменной
            String variableName = line.substring(0, indexOfEqualSign).trim();
            result.add(variableName);
            result.add("=");
            //Обрезаем строку для последующего парсинга
            line = line.substring(indexOfEqualSign + 1).trim();
        }
        //Паттерн, для поиска в тексте совпадений. Ищет скаляры, векторы, матрицы, а также скобки
        Pattern pattern = Pattern.compile(Patterns.regexForParser);
        Matcher matcher = pattern.matcher(line);
        //Переменная start будет хранить в себе индекс начала следующего совпадения matcher'а
        int start;
        //Переменная end будет хранить в себе индекс окончание последнего совпадения
        int end = 0;
        while (matcher.find()) {
            start = matcher.start();
            //Если индекс начала текущего совпадения больше, чем индекс окончания предыдущего, то всё, что между ними
            //это оператор
            if (start > end) {
                //Находим оператор и удаляем лишние пробелы
                String operand = line.substring(end, start).trim();
                //Добавляет оператор "+" для начала строки, если она начинается не с "-", либо в ней были лишние пробелы
                if (operand.isEmpty()) {
                    result.add("+");
                } else {
                    result.add(operand);
                }
                //Если индексы начала текущего совпадения и окончания предыдущего совпадают, то нужно добавить плюс между переменными
                //Это сделано для обработки ситуаций ввода --2 +-3, для правильного определения знаков
            } else {
                //Единственное исключение, это открывающие и закрывающие скобки
                if (!matcher.group().matches(Patterns.regexBrackets)) {
                    result.add("+");
                }
            }
            //Переприсваиваем значение окончания совпадения
            end = matcher.end();
            //Записываем в список выделенный элемент
            result.add(matcher.group());
        }
        return result;
    }

    public static void main(String[] args) {
        String testLine = "a=(28.5+5.3) - ((17))() + (100.2/(123* 2 - 2) + 5345.3/5*3*66) - 1";
        String testVector = " {1, -321,.2,-64., +12, -1.976}*{1.5, 21,.2, -64., +42, -1.976} - {1, 1.456,.2, -4., +122, -1.96}";
        String testMatrix = "{{2.2, 5.8}, {1.5, 6.2}, {-2.5, 7.4}, {4.2, -2.3}} * {{5.2, 3.2, 3.8}, {6.8, -7.5, -1.9}}/" +
                "{ {1.2, -3.5, 1.8, -2.2, -5.3},  {10, -2.8, 3.2, -2.8, 1.5},{2.3, -6.5, -9.2, 6.5, -1.2}}";
        String simpleVector = "{1, 2, 3} * {1, 2, 3}";
        String simpleMatrix = "{{2.2, 5.8}, {1.5, 6.2}, {-2.5, 7.4}, {4.2, -2.3}} * {{5.2, 3.2, 3.8}, {6.8, -7.5, -1.9}}";
        String simmplLine = "2 * (35 - 5) * (-1/30)";
        String mixedLine = testLine.concat("*").concat(testVector).concat("-").concat(testMatrix);
        List<String> result = parseLine(testLine);

        for (String x : result) {
            System.out.println(x);
        }
        ExpressionSolver solver = new ExpressionSolver();
        System.out.println(solver.solveExpression(result));
    }

    /**
     * Метод проверяет есть ли в строке знак "=" и их количество
     *
     * @param line проверяемая строка, тип {@code String}
     * @return true, если в строке есть один знак присвоения; false, если в строке их нету, либо их несколько.
     * Если их несколько, то дополнительно выводится сообщение об ошибке.
     */
    private static boolean checkLineForEqualitySign(String line) {
        if (line.contains("=")) {
            int indexOfEqualitySign = line.indexOf("=");
            //Ищем ещё один знак равно, после текущего
            indexOfEqualitySign = line.indexOf("=", indexOfEqualitySign + 1);
            if (indexOfEqualitySign == -1) {
                return true;
            } else {
                System.out.println("Неверно записано выражение, в нём присутствует более одного знака присвоения!");
                System.out.println("Ошибка в символе " + indexOfEqualitySign);
            }
        }
        return false;
    }
}
