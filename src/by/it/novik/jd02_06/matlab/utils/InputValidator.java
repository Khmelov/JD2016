package by.it.novik.jd02_06.matlab.utils;

import by.it.novik.jd02_06.matlab.entity.Variable;
import by.it.novik.jd02_06.matlab.io.InOutImpl;
import by.it.novik.jd02_06.matlab.patterns.PatternsVar;
import by.it.novik.jd02_06.matlab.utils.*;
import by.it.novik.jd02_06.matlab.utils.MapValues;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.novik.jd02_06.matlab.patterns.PatternsVar.regxFullEq;

/**
 * Created by Kate Novik.
 */
public class InputValidator  {
    /**
     * Проверка выражения на корректность расстановки скобок
     * @param line строка
     * @return true - скобки расставлены правильно и количество открывающихся равно количеству закрывающихся
     */
    private static boolean checkBracketsInExp (String line) {
        //Создаем LinkedList для хранения найденных открывающихся скобок
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        while (i<line.length()) {
            if (line.charAt(i) == '{' || line.charAt(i) == '[' || line.charAt(i) == '(') {
                list.addFirst(Character.toString(line.charAt(i)));
            }
            if (line.charAt(i) == '}' || line.charAt(i) == ']' || line.charAt(i) == ')' && !list.isEmpty()) {
                if (list.getFirst().equals("{") && line.charAt(i) == '}') {
                    list.removeFirst();
                }
                else if (list.getFirst().equals("[") && line.charAt(i) == ']') {
                    list.removeFirst();
                }
                else if (list.getFirst().equals("(") && line.charAt(i) == ')') {
                    list.removeFirst();
                }
                else {
                    return false;
                }
            }
            else if (line.charAt(i) == '}' || line.charAt(i) == ']' || line.charAt(i) == ')' && list.isEmpty()) {

                return false;
            }
            i++;
        }
        if (!list.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Проверка строки ввода на соответствие выражению
     * @param line Строка ввода
     * @return true - соответствует выражению
     */
    private static boolean checkExp (String line) {
        if (!Pattern.compile(regxFullEq).matcher(line).matches()) {
            return false;
        }
    return true;
    }

    /**
     * Проверка названия переменной на повтор
     * @param line Строка ввода
     * @return true - повтор есть
     */
    private static boolean checkExpName (String line) {
        Map<String,Variable> map = MapValues.getInstance();
        if (line.contains("=")) {
            String name = by.it.novik.jd01_13.matlab.utils.ParsingInput.parsingEq(line).get(0);
            if (map.containsKey(name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка наличия переменных в Map
     * @param line Строка ввода
     * @return true - переменные есть
     */
    private static boolean checkExpNameVariables (String line) {
        Map<String,Variable> map = MapValues.getInstance();
        if (line.contains("=")) {
            line = line.substring(line.indexOf("="));
        }
        Matcher m = Pattern.compile(PatternsVar.regxName).matcher(line);
        while (m.find()) {
            String s = m.group();
                if (!map.containsKey(s)) {
                    return false;
            }

        }
        return true;
    }

    /**
     * Проверка на валидацию введенных данных
     * @return Проверенную строку ввода
     * @throws IOException
     */
    public static String checkValidation  () throws IOException {
        InOutImpl inout = new InOutImpl();
        System.out.println("Введите выражение через пробел:");
        //Ввод с консоли
        String line = inout.input();
        if (!checkExp(line) || !checkBracketsInExp(line)) {
            System.out.println("Выражение введено неправильно! Повторите ввод.");
            line = checkValidation(); // Рекурсивный вызов функции проверки на валидацию
        }
        if (!checkExpName(line)) {
            System.out.println("Введенное название переменной уже существует! Перезаписать (yes/no):");
            String l = inout.input();
            if (l.equals("no")) {
                line = checkValidation(); // Рекурсивный вызов функции проверки на валидацию
            }
            else if (!l.equals("no") && !l.equals("yes")){
                System.out.println("Введите yes или no");
            }
        }
        if (!checkExpNameVariables(line)) {
            System.out.println("Введенные переменные в выражении не существуют! Повторите ввод.");
            line = checkValidation(); // Рекурсивный вызов функции проверки на валидацию
        }
        return line;
    }

    /**
     * Проверка на повтор ввода выражения
     * @param line Строка ввода
     * @return true - вводить, false - не вводить
     * @throws IOException
     */
    public static boolean checkRepeatInput (String line) throws IOException {
        InOutImpl inout = new InOutImpl();
        boolean in = false;
        while (!line.equals("yes") || !line.equals("no")) {
            System.out.println("Повторить ввод (yes/no)?");
            line = inout.input();
            if (line.equals("yes")) {
                in = true; break;
            } else if (line.equals("no")) {
                in = false; break;
            } else {
                System.out.println("Введите yes или no");
            }
        }
        return in;
    }
}
