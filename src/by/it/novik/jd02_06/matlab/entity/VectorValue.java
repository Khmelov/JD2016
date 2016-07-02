package by.it.novik.jd02_06.matlab.entity;

import by.it.novik.jd02_06.matlab.entity.*;
import by.it.novik.jd02_06.matlab.patterns.PatternsVar;
import by.it.novik.jd02_06.matlab.utils.MapValues;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kate Novik.
 */
public class VectorValue extends Variable {
    // Поле значение переменной
    private double[] valueV;

    public VectorValue() {
        this.valueV = null;
    }

    public VectorValue(double [] valueV) {
        this.valueV = new double [valueV.length];
        this.valueV = valueV.clone();
    }

    public VectorValue(int length) {
        this.valueV = new double [length];
    }

    public VectorValue(String valueV) {
        setValue (valueV);
    }

    /**
     * Override метода получить значение переменной
     * @return Значение переменной
     */
    @Override
    public double[] getValue() {
        return this.valueV;
    }

    /**
     * Перегрузка метода setValue - установить значение поля valueV
     * @param valueV Массив double[]
     */
    public void setValue(double[] valueV) {
        this.valueV = new double [valueV.length];
        this.valueV = valueV.clone();
    }

    /**
     * Создание вектора по ее длине
     * @param length длина вектора
     */
    public void setValue(int length) {
        this.valueV = new double [length];
    }

    /**
     * Перегрузка метода saveByName - сохранить по имени переменную
     * @param nameVar Название переменной типа String
     * @return true - переменная по имени сохранена
     */
    @Override
    public boolean saveByName(String nameVar) {
        Map<String, Variable> nameVariables = MapValues.getInstance();
//        if (!nameVariables.containsKey(nameVar)) {
            nameVariables.put(nameVar, new VectorValue(this.valueV));
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
    public double[] readByName(String nameVar) {
        Map <String, Variable> nameVariables = MapValues.getInstance();
        if (nameVariables.containsKey(nameVar)) {
            return ((VectorValue) nameVariables.get(nameVar)).getValue();
        }
        return null;
    }

    /**
     * Override метода toString
     * @return Значение переменной в виде строки
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");
        int k = 0;
        for (Double v : valueV) {
            k++;
           s = s.append(v.toString());
            if (k != valueV.length) {
                s.append(",");
            } else { s.append("}"); }
        }
        return s.toString();
    }
    /**
     * Override метода преобразование значение переменной со строки в массив []
     * @param value Переданная строка
     */
    @Override
    public void setValue (String value) {
        String[] elem=value.split(",");
        valueV=new double[elem.length];
        Matcher mat= Pattern.compile(PatternsVar.regxD).matcher(value);
        int i=0;
        while (mat.find()) {
            valueV[i]=Double.parseDouble(mat.group());
            i++;
        }
    }
}
