package by.it.novik.jd01_13.matlab.operations;

import by.it.novik.jd01_13.matlab.entity.Variable;
import by.it.novik.jd01_13.matlab.exceptions.ErrorOperationsException;

/**
 * Created by Kate Novik.
 */
public interface IAddition {
    /**
     * Операция сложения Addition
     * @param valueOne Первое слагаемое
     * @param valueTwo Второе слагаемое
     * @return Сумма
     */
    Variable addition (Variable valueOne, Variable valueTwo) throws ErrorOperationsException;
}
