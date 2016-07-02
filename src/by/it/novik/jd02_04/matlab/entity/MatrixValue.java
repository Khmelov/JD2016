package by.it.novik.jd02_04.matlab.entity;


import by.it.novik.jd01_13.matlab.entity.*;
import by.it.novik.jd01_13.matlab.patterns.PatternsVar;
import by.it.novik.jd01_13.matlab.utils.MapValues;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kate Novik.
 */
public class MatrixValue extends by.it.novik.jd01_13.matlab.entity.Variable {
    // Поле значение переменной
    private double[][] valueM;

    public MatrixValue(double [][] valueM) {
        this.valueM = new double [valueM.length] [valueM.length];
        this.valueM = valueM.clone();
    }

    public MatrixValue(int length) {
        this.valueM = new double [length] [length];
    }

    public MatrixValue(String valueM) {
        setValue (valueM);
    }

    /**
     * Override метода получить значение переменной
     * @return Значение переменной
     */
    @Override
    public double[][] getValue() {
        return this.valueM;
    }

    /**
     * Перегрузка метода setValue - установить значение поля valueV
     * @param valueM Массив double[][]
     */
    public void setValue(double[][] valueM) {
        this.valueM = new double [valueM.length][valueM.length];
        this.valueM = valueM.clone();
    }

    /**
     * Перегрузка метода saveByName - сохранить по имени переменную
     * @param nameVar Название переменной типа String
     * @return true - переменная по имени сохранена
     */
    @Override
    public boolean saveByName(String nameVar) {
        Map<String, by.it.novik.jd01_13.matlab.entity.Variable> nameVariables = MapValues.getInstance();
//        if (!nameVariables.containsKey(nameVar)) {
            nameVariables.put(nameVar, new MatrixValue(this.valueM));
            return true;
//        }
//        return false;
    }

    /**
     * Перегрузка метода readByName - прочитать значение переменной по имени
     * @param nameVar Название переменной типа String
     * @return Значение переменной
     */
    @Override
    public double[][] readByName(String nameVar) {
        Map <String, by.it.novik.jd01_13.matlab.entity.Variable> nameVariables = MapValues.getInstance();
        if (nameVariables.containsKey(nameVar)) {
            return ((MatrixValue) nameVariables.get(nameVar)).getValue();
        }
        return null;
    }

    /**
     * Override метода toString
     * @return Значение переменной в виде строки
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{{");
        int k = 0;
        for (double[] v : valueM) {
            for (Double m : v) {
                k++;
                s = s.append(m.toString());
                if (k % valueM.length != 0) {
                    s.append(",");
                } else if (k != valueM.length * valueM.length) {
                    s.append("},{");
                } else {
                    s.append("}}");
                }
            }
        }
        return s.toString();
    }

    /**
     * Override метода преобразование значение переменной строки в массив [][]
     * @param value Переданная строка
     */
    @Override
    public void setValue (String value) {
        String[] elem=value.split(PatternsVar.regxSc);
        valueM=new double[elem.length][elem.length];
        for (int i=0; i<elem.length; i++) {
            Matcher mat = Pattern.compile(PatternsVar.regxD).matcher(elem[i]);
            int j = 0;
            while (mat.find()) {
                valueM[i][j] = Double.parseDouble(mat.group());
                j++;
            }
        }
    }
}
