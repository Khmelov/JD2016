package by.it.novik.jd02_06.matlab.operations;

import by.it.novik.jd02_06.matlab.entity.Variable;
import by.it.novik.jd02_06.matlab.exceptions.ErrorOperationsException;

/**
 * Created by Катя.
 */
public interface IMultiplication {
    /**
     * Операция умножения Multiplication
     * @param valueOne Первый множитель
     * @param valueTwo Второй множитель
     * @return Результат умножения
     */
    Variable multiplication(Variable valueOne, Variable valueTwo) throws ErrorOperationsException;
}
