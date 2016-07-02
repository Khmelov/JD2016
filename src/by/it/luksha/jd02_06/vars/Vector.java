package by.it.luksha.jd02_06.vars;

import by.it.luksha.jd02_06.io.Parser;

public class Vector extends Var {
    /**
     * Массив значений вектора
     */
    private double[] value;

    private int size;

    public Vector(double[] value) {
        this.value = new double[value.length];
        this.size = value.length;
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    /**
     * Конструктор преобразующий строку в объект типа Vector
     * @param vector строка
     */
    public Vector(String vector) {
        this.value = Parser.findVector(vector);
        this.size = value.length;
    }

    public int getSize() {
        return size;
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        for (int i = 0; i < this.value.length; i++) {
            System.out.printf("[%1d]=%-3.2f ",i+1, this.value[i]);
        }
        return "";
    }
}
