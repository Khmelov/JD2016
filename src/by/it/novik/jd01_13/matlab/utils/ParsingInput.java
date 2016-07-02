package by.it.novik.jd01_13.matlab.utils;

import by.it.novik.jd01_13.matlab.entity.DoubleValue;
import by.it.novik.jd01_13.matlab.entity.MatrixValue;
import by.it.novik.jd01_13.matlab.entity.Variable;
import by.it.novik.jd01_13.matlab.entity.VectorValue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.novik.jd01_13.matlab.patterns.PatternsVar.*;

/**
 * Created by Kate Novik.
 */
public class ParsingInput {

    /**
     * Парсинг введенной строки для выделения массива переменных
     * @param line Строка ввода
     * @return Массив переменных
     */
    public static List<Variable> parsingVariables (String line) {
        List<Variable> vars = new ArrayList<>();
        String[] elemString = new String [2];
        if (line.contains("(") && line.contains(")")) {
            line = line.substring(1,line.length()-1);
        }
        if (!Pattern.compile(regxOr).matcher(line).matches()) {
            elemString = line.split(regxOper); //преобразование строки в массив
        }
        else {
            elemString [0] = line;
            elemString [1] = line;
        }
        Map<String,Variable> map = MapValues.getInstance();
        for (int i = 0; i < elemString.length; i++) {
            if (Pattern.compile(regxName).matcher(elemString[i]).matches()) {
                elemString[i] = map.get(elemString[i]).toString();
            }
        }
            for (int i = 0; i < elemString.length; i++) {
                if (Pattern.compile(regxD).matcher(elemString[i]).matches()) {
                    vars.add(new DoubleValue(elemString[i]));
                } else if (Pattern.compile(regxVec).matcher(elemString[i]).matches()) {
                    vars.add(new VectorValue(elemString[i]));
                } else if (Pattern.compile(regxMat).matcher(elemString[i]).matches()) {
                    vars.add(new MatrixValue(elemString[i]));
                } else  vars.add(null);
            }

        return vars;
    }

    /**
     * Парсинг операции в выражении
     * @param line Строка ввода
     * @return Строку с названием операции
     */
    public static String parsingOperation (String line) {
        Matcher m = Pattern.compile(regxOper).matcher(line);
        String operation = null;
        while (m.find()) {
            operation = m.group();
        }
        return operation;
    }

    /**
     * Парсинг выражения по приоритету и выделения первой приоритетной операции
     * @param line Строка ввода
     * @return Часть выражения с первой приоритетной операцией
     */
    public static String checkPriorityParsing (String line) {
        Matcher m = Pattern.compile(regxPriorityFull).matcher(line);
        String priorityExp = null;
        if (m.find()) {
            String find = m.group();
            if (find.charAt(0) == '(') {
                LinkedList<String> list = new LinkedList<>();
                int i = 1;
                list.addFirst(Character.toString(find.charAt(0)));
                while (!list.isEmpty()) {
                    if (find.charAt(i) == '(') {
                        list.addFirst(Character.toString(find.charAt(i)));
                    }
                    if (find.charAt(i) == ')') {
                        list.removeFirst();
                    }
                    i++;
                }
                priorityExp = find.substring(0,i);
            }
            else {
                priorityExp = find;
            }
        }
        return priorityExp;
    }

    /**
     * Парсинг выражения по операциям
     * @param lineExp Выражения для парсинга
     * @return List переменных в выражении типа <String>
     */
    public static List<String> parsingExp (String lineExp) {
        String[] elemString=lineExp.split(regxOper); //преобразование строки в массив
        List<String> exp = new ArrayList<>();
        for (int i=0; i<elemString.length; i++) {

            exp.add (elemString[i]);
        }
        return exp;
    }

    /**
     * Парсинг выражения по равенству
     * @param line Строка ввода
     * @return List с переменной слева от равенства и выражения справа от равенства
     */
    public static List<String> parsingEq (String line) {
        String[] elemString=line.split(regxEq); //преобразование строки в массив
        List<String> exp = new ArrayList<>();
        for (int i=0; i<elemString.length; i++) {
            exp.add (elemString[i]);
        }
        return exp;
    }
}
