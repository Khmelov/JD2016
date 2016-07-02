package by.it.novik.jd01_13.matlab.operations;

import by.it.novik.jd01_13.matlab.entity.Variable;
import by.it.novik.jd01_13.matlab.exceptions.ErrorOperationsException;

/**
 * Created by Kate Novik.
 */
public interface ISubtraction {
    /**
     * Операция вычитания Subtraction
     * @param valueOne Первый параметр
     * @param valueTwo Второй параметр
     * @return Результат вычитания
     */
    Variable subtraction (Variable valueOne, Variable valueTwo) throws ErrorOperationsException;
}
