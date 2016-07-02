package by.it.sinkevich.jd01_09.variables;

import by.it.sinkevich.jd01_09.parser.Patterns;

import java.util.Locale;

/**
 * Этот класс описывает переменную Матлаб типа скаляр. Представляется в виде числа с дробной частью,
 * целые числа переводятся в дробные. Содердит основные методы для создания этой переменной,
 * перевода в строку и обратно, получения её значения
 *
 * @author Sinkevich Denis
 */
public class MathLabFloat extends MathLabVariable {

    /**
     * Поле, в котором хранится текущее значение переменной
     */
    private Double value;

    /**
     * Конструкторы
     */
    public MathLabFloat() {
        value = 0.0;
    }

    public MathLabFloat(Double value) {
        this.value = value;
    }

    public MathLabFloat(String value) {
        this.value = Double.valueOf(value);
    }

    public MathLabFloat(MathLabFloat value) {
        this.value = value.getValue();
    }

    /**
     * Возвращает текущее значение переменной
     *
     * @return значение переменной типа {@code Double}
     */
    @Override
    public Double getValue() {
        return value;
    }

    /**
     * Устанавливает значение переменной равным по модулю числу, приходящему в качестве аргумента метода,
     * но приводит тип к {@code Double}
     *
     * @param value новое значение переменной, тип {@code Number}
     */
    @Override
    public void setValue(Object value) {
        if (value instanceof Double) {
            this.value = (Double) value;
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
        if (strFrom.trim().matches(Patterns.regexFloat)) {
            value = Double.valueOf(strFrom);
        } else {
            System.out.println("Запись числа невозможна!");
        }
    }

    /**
     * Метод возвращает текстовое представление переменной типа {@code String}
     *
     * @return текстовое представление переменной
     */
    @Override
    public String toString() {
        return String.format(Locale.US, "% 9.2f", value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MathLabFloat that = (MathLabFloat) o;

        return value - that.getValue() < 0.00001;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

}
