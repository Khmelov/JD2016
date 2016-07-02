package by.it.luksha.jd02_04.io;

import by.it.luksha.jd02_04.operations.Operation;
import by.it.luksha.jd02_04.vars.Var;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static by.it.luksha.jd02_04.vars.Scalar.isScalar;

public class Reader {

    /**
     * Запускает чтение из строки
     *
     * @throws IOException
     */
    public static void startReadConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (!line.isEmpty()) {
            analysisLine(line);
            line = reader.readLine();
        }
    }

    /**
     * Определяет что делать с вводимой строкой
     *
     * @param line строка
     */
    public static void analysisLine(String line) {
        if (line.contains("(") || line.contains(")")) {
            analysisLine(calcBrackets(line));
        } else if (!isScalar(line)) {
            analysisLine(calc(line));
        } else {
            System.out.println(line);
        }
    }

    /**
     * Считает выражение в скобках
     *
     * @param line выражение с скобками
     * @return результат
     */
    private static String calcBrackets(String line) {
        StringBuilder result = new StringBuilder(line);
        //поиск позиции первой закрывающей скобки
        int end = result.indexOf(")");
        int start = end;
        //поиск позиции первой открывающей скобки в обратном направлении
        while (!result.substring(start - 1, start).equals("(")) {
            start--;
        }

        //рассчет выражения стоящего в скобках и вставка его в реузультирующее выражение
        String insert = calc(result.substring(start, end)) + " ";
        result.delete(start - 1, end + 1);
        result.insert(start - 1, insert);

        return String.valueOf(result);
    }

    /**
     * Считает выражение-строку без скобок с любым кол-вом переменных
     *
     * @param line выражение-строка
     * @return результат строка
     */
    public static String calc(String line) {
        //выполняет операции по приоритету *, /, +, -
        ArrayList<String> opp = Parser.toArrayOpp(line); //список всех операций в строке
        ArrayList<Var> vars = Parser.toArrayVars(line); //список всех переменнх в строке

        while (vars.size() > 1) {
            if (opp.contains("*")) {
                int start = opp.indexOf("*");
                Var var = Operation.mult(vars.get(start), vars.get(start + 1));
                vars.set(start, var);
                vars.remove(start + 1);
                opp.remove(start);
            } else if (opp.contains("/")) {
                int start = opp.indexOf("/");
                Var var = Operation.div(vars.get(start), vars.get(start + 1));
                vars.set(start, var);
                vars.remove(start + 1);
                opp.remove(start);
            } else if (opp.contains("+")) {
                int start = opp.indexOf("+");
                Var var = Operation.add(vars.get(start), vars.get(start + 1));
                vars.set(start, var);
                vars.remove(start + 1);
                opp.remove(start);
            } else if (opp.contains("-")) {
                int start = opp.indexOf("-");
                Var var = Operation.sub(vars.get(start), vars.get(start + 1));
                vars.set(start, var);
                vars.remove(start + 1);
                opp.remove(start);
            }
        }
        return String.valueOf(vars.get(0));
    }

}
