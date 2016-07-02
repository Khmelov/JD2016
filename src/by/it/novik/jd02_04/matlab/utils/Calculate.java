package by.it.novik.jd02_04.matlab.utils;


import by.it.novik.jd01_13.matlab.entity.Variable;
import by.it.novik.jd01_13.matlab.exceptions.ErrorOperationsException;
import by.it.novik.jd01_13.matlab.operations.AddOperations;
import by.it.novik.jd01_13.matlab.operations.DivOperations;
import by.it.novik.jd01_13.matlab.operations.MultiOperations;
import by.it.novik.jd01_13.matlab.operations.SubOperations;
import by.it.novik.jd01_13.matlab.patterns.PatternsVar;
import by.it.novik.jd01_13.matlab.utils.ParsingInput;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kate Novik.
 */
public class Calculate {

    /**
     * Метод запуска вычисления выражения
     * @param line Строка ввода
     * @return Результат выражения типа String
     */
    public String calculateExp (String line) throws ErrorOperationsException {
        Variable result = null;
        String name = null;
        // Проверяем наличие равенства в строке вводе
        if (line.contains("=")) {
            name = ParsingInput.parsingEq(line).get(0);
            line = ParsingInput.parsingEq(line).get(1); //Сохраняем правую часть равенства в переменную line
            if (Pattern.compile(PatternsVar.regxOr).matcher(line).matches()) {
                result = ParsingInput.parsingVariables(line).get(0);
            }
            else {
                result = calc(line); //Запуск вычисления выражения
            }
        } else {
            result = calc(line);
        }

        if (name!=null && result != null) {
            result.saveByName(name); // Сохранение имени переменной
            line = name + " = " + result.toString();
        }
        else if (name == null && result!=null) {
            line = result.toString();
        }
        else  {
            line = null;
        }
    return line;
    }

    /**
     * Функция вычисления выражения
     * @param line выражение в виде строки
     * @return результат вычисления выражения
     */
    public Variable calc (String line) throws ErrorOperationsException {
        Variable result = null;
        List<Variable> var;
        String st ;
        String exp = ParsingInput.checkPriorityParsing(line);
        if (exp!=null) {
            if (!Pattern.compile(PatternsVar.regxFull).matcher(exp).matches()) {
                if (exp.contains("(") && exp.contains(")")) {
                    st = exp.substring(1, exp.length() - 1);

                } else {
                    st = exp;
                }
                result = calc(st);
                line = line.replace(exp, result.toString());
            }
        }
        exp = ParsingInput.checkPriorityParsing(line);
        String op;
        //Цикл вычисления приоритетных выражений и замены их на результат в строке ввода
        while (exp != null) {
            if (!Pattern.compile(PatternsVar.regxFull).matcher(exp).matches()) {
                st = exp.substring(1, exp.length() - 1);
                result = calc (st);
                line = line.replace(exp, result.toString());
                exp = ParsingInput.checkPriorityParsing(line);
                continue;
            }
            var = ParsingInput.parsingVariables(exp);
            op = ParsingInput.parsingOperation(exp);
            result = switchOperation(op, var.get(0), var.get(1));
            String sub = ParsingInput.parsingExp(exp).get(0) + op + ParsingInput.parsingExp(exp).get(1);
            //Замена приоритетного выражения во входной строке на его результат
            if (result != null) {
                line = line.replace(sub, result.toString());
            }
            else {return null;}
            exp = ParsingInput.checkPriorityParsing(line);
        }
        //Вычисление выражения при отсутствии приоритетов
        Matcher m = Pattern.compile(PatternsVar.regxFull).matcher(line);
        while (m.find()) {
            String s = m.group();
            var = ParsingInput.parsingVariables(s);
            op = ParsingInput.parsingOperation(s);
            result = switchOperation(op, var.get(0), var.get(1));
            if (result != null) {
                String sub = ParsingInput.parsingExp(s).get(0) + op + ParsingInput.parsingExp(s).get(1);
                String l = line.replace(sub, result.toString());
                line = l;
                m.reset(l);
            }
            else {break;}
        }
        return result;
    }

    /**
     * Метод выбора операции
     * @param operation Операция типа String
     * @param var1 Переменная1
     * @param var2 Переменная2
     * @return Результат операции типа Variable
     */
    private Variable switchOperation (String operation, Variable var1, Variable var2) throws ErrorOperationsException {
        AddOperations operAdd = new AddOperations();
        SubOperations operSub = new SubOperations();
        MultiOperations operMulti = new MultiOperations();
        DivOperations operDiv = new DivOperations();
        Variable result = null;
        switch (operation) {
            case " + ": {
                result = operAdd.addition(var1, var2);
                break;
            }
            case " - ": {
                result = operSub.subtraction (var1, var2);
                break;
            }
            case " * ": {
                result = operMulti.multiplication(var1, var2);
                break;
            }
            case " / ": {
                result = operDiv.division(var1, var2);
                break;
            }
        }
        return result;
    }
}
