package by.it.luksha.jd02_06;

import by.it.luksha.jd02_06.operations.Operation;
import by.it.luksha.jd02_06.vars.Matrix;
import by.it.luksha.jd02_06.vars.Scalar;
import by.it.luksha.jd02_06.vars.Vector;

public class Test {

    public static void run() {
        //Объявление переменных
        //Скаляры
        Scalar scalar1 = new Scalar(2.0);
        Scalar scalar2 = new Scalar(-2.0);
        Scalar scalar3 = new Scalar("1");
        //Векторы
        double[] vc1 = {1, 2, 3};
        Vector vector1 = new Vector(vc1);
        double[] vc2 = {1, 2, 3, 4, 5};
        Vector vector2 = new Vector(vc2);
        double[] vc3 = {1, 2, 3};
        Vector vector3 = new Vector(vc3);
        //Матрицы
        double[][] arrayMatrix3x3 = {{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 9}};
        double[][] arrayMatrix3x2 = {{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 9}};
        double[][] arrayMatrix4x5 = {{1, 2, 3, 4, 5},
                                     {6, 7, 8, 9, 0},
                                     {1, 2, 3, 4, 5},
                                     {6, 7, 8, 9, 0}};
        Matrix matrix3x3 = new Matrix(arrayMatrix3x3);
        Matrix matrix3x2 = new Matrix(arrayMatrix3x2);
        Matrix matrix4x5 = new Matrix(arrayMatrix4x5);

        //Операции с Var
        System.out.println("Сложение скаляра с Var");
        System.out.println("Скаляр+скаляр:");
        System.out.println(Operation.add(scalar1, scalar2));
        System.out.println("Скаляр+вектор:");
        System.out.println(Operation.add(scalar1, vector1));
        System.out.println("Скаляр+матрица:");
        System.out.println(Operation.add(scalar2, matrix3x3));

        System.out.println("Сложение вектора с Var");
        System.out.println("Вектор+скаляр:");
        System.out.println(Operation.add(vector1, scalar1));
        System.out.println("Вектор+вектор:");
        System.out.println(Operation.add(vector1, vector2));
        System.out.println("Вектор+вектор:");
        System.out.println(Operation.add(vector1, vector3));
        System.out.println("Вектор+матрица:");
        System.out.println(Operation.add(vector3, matrix3x2));
        System.out.println("Вектор+матрица:");
        System.out.println(Operation.add(vector3, matrix4x5));

        System.out.println("Сложение матрицы с Var");
        System.out.println("Матрица+скаляр:");
        System.out.println(Operation.add(matrix3x3, scalar1));
        System.out.println("Матрица+вектор:");
        System.out.println(Operation.add(matrix3x2, vector3));
        System.out.println("Матрица+вектор:");
        System.out.println(Operation.add(matrix4x5, vector3));
        System.out.println("Матрица+матрица:");
        System.out.println(Operation.add(matrix3x3, matrix3x2));
        System.out.println("Матрица+матрица:");
        System.out.println(Operation.add(matrix3x3, matrix4x5));


        System.out.println("Умножение скаляра с Var");
        System.out.println("Скаляр*скаляр:");
        System.out.println(Operation.mult(scalar1, scalar2));
        System.out.println("Скаляр*вектор:");
        System.out.println(Operation.mult(scalar1, vector1));
        System.out.println("Скаляр*матрица:");
        System.out.println(Operation.mult(scalar3, matrix3x3));

        System.out.println("Умножение вектора с Var");
        System.out.println("Вектор*скаляр:");
        System.out.println(Operation.mult(vector1, scalar1));
        System.out.println("Вектор*вектор:");
        System.out.println(Operation.mult(vector1, vector2));
        System.out.println("Вектор*вектор:");
        System.out.println(Operation.mult(vector1, vector3));
        System.out.println("Вектор*матрица:");
        System.out.println(Operation.mult(vector3, matrix3x2));
        System.out.println("Вектор*матрица:");
        System.out.println(Operation.mult(vector3, matrix4x5));

        System.out.println("Умножение матрицы с Var");
        System.out.println("Матрица*скаляр:");
        System.out.println(Operation.mult(matrix3x3, scalar1));
        System.out.println("Матрица*вектор:");
        System.out.println(Operation.mult(matrix3x2, vector3));
        System.out.println("Матрица*вектор:");
        System.out.println(Operation.mult(matrix4x5, vector3));
        System.out.println("Матрица*матрица:");
        System.out.println(Operation.mult(matrix3x3, matrix3x2));
        System.out.println("Матрица*матрица:");
        System.out.println(Operation.mult(matrix3x3, matrix4x5));
    }
}
