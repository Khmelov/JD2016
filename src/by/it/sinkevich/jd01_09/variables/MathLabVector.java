package by.it.sinkevich.jd01_09.variables;

import by.it.sinkevich.jd01_09.parser.Patterns;

import java.util.Formatter;
import java.util.Locale;

/**
 * Этот класс описывает переменную Матлаб типа вектор. Представляется в виде чисел с дробной частью,
 * разделённых запятой. Соответсвует математически вектору-столбцуу. Содердит основные методы для создания этой переменной,
 * перевода в строку и обратно, получения её значения
 *
 * @author Sinkevich Denis
 */
public class MathLabVector extends MathLabVariable {
    /**
     * Поле, в котором хранится текущее значение переменной, вектор-столбец представлен одномерным массивом чисел
     */
    private Double[] value;

    /**
     * Конструкторы
     */
    public MathLabVector() {
        value = new Double[5];
    }

    public MathLabVector(int size) {
        if (size > 0) {
            value = new Double[size];
        } else {
            System.out.println("Размерность вектора меньше нуля");
        }
    }

    public MathLabVector(Double[] value) {
        this.value = new Double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    public MathLabVector(String vector) {
        setValue(vector);
    }

    public MathLabVector(MathLabVector vector) {
        value = new Double[vector.value.length];
        System.arraycopy(vector.value, 0, value, 0, vector.value.length);
    }

    /**
     * Возвращает текущую длину вектора
     *
     * @return длина вектора типа {@code int}
     */
    public int getSize() {
        return value.length;
    }

    /**
     * Возвращает текущее значение вектора
     *
     * @return значение веткора типа {@code Double}
     */
    @Override
    public Double[] getValue() {
        return value.clone();
    }

    /**
     * Устанавливает значение вектора в заданную аргументом величину
     *
     * @param value значение типа {@code Object}, которое можно привести к типу {@code Double}
     */
    @Override
    public void setValue(Object value) {
        if (value instanceof Double[]) {
            Double[] temp = (Double[]) value;
            this.value = new Double[temp.length];
            System.arraycopy(temp, 0, this.value, 0, temp.length);
        } else {
            System.out.println("Запись значения невозможна!");
        }
    }

    /**
     * Устанавливает новое значение переменной, переводя её из текстового представления
     *
     * @param strFrom Текстовое представление переменной
     */
    @Override
    public void setValue(String strFrom) {
        if (!strFrom.trim().matches(Patterns.regexVector)) {
            System.out.println("Запись значения невозможна");
            return;
        }
        String replaced = strFrom.replaceAll("[\\}\\{,]", " ");
        String[] valuesStr = replaced.trim().split(" +");
        value = new Double[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            value[i] = Double.parseDouble(valuesStr[i]);
        }
    }

    /**
     * Метод возвращает текстовое представление вектора
     *
     * @return текстовое представление переменной типа {@code String}
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        Formatter formatter = new Formatter(stringBuilder, Locale.US);
        for (int i = 0; i < value.length; i++) {
            if (i != value.length - 1) {
                formatter.format("% 9.2f,", value[i]);
            } else {
                formatter.format("% 9.2f}", value[i]);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MathLabVector that = (MathLabVector) o;

        if (getSize() != that.getSize()) return false;

        boolean isEqual = true;
        Double[] thatValue = that.getValue();
        for (int i = 0; i < value.length; i++) {
            isEqual = value[i] - thatValue[i] < 0.00001;
            if (!isEqual) {
                break;
            }
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
