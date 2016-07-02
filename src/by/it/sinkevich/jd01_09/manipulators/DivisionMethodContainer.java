package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.exceptions.MathLabException;
import by.it.sinkevich.jd01_09.variables.*;

/**
 * Created by Computer on 19.05.2016.
 *
 * @author Sinkevich Denis
 */
class DivisionMethodContainer {

    private static VariableFactory[] factories = new VariableFactory[]
            {new MathLabFloatFactory(), new MathLabVectorFactory(), new MathLabMatrixFactory()};

    static MathLabVariable division(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        Double res = aFloat1.getValue() / aFloat2.getValue();
        MathLabVariable result = factories[0].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable division(MathLabFloat aFloat, MathLabVector vector) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Деление числа на вектор невозможно!");
    }

    static MathLabVariable division(MathLabFloat aFloat, MathLabMatrix matrix) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Деление числа на матрицу невозможно!");
    }

    static MathLabVariable division(MathLabVector vector, MathLabFloat aFloat) {
        Double[] res = vector.getValue();
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] / aFloat.getValue();
        }
        MathLabVariable result = factories[1].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable division(MathLabVector vector1, MathLabVector vector2) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Деление вектора на вектор невозможно!");
    }

    static MathLabVariable division(MathLabVector vector, MathLabMatrix matrix) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Деление вектора на матрицу невозможно!");
    }

    static MathLabVariable division(MathLabMatrix matrix, MathLabFloat aFloat) {
        Double[][] res = matrix.getValue();
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[row].length; col++) {
                res[row][col] /= aFloat.getValue();
            }
        }
        MathLabVariable result = factories[2].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable division(MathLabMatrix matrix, MathLabVector vector) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Деление матрицы на вектор невозможно!");
    }

    static MathLabVariable division(MathLabMatrix matrix1, MathLabMatrix matrix2) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Деление матрицы на матрицу невозможно!");
    }
}
