package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.exceptions.ErrorOperationsException;

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
    Variable multiplication (Variable valueOne, Variable valueTwo) throws ErrorOperationsException;
}
