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

/**
 * Created by Kate Novik.
 */
public class MultiOperations implements IMultiplication {
    //Создаем массив фабрик по созданию переменных
    private CreatorVariables[] creatorVariables = {new CreatorDoubleValue(), new CreatorVectorValue(), new CreatorMatrixValue()};

    /**
     * Override метода Умножение переменных
     * @param operand1 Переменная 1
     * @param operand2 Переменная 1
     * @return Результат вычисления
     */
    public Variable multiplication(Variable operand1, Variable operand2) throws ErrorOperationsException {
        if (operand1 instanceof DoubleValue) {
            if (operand2 instanceof DoubleValue) {
                return multiplication((DoubleValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                return multiplication((DoubleValue) operand1, (VectorValue) operand2);
            } else if (operand2 instanceof MatrixValue) {
                return multiplication((DoubleValue) operand1, (MatrixValue) operand2);
            }
        } else if (operand1 instanceof VectorValue) {
            if (operand2 instanceof DoubleValue) {
                return multiplication((VectorValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                return multiplication((VectorValue) operand1, (VectorValue) operand2);
            } else if (operand2 instanceof MatrixValue) {
                System.out.println("Умножение невозможно");
            }
        } else if (operand1 instanceof MatrixValue) {
            if (operand2 instanceof DoubleValue) {
                return multiplication((MatrixValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                return multiplication((MatrixValue) operand1, (VectorValue) operand2);
            } else if (operand2 instanceof MatrixValue) {
                return multiplication((MatrixValue) operand1, (MatrixValue) operand2);
            }
        } else {
            System.out.println("Умножение невозможно");
        }
        return null;
    }

    // Перегрузки метода multiplication при различных входных переменных

    private DoubleValue multiplication(DoubleValue value1, DoubleValue value2) {
        DoubleValue mul = (DoubleValue)creatorVariables[0].createVariable();
        mul.setValue(value1.getValue() * value2.getValue());
        return mul;
    }

    private MatrixValue multiplication(DoubleValue value1, MatrixValue value2) {
        MatrixValue multi = (MatrixValue)creatorVariables[2].createVariable();
        multi.setValue(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            for (int j = 0; j < value2.getValue().length; j++) {
                multi.getValue()[i][j] = value1.getValue() * value2.getValue()[i][j];
            }
        }
        return multi;
    }

    private MatrixValue multiplication(MatrixValue value1, DoubleValue value2) {
        return multiplication(value2, value1);
    }

    private VectorValue multiplication(DoubleValue value1, VectorValue value2) {
        VectorValue multi = (VectorValue)creatorVariables[1].createVariable();
        multi.setValue(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            multi.getValue()[i] = value1.getValue() * value2.getValue()[i];
        }
        return multi;
    }

    private VectorValue multiplication(VectorValue value1, DoubleValue value2) {
        return multiplication(value2, value1);
    }

    private DoubleValue multiplication(VectorValue value1, VectorValue value2) throws ErrorOperationsException {
        DoubleValue multi = (DoubleValue)creatorVariables[0].createVariable();
        if (value1.getValue().length == value2.getValue().length) {
        double m = 0;
        for (int i = 0; i < value1.getValue().length; i++) {
            m += value1.getValue()[i] * value2.getValue()[i];
        }
        multi.setValue(m);
        }
        else {
            throw new ErrorOperationsException("Умножение невозможно. Размеры векторов не совпадают.");
        }
        return multi;
    }

    private MatrixValue multiplication(MatrixValue value1, MatrixValue value2) throws ErrorOperationsException {
        MatrixValue multi = (MatrixValue)creatorVariables[2].createVariable();
        multi.setValue(value1.getValue().length);
        if (value1.getValue().length == value2.getValue().length && value1.getValue()[0].length == value2.getValue()[0].length) {
            for (int i = 0; i < value1.getValue().length; i++) {
                for (int j = 0; j < value2.getValue()[0].length; j++) {
                    for (int k = 0; k < value2.getValue().length; k++) {
                        multi.getValue()[i][j] = multi.getValue()[i][j] + value1.getValue()[i][k] * value2.getValue()[k][j];
                    }
                }
            }
        }
        else {
            throw new ErrorOperationsException("Умножение невозможно. Размеры матриц не совпадают.");
        }
        return multi;
    }

    private VectorValue multiplication(MatrixValue value1, VectorValue value2) {
        VectorValue multi = (VectorValue)creatorVariables[1].createVariable();
        multi.setValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            for (int j = 0; j < value2.getValue().length; j++) {
                    multi.getValue()[i] = multi.getValue()[i] + value1.getValue()[i][j] * value2.getValue()[j];
            }
        }
        return multi;
    }

}
