package by.it.novik.jd02_06.matlab.operations;

import by.it.novik.jd02_06.matlab.entity.Variable;
import by.it.novik.jd02_06.matlab.exceptions.ErrorOperationsException;

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
    Variable addition(Variable valueOne, Variable valueTwo) throws ErrorOperationsException;
}
