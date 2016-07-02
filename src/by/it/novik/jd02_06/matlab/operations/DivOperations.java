package by.it.novik.jd02_06.matlab.operations;

import by.it.novik.jd02_06.matlab.creator.CreatorDoubleValue;
import by.it.novik.jd02_06.matlab.creator.CreatorMatrixValue;
import by.it.novik.jd02_06.matlab.creator.CreatorVariables;
import by.it.novik.jd02_06.matlab.creator.CreatorVectorValue;
import by.it.novik.jd02_06.matlab.entity.DoubleValue;
import by.it.novik.jd02_06.matlab.entity.MatrixValue;
import by.it.novik.jd02_06.matlab.entity.Variable;
import by.it.novik.jd02_06.matlab.entity.VectorValue;
import by.it.novik.jd02_06.matlab.exceptions.ErrorOperationsException;
import by.it.novik.jd02_06.matlab.log.Logger;
import by.it.novik.jd02_06.matlab.utils.InverseMatrix;

/**
 * Created by Kate Novik.
 */
public class DivOperations implements IDivision {
    //Создаем массив фабрик по созданию переменных
    private CreatorVariables[] creatorVariables = {new CreatorDoubleValue(), new CreatorVectorValue(), new CreatorMatrixValue()};

    /**
     * Override метода Деление переменных
     * @param operand1 Переменная 1
     * @param operand2 Переменная 2
     * @return Результат вычисления
     */
    public Variable division(Variable operand1, Variable operand2) throws ErrorOperationsException {

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
        DoubleValue div = (DoubleValue) creatorVariables[0].createVariable();
            if (valueTwo.getValue() != 0) {
            div.setValue(valueOne.getValue() / valueTwo.getValue()); }
            else {
                throw new ErrorOperationsException("Division on null!");
            }
        return div;
    }

    private MatrixValue division(MatrixValue valueOne, DoubleValue valueTwo) throws ErrorOperationsException {
        DoubleValue var = (DoubleValue) creatorVariables[0].createVariable();
        var.setValue(1);
        return (MatrixValue)new MultiOperations().multiplication(division(var, valueTwo), valueOne);
    }

    private MatrixValue division(MatrixValue valueOne, MatrixValue valueTwo) throws ErrorOperationsException {
        MatrixValue var = (MatrixValue)creatorVariables[2].createVariable();
        var.setValue(InverseMatrix.inverseMatrix(valueTwo.getValue()));
        return (MatrixValue)new MultiOperations().multiplication(valueOne, var);
    }

    private VectorValue division(VectorValue value1, DoubleValue value2) {
        VectorValue div = (VectorValue) creatorVariables[1].createVariable();
        div.setValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            div.getValue() [i] = value1.getValue()[i] / value2.getValue();
        }
        return div;
    }
}
