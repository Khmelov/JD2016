package by.it.novik.jd02_04.matlab.entity;

import by.it.novik.jd01_13.matlab.entity.*;
import by.it.novik.jd01_13.matlab.utils.MapValues;

import java.util.Map;

/**
 * Created by Kate Novik.
 */
public class DoubleValue extends by.it.novik.jd01_13.matlab.entity.Variable {

    // Поле значение переменной
    private double valueD;

    public DoubleValue() {
        this.valueD = 0;
    }

    public DoubleValue (double valueD) {
        this.valueD = valueD;
    }

    public DoubleValue (String valueD) {
        setValue (valueD);
    }


    /**
     * Override метода получить значение переменной
     * @return Значение переменной
     */
    @Override
    public Double getValue() {
        return this.valueD;
    }

    /**
     * Перегрузка метода setValue - установить значение поля valueV
     * @param valueD Параметр типа Double
     */
    public void setValue(Double valueD) {
        this.valueD = valueD;
    }

    /**
     * Перегрузка метода saveByName - сохранить по имени переменную
     * @param nameVar Название переменной типа String
     * @return true - переменная по имени сохранена
     */
    @Override
    public boolean saveByName(String nameVar) {
        Map <String, by.it.novik.jd01_13.matlab.entity.Variable> nameVariables = MapValues.getInstance();
        //if (!nameVariables.containsKey(nameVar)) {
        nameVariables.put(nameVar, new DoubleValue(this.valueD));
        return true;
        //}
        //return false;
    }

    /**
     * Перегрузка метода readByName - прочитать значение переменной по имени
     * @param nameVar Название переменной типа String
     * @return Значение переменной
     */
    @Override
    public Double readByName(String nameVar) {
        Map <String, by.it.novik.jd01_13.matlab.entity.Variable> nameVariables = MapValues.getInstance();
        if (nameVariables.containsKey(nameVar)) {
            return ((DoubleValue) nameVariables.get(nameVar)).getValue();
        }
        return null;
    }

    /**
     * Override метода toString
     * @return Значение переменной в виде строки
     */
    @Override
    public String toString() {
        return ((Double)valueD).toString();
    }

    /**
     * Override метода преобразование значение переменной со строки в переменную типа double
     * @param value Переданная строка
     */
    @Override
    public void setValue(String value) {
        this.valueD = Double.valueOf(value);

    }
}
