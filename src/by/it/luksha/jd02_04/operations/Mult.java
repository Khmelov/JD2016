package by.it.luksha.jd02_04.operations;

import by.it.luksha.jd02_04.vars.Matrix;
import by.it.luksha.jd02_04.vars.Scalar;
import by.it.luksha.jd02_04.vars.Var;
import by.it.luksha.jd02_04.vars.Vector;

public final class Mult {

    private Mult() {
    }

    public static Var mult(Var var1, Var var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    /**
     * Умножает скаляр на скаляр
     * @param var1 множитель-скаляр
     * @param var2 множитель-скаляр
     * @return произведение-скаляр
     */
    public static Scalar mult(Scalar var1, Scalar var2) {
        return new Scalar(var1.getValue() * var2.getValue());
    }

    /**
     * Умножает скаляр на вектор
     * @param var1 множитель-скаляр
     * @param var2 множитель-вектор
     * @return произведение-скаляр
     */
    public static Vector mult(Scalar var1, Vector var2) {
        int sizeVector = var2.getValue().length;
        double[] result = new double[sizeVector];
        for (int i = 0; i < sizeVector; i++) {
            result[i] = var2.getValue()[i] * var1.getValue();
        }
        return new Vector(result);
    }

    /**
     * Умножает скаляр на матрицу
     * @param var1 множитель-скаляр
     * @param var2 множитель-матрица
     * @return произведение-матрица
     */
    public static Matrix mult(Scalar var1, Matrix var2) {
        double[][] result = new double[var2.getRow()][var2.getCol()];
        for (int i = 0; i < var2.getRow(); i++) {
            for (int j = 0; j < var2.getCol(); j++) {
                result[i][j] = var2.getValue()[i][j] * var1.getValue();
            }
        }
        return new Matrix(result);
    }


    /**
     * Умножает вектор на скаляр
     * @param var1 вектор
     * @param var2 скаляр
     * @return произведение-вектор
     */
    public static Vector mult(Vector var1, Scalar var2) {
        return mult(var2, var1);
    }

    /**
     * Скалярно умножает вектор на вектор
     * @param var1 вектор
     * @param var2 вектор
     * @return произведение скаляр
     */
    public static Scalar mult(Vector var1, Vector var2) {
        if (var1.getSize() == var2.getSize()) {
            double result = 0;
            for (int i = 0; i < var1.getSize(); i++) {
                result += var1.getValue()[i] * var2.getValue()[i];
            }
            return new Scalar(result);
        }
        else {
            System.out.println("Операция невозможна! Вектора несоразмерны.");
            return null;
        }
    }

    /**
     * Умножение вектор-столбца на матрицу (невозможно, можно реализовать для вектор-строки)
     * @param var1 вектор
     * @param var2 матрица
     * @return произведение
     */
    public static Var mult(Vector var1, Matrix var2) {
        System.out.println("Операция невозможна!");
        return null;
    }

    /**
     * Умножает матрицу на скаляр
     * @param var1 матрица
     * @param var2 скаляр
     * @return произведение-матрица
     */
    public static Matrix mult(Matrix var1, Scalar var2) {
        return mult(var2, var1);
    }

    /**
     * Умножает матрицу на вектор-столбец
     * @param var1 матрица
     * @param var2 вектор-столбец
     * @return произведение-вектор
     */
    public static Vector mult(Matrix var2, Vector var1) {
        if (var1.getSize() == var2.getCol()) {
            double[] result = new double[var2.getRow()];
            for (int i = 0; i < var2.getRow(); i++) {
                //скалярное произведение i-той строки на вектор-столбец
                result[i] = mult(new Vector(var1.getValue()), new Vector(var2.getValue()[i])).getValue();
            }
            return new Vector(result);
        }
        else {
            System.out.println("Операция невозможна! Вектор-столбец и матрица несоразмерны.");
            return null;
        }
    }

    /**
     * Умножает матрицу на матрицу
     * @param var1 матрица-множитель
     * @param var2 матрица-множитель
     * @return произведение-матрица
     */
    public static Matrix mult(Matrix var1, Matrix var2) {
        if (var1.getCol() == var2.getRow()) {
            double[][] result = new double[var1.getRow()][var2.getCol()];
            for (int i = 0; i < var1.getRow(); i++) {
                for (int j = 0; j < var2.getCol(); j++) {
                    //формирует столбец второго множителя-матрицы
                    double[] colJ = new double[var2.getRow()];
                    for (int k = 0; k < var2.getRow(); k++) {
                        colJ[k] = var2.getValue()[k][j];
                    }
                    //скалярное произведение i-той строки первого множителя-матрицы, на j-тый столбец второго множителя-матрицы
                    result[i][j] = mult(new Vector(var1.getValue()[i]), new Vector(colJ)).getValue();
                }
            }
            return new Matrix(result);
        }
        else {
            System.out.println("Операция невозможна! Кол-во столбцов первого множителя не равно кол-ву строк второго множителя.");
            return null;
        }
    }
}
