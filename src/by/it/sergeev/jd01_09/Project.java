package by.it.sergeev.jd01_09;

import by.it.sergeev.jd01_09.vars.DoubleValue;
import by.it.sergeev.jd01_09.vars.MatrixValue;
import by.it.sergeev.jd01_09.vars.Variable;
import by.it.sergeev.jd01_09.vars.VectorValue;

public class Project {
    private static void one(Variable v) {
        if (v != null) System.out.println(v);
    }
    public static void main(String[] args) {
        double a = 3.2, b = 4.8, c = 8.2, d = 1.4;

        System.out.println("\nЧисла");
        System.out.println("\nПроверка операций со скалярами");
        one(new DoubleValue(a).add(new DoubleValue(c)));
        one(new DoubleValue(b).sub(new DoubleValue(d)));
        one(new DoubleValue(a).mul(new DoubleValue(d)));
        one(new DoubleValue(c).div(new DoubleValue(a)));

        System.out.println("\nВектора");
        String vector = "{3,4,5}";
        System.out.println("\nПроверка операций с векторами справа и скалярами слева");
        one(new VectorValue(vector).add(new DoubleValue(a)));
        one(new VectorValue(vector).sub(new DoubleValue(d)));
        one(new VectorValue(vector).mul(new DoubleValue(b)));
        one(new VectorValue(vector).div(new DoubleValue(c)));

        System.out.println("\nПроверка операций со скалярами справа и векторами слева");
        one(new DoubleValue(b).add(new VectorValue(vector)));
        one(new DoubleValue(c).sub(new VectorValue(vector)));
        one(new DoubleValue(d).mul(new VectorValue(vector)));
        one(new DoubleValue(a).div(new VectorValue(vector)));

        System.out.println("\nПроверка операций с векторами");
        one(new VectorValue(vector).add(new VectorValue(vector)));
        one(new VectorValue(vector).sub(new VectorValue(vector)));
        one(new VectorValue(vector).mul(new VectorValue(vector)));
        one(new VectorValue(vector).div(new VectorValue(vector)));

        System.out.println("\nМатрицы");
        double [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("\nПроверка операций со скалярами");
        one(new MatrixValue(matrix).add(new DoubleValue(a)));
        one(new MatrixValue(matrix).sub(new DoubleValue(d)));
        one(new MatrixValue(matrix).mul(new DoubleValue(b)));
        one(new MatrixValue(matrix).div(new DoubleValue(c)));
    }
}
