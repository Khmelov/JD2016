package by.it.luksha.jd02_04.operations;

import by.it.luksha.jd02_04.vars.Matrix;
import by.it.luksha.jd02_04.vars.Scalar;
import by.it.luksha.jd02_04.vars.Var;
import by.it.luksha.jd02_04.vars.Vector;

public final class Div {

    private Div() {
    }

    public static Var div(Var var1, Var var2) {
        System.out.println("Операция невозможна.");
        return  null;
    }

    /**
     * Делит скаляр на скаляр
     * @param var1 делимое-скаляр
     * @param var2 делить-скаляр
     * @return частное-скаляр
     */
    public static Scalar div(Scalar var1, Scalar var2) {
        return new Scalar(var1.getValue() / var2.getValue());
    }

    public static Var div(Scalar var1, Vector var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    public static Var div(Scalar var1, Matrix var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    /**
     * Делит вектор на скаляр
     * @param var1 вектор
     * @param var2 скаляр
     * @return частное-вектор
     */
    public static Vector div(Vector var1, Scalar var2) {
        int sizeVector = var1.getValue().length;
        double[] result = new double[sizeVector];
        for (int i = 0; i < sizeVector; i++) {
            result[i] = var1.getValue()[i] / var2.getValue();
        }
        return new Vector(result);
    }

    /**
     * Делит вектор на вектор
     * @param var1
     * @param var2
     */
    public static Var div(Vector var1, Vector var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    /**
     * Делит вектор на матрицу
     * @param var1
     * @param var2
     */
    public static Var div(Vector var1, Matrix var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    /**
     * Делит матрицу на скаляр
     * @param var1 матрица-делимое
     * @param var2 скаляр-делитель
     * @return матрица-частное
     */
    public static Matrix div(Matrix var1, Scalar var2) {
        double[][] result = new double[var1.getRow()][var1.getCol()];
        for (int i = 0; i < var1.getRow(); i++) {
            for (int j = 0; j < var1.getCol(); j++) {
                result[i][j] = var1.getValue()[i][j] / var2.getValue();
            }
        }
        return new Matrix(result);
    }

    public static Var div(Matrix var1, Vector var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    public static Var div(Matrix var1, Matrix var2) {
        System.out.println("Операция невозможна.");
        return null;
    }
}
