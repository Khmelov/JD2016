package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.exceptions.MathLabException;
import by.it.sinkevich.jd01_09.variables.*;

/**
 * Created by Computer on 19.05.2016.
 *
 * @author Sinkevich Denis
 */
class MultiplicationMethodContainer {

    private static VariableFactory[] factories = new VariableFactory[]
            {new MathLabFloatFactory(), new MathLabVectorFactory(), new MathLabMatrixFactory()};

    static MathLabVariable multiplication(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        Double res = aFloat1.getValue() * aFloat2.getValue();
        MathLabVariable result = factories[0].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable multiplication(MathLabFloat aFloat, MathLabVector vector) {
        return multiplication(vector, aFloat);
    }

    static MathLabVariable multiplication(MathLabFloat aFloat, MathLabMatrix matrix) {
        return multiplication(matrix, aFloat);
    }

    static MathLabVariable multiplication(MathLabVector vector, MathLabFloat aFloat) {
        Double[] res = vector.getValue();
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] * aFloat.getValue();
        }
        MathLabVariable result = factories[1].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable multiplication(MathLabVector vector1, MathLabVector vector2) throws MathLabException {
        if (vector1.getSize() != vector2.getSize()) {
            throw new MathLabException("Недопустимый размер векторов! Умножать можно только векторы одинаковой длины!");
        }
        Double[] array1 = vector1.getValue();
        Double[] array2 = vector2.getValue();
        Double res = 0d;
        for (int i = 0; i < array1.length; i++) {
            res += array1[i] * array2[i];
        }
        MathLabVariable result = factories[0].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable multiplication(MathLabVector vector, MathLabMatrix matrix) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Умножение вектора на матрицу невозможно!");
    }

    static MathLabVariable multiplication(MathLabMatrix matrix, MathLabFloat aFloat) {
        Double[][] res = matrix.getValue();
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[row].length; col++) {
                res[row][col] *= aFloat.getValue();
            }
        }
        MathLabVariable result = factories[2].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable multiplication(MathLabMatrix matrix, MathLabVector vector) throws MathLabException {
        if (matrix.getColumns() != vector.getSize()) {
            throw new MathLabException("Недопустимый размер матрицы и вектора! Умножать матрицу на вектор-столбец справа " +
                    "только если количество столбцов матрицы равно длине вектора!");
        }
        Double[][] tempMatrix = matrix.getValue();
        Double[] tempVector = vector.getValue();
        Double[] res = new Double[tempMatrix.length];
        for (int row = 0; row < tempMatrix.length; row++) {
            res[row] = 0d;
            for (int col = 0; col < tempVector.length; col++) {
                res[row] += tempMatrix[row][col] * tempVector[col];
            }
        }
        MathLabVariable result = factories[1].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable multiplication(MathLabMatrix matrix1, MathLabMatrix matrix2) throws MathLabException {
        if (matrix1.getColumns() != matrix2.getRows()) {
            throw new MathLabException("Недопустимый размер матриц! Умножать матрицу на матрицу можно только если " +
                    "количество столбцов матрицы слева равно количеству строк матрицы справа!");
        }
        Double[][] temp1 = matrix1.getValue();
        Double[][] temp2 = matrix2.getValue();
        Double[][] res = new Double[matrix1.getRows()][matrix2.getColumns()];
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[0].length; col++) {
                res[row][col] = 0d;
                for (int inside = 0; inside < temp2.length; inside++) {
                    res[row][col] += temp1[row][inside] * temp2[inside][col];
                }
            }
        }
        MathLabVariable result = factories[2].getVariable();
        result.setValue(res);
        return result;
    }
}
