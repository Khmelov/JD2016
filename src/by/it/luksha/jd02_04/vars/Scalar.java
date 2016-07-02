package by.it.luksha.jd02_04.vars;

import java.util.Locale;

public class Scalar extends Var {
    /**
     * Значение скаляра
     */
    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    /**
     * Конструктор преобразующий строку в объект типа Scalar
     * @param scalar строка
     */
    public Scalar(String scalar) {
        this.value = Double.valueOf(scalar);
    }

    /**
     * Проверяет можно ли по строке создать скаляр
     * @param line строка
     * @return true/false
     */
    public static boolean isScalar(String line) {
        try {
            new Scalar(line);
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%.1f", value);
    }
}
