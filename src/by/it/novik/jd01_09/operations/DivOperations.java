package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.entity.MatrixValue;
import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.entity.VectorValue;
import by.it.novik.jd01_09.exceptions.ErrorOperationsException;
import by.it.novik.jd01_09.utils.InverseMatrix;

/**
 * Created by Kate Novik.
 */
public class DivOperations implements IDivision{

    /**
     * Override метода Деление переменных
     * @param operand1 Переменная 1
     * @param operand2 Переменная 2
     * @return Результат вычисления
     */
    public Variable division(Variable operand1, Variable operand2) throws ErrorOperationsException{

        if (operand1 instanceof DoubleValue) {
            if (operand2 instanceof DoubleValue) {
                return division((DoubleValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                System.out.println("Деление невозможно");
            } else if (operand2 instanceof MatrixValue) {
                System.out.println("Деление невозможно");
            }
        } else if (operand1 instanceof VectorValue) {
            if (operand2 instanceof DoubleValue) {
                return division((VectorValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                System.out.println("Деление невозможно");
            } else if (operand2 instanceof MatrixValue) {
                System.out.println("Деление невозможно");
            }
        } else if (operand1 instanceof MatrixValue) {
            if (operand2 instanceof DoubleValue) {
                return division((MatrixValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                System.out.println("Деление невозможно");
            } else if (operand2 instanceof MatrixValue) {
                return division((MatrixValue) operand1, (MatrixValue) operand2);
            }
        } else {
            System.out.println("Деление невозможно");
        }
        return null;
    }

    //Перегрузки метода division при различных входных переменных

    private DoubleValue division(DoubleValue valueOne, DoubleValue valueTwo) throws ErrorOperationsException {
        DoubleValue div = new DoubleValue();
            if (valueTwo.getValue() != 0) {
            div.setValue(valueOne.getValue() / valueTwo.getValue()); }
            else {
                throw new ErrorOperationsException("Division on null!");
            }
        return div;
    }

    private MatrixValue division(MatrixValue valueOne, DoubleValue valueTwo) throws ErrorOperationsException {
        return (MatrixValue)new MultiOperations().multiplication(division(new DoubleValue(1), valueTwo), valueOne);
    }

    private MatrixValue division(MatrixValue valueOne, MatrixValue valueTwo) throws ErrorOperationsException {
        return (MatrixValue)new MultiOperations().multiplication(valueOne, new MatrixValue(InverseMatrix.inverseMatrix(valueTwo.getValue())));
    }

    private VectorValue division(VectorValue value1, DoubleValue value2) {
        VectorValue div = new VectorValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            div.getValue() [i] = value1.getValue()[i] / value2.getValue();
        }
        return div;
    }
}
