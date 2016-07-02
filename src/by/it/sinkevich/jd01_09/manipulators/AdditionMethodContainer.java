package by.it.sinkevich.jd01_09.manipulators;


import by.it.sinkevich.jd01_09.exceptions.MathLabException;
import by.it.sinkevich.jd01_09.variables.*;

/**
 * @author Sinkevich Denis
 */
class AdditionMethodContainer {

    private static VariableFactory[] factories = new VariableFactory[]
            {new MathLabFloatFactory(), new MathLabVectorFactory(), new MathLabMatrixFactory()};

    static MathLabVariable addition(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        Double res = aFloat1.getValue() + aFloat2.getValue();
        MathLabVariable result = factories[0].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable addition(MathLabFloat aFloat, MathLabVector vector) {
        return addition(vector, aFloat);
    }

    static MathLabVariable addition(MathLabFloat aFloat, MathLabMatrix matrix) {
        return addition(matrix, aFloat);
    }

    static MathLabVariable addition(MathLabVector vector, MathLabFloat aFloat) {
        Double[] res = vector.getValue();
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] + aFloat.getValue();
        }
        MathLabVariable result = factories[1].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable addition(MathLabVector vector1, MathLabVector vector2) throws MathLabException {
        if (vector1.getSize() != vector2.getSize()) {
            throw new MathLabException("Недопустимый размер векторов! Складывать можно только векторы одинаковой длины!");
        }
        Double[] array1 = vector1.getValue();
        Double[] array2 = vector2.getValue();
        Double[] res = new Double[array1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array1[i] + array2[i];
        }
        MathLabVariable result = factories[1].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable addition(MathLabVector vector, MathLabMatrix matrix) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Сложение вектора и матрицы невозможно!");
    }

    static MathLabVariable addition(MathLabMatrix matrix, MathLabFloat aFloat) {
        Double[][] res = matrix.getValue();
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[row].length; col++) {
                res[row][col] += aFloat.getValue();
            }
        }
        MathLabVariable result = factories[2].getVariable();
        result.setValue(res);
        return result;
    }

    static MathLabVariable addition(MathLabMatrix matrix, MathLabVector vector) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Сложение матрицы и вектора невозможно!");
    }

    static MathLabVariable addition(MathLabMatrix matrix1, MathLabMatrix matrix2) throws MathLabException {
        if (matrix1.getRows() != matrix2.getRows() || matrix1.getColumns() != matrix2.getColumns()) {
            throw new MathLabException("Недопустимый размер матриц! Складывать можно только матрицы одинакового размера!");
        }
        Double[][] temp1 = matrix1.getValue();
        Double[][] temp2 = matrix2.getValue();
        Double[][] res = new Double[temp1.length][temp1[0].length];
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[row].length; col++) {
                res[row][col] = temp1[row][col] + temp2[row][col];
            }
        }
        MathLabVariable result = factories[2].getVariable();
        result.setValue(res);
        return result;
    }
}
