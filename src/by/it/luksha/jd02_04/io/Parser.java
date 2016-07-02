package by.it.luksha.jd02_04.io;

import by.it.luksha.jd02_04.vars.Matrix;
import by.it.luksha.jd02_04.vars.Scalar;
import by.it.luksha.jd02_04.vars.Var;
import by.it.luksha.jd02_04.vars.Vector;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser  {

    //RegEx
    //числа
    static public String exScalar = "-?[0-9]+(\\.[0-9]+)?";
    //вектора
    static public String exVector = "[{]{1}(-?[0-9]+(\\.[0-9]+)?){1}(,-?[0-9]+(\\.[0-9]+)?){1,}[}]{1}";
    //матрицы
    static public String exMatrix = "[{]{1}([{]{1}(-?[0-9]+(\\.[0-9]+)?){1}(,-?[0-9]+(\\.[0-9]+)?){1,}[}]{1}){1}(,[{]{1}(-?[0-9]+(\\.[0-9]+)?){1}(,-?[0-9]+(\\.[0-9]+)?){1,}[}]{1}){1,}[}]{1}";
    //одно из...
    static public String exAny = "("+ exMatrix +")|("+ exVector +")|("+ exScalar +")";
    //операция
    static public String exOper = "((\\s-\\s){1})|((\\s\\+\\s){1})|((\\s\\*\\s){1})|((\\s/\\s){1})|((\\s=\\s){1})";
    //скобки
    static public String exBrackets = "\\(.+\\)";

    //выражение целиком
    static public String exFull= "("+exAny+")"+
            "(" +exOper+")"+
            "(" +exAny +")";

    /**
     * Ищет в строке вектор и преобразует в массив double
     * @param line строка
     * @return массив double
     */
    public static double[] findVector(String line) {
        double[] arrayForVector = new double[line.split(",").length];
        Matcher matcherVector = Pattern.compile(exScalar).matcher(line);
        int i = 0;
        while (matcherVector.find()) {
            arrayForVector[i] = Double.parseDouble(matcherVector.group());
            i++;
        }

        return arrayForVector;
    }

    /**
     * Парсит строку на массив с элементами типа Var
     * @param string строка
     * @return массив
     */
    public static Var[] toVars(String string) {
        String[] varsString = string.split(exOper);
        Var[] vars = new Var[varsString.length];
        for (int i = 0; i < varsString.length; i++) {
            //матрица
            Pattern patternMatrix = Pattern.compile(exMatrix);
            Matcher matcherMatrix = patternMatrix.matcher(varsString[i]);
            //вектор
            Pattern patternVector = Pattern.compile(exVector);
            Matcher matcherVector = patternVector.matcher(varsString[i]);
            //скаляр
            Pattern patternScalar = Pattern.compile(exScalar);
            Matcher matcherScalar = patternScalar.matcher(varsString[i]);

            if (matcherMatrix.find()) {
                int start = matcherMatrix.start();
                int end = matcherMatrix.end();
                String matrix = varsString[i].substring(start, end).trim();
                Matrix mx = new Matrix(matrix);
                vars[i] = mx;
                matcherMatrix.reset();
            }
            else if (matcherVector.find()) {
                int start = matcherVector.start();
                int end = matcherVector.end();
                String vector = varsString[i].substring(start, end).trim();
                Vector vc = new Vector(vector);
                vars[i] = vc;
                matcherVector.reset();
            }
            else if (matcherScalar.find()) {
                int start = matcherScalar.start();
                int end = matcherScalar.end();
                String scalar = varsString[i].substring(start, end).trim();
                Scalar sc = new Scalar(scalar);
                vars[i] = sc;
                matcherScalar.reset();
            }
            else {System.out.println("Переменные не найдены");}
        }
        return vars;
    }

    /**
     * Определяет знак операции выражения
     * @param string строка-выражение
     * @return строка-знак
     */
    public static String checkOperation(String string) {
        String sign = "";
        Pattern patternOperation = Pattern.compile(exOper);
        Matcher matcherOperation = patternOperation.matcher(string);
        if (matcherOperation.find()) {
            int start = matcherOperation.start();
            int end = matcherOperation.end();
            sign = string.substring(start, end).trim();
        }
        else
        {
            System.out.println("Невозможно определить знак операции");
        }

        return sign;
    }

    /**
     * Ищет в строке выражение между скобками
     * @param string строка
     * @return выражение
     */
    public static String findBrackets(String string) {
        String result = "";
        Pattern patternBrackets = Pattern.compile(exBrackets);
        Matcher matcherBrackets = patternBrackets.matcher(string);
        if (matcherBrackets.find()) {
            int start = matcherBrackets.start();
            int end = matcherBrackets.end();
            result = string.substring(start + 1, end - 1).trim();
        }
        return result;
    }

    /**
     * Формирует список операций из строки
     * @param string строка
     * @return список операций
     */
    public static ArrayList<String> toArrayOpp(String string) {
        ArrayList<String> result = new ArrayList<>();

        Pattern patternOperation = Pattern.compile(exOper);
        Matcher matcherOperation = patternOperation.matcher(string);
        while (matcherOperation.find()) {
            int start = matcherOperation.start();
            int end = matcherOperation.end();
            result.add(string.substring(start, end).trim());
        }

        return result;
    }

    /**
     * Формирует список переменных из строки
     * @param string строка
     * @return список переменных
     */
    public static ArrayList<Var> toArrayVars(String string) {
        ArrayList<Var> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(string);

        Pattern patternVars = Pattern.compile(exAny);
        Matcher matcherVars = patternVars.matcher(stringBuilder);
        while (matcherVars.find()) {
            int start = matcherVars.start();
            int end = matcherVars.end();
            String var = stringBuilder.substring(start, end).trim();
            if (Scalar.isScalar(var)) {
                result.add(new Scalar(var));
                stringBuilder.delete(start, end);
                matcherVars.reset();
            }
            // сделать тоже самое через else-if для векторов и матриц

        }

        return result;
    }

}
