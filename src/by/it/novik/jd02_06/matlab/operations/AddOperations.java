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
import by.it.novik.jd02_06.matlab.operations.*;

/**
 * Created by Kate Novik.
 */
public class AddOperations implements IAddition {
    //Создаем массив фабрик по созданию переменных
    private CreatorVariables[] creatorVariables = {new CreatorDoubleValue(), new CreatorVectorValue(), new CreatorMatrixValue()};


    /**
     * Override метода Сложение переменных
     *
     * @param operand1 Переменная 1
     * @param operand2 Переменная 1
     * @return Результат вычисления
     */
    @Override
    public Variable addition(Variable operand1, Variable operand2) throws ErrorOperationsException {

        if (operand1 instanceof DoubleValue) {
            if (operand2 instanceof DoubleValue) {
                return addition((DoubleValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                return addition((DoubleValue) operand1, (VectorValue) operand2);
            } else if (operand2 instanceof MatrixValue) {
                return addition((DoubleValue) operand1, (MatrixValue) operand2);
            }
        } else if (operand1 instanceof VectorValue) {
            if (operand2 instanceof DoubleValue) {
                return addition((VectorValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                return addition((VectorValue) operand1, (VectorValue) operand2);
            } else if (operand2 instanceof MatrixValue) {
                System.out.println("Сложение невозможно");
            }
        } else if (operand1 instanceof MatrixValue) {
            if (operand2 instanceof DoubleValue) {
                return addition((MatrixValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                System.out.println("Сложение невозможно");
            } else if (operand2 instanceof MatrixValue) {
                return addition((MatrixValue) operand1, (MatrixValue) operand2);
            }
        } else {
            System.out.println("Сложение невозможно");
        }
        return null;
    }

    //Перегрузки метода addition при различных входных переменных

    private DoubleValue addition(DoubleValue value1, DoubleValue value2) {
        DoubleValue add = (DoubleValue)creatorVariables[0].createVariable();
        add.setValue(value1.getValue() + value2.getValue());
        return add;
    }

    private MatrixValue addition(DoubleValue value1, MatrixValue value2) {
        MatrixValue add = (MatrixValue)creatorVariables[2].createVariable();
        add.setValue(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            for (int j = 0; j < value2.getValue().length; j++) {
                add.getValue()[i][j] = value1.getValue() + value2.getValue()[i][j];
            }
        }
        return add;
    }

    private MatrixValue addition(MatrixValue value1, DoubleValue value2) {
        return addition(value2, value1);
    }

    private VectorValue addition(DoubleValue value1, VectorValue value2) {
        VectorValue add = (VectorValue)creatorVariables[1].createVariable();
        add.setValue(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
           add.getValue()[i] = value1.getValue() + value2.getValue()[i];
        }
        return add;
    }

    private VectorValue addition(VectorValue value1, DoubleValue value2) {
        return addition(value2, value1);
    }

    private VectorValue addition(VectorValue value1, VectorValue value2) throws ErrorOperationsException {
        VectorValue add = (VectorValue)creatorVariables[1].createVariable();
        add.setValue(value1.getValue().length);
        if (value1.getValue().length == value2.getValue().length) {
            for (int i = 0; i < value1.getValue().length; i++) {
                add.getValue()[i] = value1.getValue()[i] + value2.getValue()[i];
            }
        }
        else {
            throw new ErrorOperationsException("Сложение невозможно. Размеры векторов не совпадают.");
        }
        return add;
    }

    private MatrixValue addition(MatrixValue value1, MatrixValue value2) throws ErrorOperationsException {
        MatrixValue add = (MatrixValue)creatorVariables[2].createVariable();
        add.setValue(value1.getValue().length);
        if (value1.getValue().length == value2.getValue().length && value1.getValue()[0].length == value2.getValue()[0].length) {
            for (int i = 0; i < value1.getValue().length; i++) {
                for (int j = 0; j < value1.getValue().length; j++) {
                    add.getValue()[i][j] = value1.getValue()[i][j] + value2.getValue()[i][j];
                }
            }
        }
        else {
            throw new ErrorOperationsException("Сложение невозможно. Размеры матриц не совпадают.");
        }
        return add;
    }
}
