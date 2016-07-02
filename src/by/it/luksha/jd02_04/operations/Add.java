package by.it.luksha.jd02_04.operations;

import by.it.luksha.jd02_04.vars.Matrix;
import by.it.luksha.jd02_04.vars.Scalar;
import by.it.luksha.jd02_04.vars.Var;
import by.it.luksha.jd02_04.vars.Vector;

public final class Add {

    private Add() {
    }

    public static Var add(Var var1, Var var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    /**
     * Метод выполняет операцию сложения для двух скаляров
     * @param var1 скаляр
     * @param var2 скаляр
     * @return результат-скаляр
     */
    public static Scalar add(Scalar var1, Scalar var2) {
        return new Scalar(var1.getValue() + var2.getValue());
    }

    /**
     * Метод выполняет операцию сложения для скаляра и вектора
     * @param var1 скаляр
     * @param var2 вектор
     * @return результат-вектор
     */
    public static Vector add(Scalar var1, Vector var2) {
        int sizeVector = var2.getValue().length;
        double[] result = new double[sizeVector];
        for (int i = 0; i < sizeVector; i++) {
            result[i] = var2.getValue()[i] + var1.getValue();
        }
        return new Vector(result);
    }

    /**
     * Метод выполняет операцию сложения для скаляра и матрицы
     * @param var1 скаляр
     * @param var2 матрица
     * @return результат-матрица
     */
    public static Matrix add(Scalar var1, Matrix var2) {
        double[][] result = new double[var2.getRow()][var2.getCol()];
        for (int i = 0; i < var2.getRow(); i++) {
            for (int j = 0; j < var2.getCol(); j++) {
                result[i][j] = var2.getValue()[i][j] + var1.getValue();
            }
        }
        return new Matrix(result);
    }


    /**
     * Метод выполняет операцию сложения для вектора и скаляра
     * @param var1 вектор
     * @param var2 скаляр
     * @return результат-вектор
     */
    public static Vector add(Vector var1, Scalar var2) {
        return add(var2, var1);
    }

    /**
     * Метод выполняет операцию сложения для вектора и вектора
     * @param var1 вектор
     * @param var2 вектор
     * @return результат-вектор
     */
    public static Vector add(Vector var1, Vector var2) {
        if (var1.getSize() == var2.getSize()) {
            double[] result = new double[var1.getSize()];
            for (int i = 0; i < var1.getSize(); i++) {
                result[i] = var1.getValue()[i] + var2.getValue()[i];
            }
            return new Vector(result);
        }
        else {
            System.out.println("Операция невозможна! Вектора различны по размерности.");
            return null;
        }
    }

    /**
     * Метод выполняет операцию сложения для вектора и матрицы
     * @param var1 вектор
     * @param var2 матрица
     * @return результат-матрица
     */
    public static Matrix add(Vector var1, Matrix var2) {
        if (var1.getSize() == var2.getRow()) {
            double[][] result = new double[var2.getRow()][var2.getCol()];
            for (int i = 0; i < var2.getCol(); i++) {
                for (int j = 0; j < var2.getRow(); j++) {
                    result[j][i] = var2.getValue()[j][i] + var1.getValue()[j];
                }
            }
            return new Matrix(result);
        }
        else {
            System.out.println("Операция невозможна! Вектор-столбец и матрица несоразмерны.");
            return null;
        }
    }


    /**
     * Метод выполняет операцию сложения для матрицы и скаляра
     * @param var1 матрица
     * @param var2 скаляр
     * @return результат-матрица
     */
    public static Matrix add(Matrix var1, Scalar var2) {
        return add(var2, var1);
    }

    /**
     * Метод выполняет операцию сложения для матрицы и вектора
     * @param var1 матрица
     * @param var2 вектор
     * @return результат-матрица
     */
    public static Matrix add(Matrix var1, Vector var2) {
        return add(var2, var1);
    }

    /**
     * Метод выполняет операцию сложения для матрицы и матрицы
     * @param var1 матрица
     * @param var2 матрица
     * @return результат-матрица
     */
    public static Matrix add(Matrix var1, Matrix var2) {
        if (var1.getRow() == var2.getRow() && var1.getCol() == var2.getCol()) {
            double[][] result = new double[var1.getRow()][var1.getCol()];
            for (int i = 0; i < var1.getRow(); i++) {
                for (int j = 0; j < var1.getCol(); j++) {
                    result[i][j] = var1.getValue()[i][j] + var2.getValue()[i][j];
                }
            }
            return new Matrix(result);
        }
        else {
            System.out.println("Операция невозможна! Матрицы несоразмерны.");
            return null;
        }
    }
}
