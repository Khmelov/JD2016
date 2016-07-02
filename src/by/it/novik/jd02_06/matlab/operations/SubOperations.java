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
public class SubOperations implements ISubtraction {
    //Создаем массив фабрик по созданию переменных
    private CreatorVariables[] creatorVariables = {new CreatorDoubleValue(), new CreatorVectorValue(), new CreatorMatrixValue()};

    /**
     * Override метода Вычитание переменных
     * @param operand1 Переменная 1
     * @param operand2 Переменная 1
     * @return Результат вычисления
     */
    public Variable subtraction(Variable operand1, Variable operand2) throws ErrorOperationsException {
        if (operand1 instanceof DoubleValue) {
            if (operand2 instanceof DoubleValue) {
                return subtraction((DoubleValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                return subtraction((DoubleValue) operand1, (VectorValue) operand2);
            } else if (operand2 instanceof MatrixValue) {
                return subtraction((DoubleValue) operand1, (MatrixValue) operand2);
            }
        } else if (operand1 instanceof VectorValue) {
            if (operand2 instanceof DoubleValue) {
                return subtraction((VectorValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                return subtraction((VectorValue) operand1, (VectorValue) operand2);
            } else if (operand2 instanceof MatrixValue) {
                System.out.println("Вычитание невозможно");
            }
        } else if (operand1 instanceof MatrixValue) {
            if (operand2 instanceof DoubleValue) {
                return subtraction((MatrixValue) operand1, (DoubleValue) operand2);
            } else if (operand2 instanceof VectorValue) {
                System.out.println("Вычитание невозможно");
            } else if (operand2 instanceof MatrixValue) {
                return subtraction((MatrixValue) operand1, (MatrixValue) operand2);
            }
        } else {
            System.out.println("Вычитание невозможно");
        }
        return null;
    }

    // Перегрузки метода subtraction при различных входных переменных

    private DoubleValue subtraction(DoubleValue value1, DoubleValue value2) {
        DoubleValue sub = (DoubleValue)creatorVariables[0].createVariable();
        sub.setValue(value1.getValue() - value2.getValue());
        return sub;
    }

    private MatrixValue subtraction(MatrixValue value1, DoubleValue value2) {
        MatrixValue sub = (MatrixValue)creatorVariables[2].createVariable();
        sub.setValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            for (int j = 0; j < value1.getValue().length; j++) {
                sub.getValue()[i][j] = value1.getValue()[i][j] - value2.getValue();
            }
        }
        return sub;
    }
    private MatrixValue subtraction(DoubleValue value1, MatrixValue value2) throws ErrorOperationsException {
        DoubleValue var = (DoubleValue)creatorVariables[0].createVariable();
        var.setValue(-1);
        return (MatrixValue)new AddOperations().addition(value1, new MultiOperations().multiplication(var, value2));
    }

    private VectorValue subtraction(VectorValue value1, DoubleValue value2) {
        VectorValue sub = (VectorValue)creatorVariables[1].createVariable();
        sub.setValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            sub.getValue()[i] = value1.getValue()[i] - value2.getValue();
        }
        return sub;
    }

    private VectorValue subtraction(DoubleValue value1, VectorValue value2) throws ErrorOperationsException {
        DoubleValue var = (DoubleValue)creatorVariables[0].createVariable();
        var.setValue(-1);
        return (VectorValue)new AddOperations().addition(value1, new MultiOperations().multiplication(var, value2));
    }

    private VectorValue subtraction(VectorValue value1, VectorValue value2) throws ErrorOperationsException {
        VectorValue sub = (VectorValue)creatorVariables[1].createVariable();
        sub.setValue(value1.getValue().length);
        if (value1.getValue().length == value2.getValue().length) {
            for (int i = 0; i < value1.getValue().length; i++) {
                sub.getValue()[i] = value1.getValue()[i] - value2.getValue()[i];
            }
        }
        else {
            throw new ErrorOperationsException("Вычитание невозможно! Разные размеры векторов!");
        }
        return sub;
    }

    private MatrixValue subtraction(MatrixValue value1, MatrixValue value2) throws ErrorOperationsException {
        MatrixValue sub = (MatrixValue)creatorVariables[2].createVariable();
        sub.setValue(value1.getValue().length);
        if (value1.getValue().length == value2.getValue().length && value1.getValue()[0].length == value2.getValue()[0].length) {
            for (int i = 0; i < value1.getValue().length; i++) {
                for (int j = 0; j < value1.getValue().length; j++) {
                    sub.getValue()[i][j] = value1.getValue()[i][j] - value2.getValue()[i][j];
                }
            }
        }
        else {
            throw new ErrorOperationsException("Вычитание невозможно. Размеры матриц не совпадают.");
        }
        return sub;
    }
}
