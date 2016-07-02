package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.exceptions.ErrorOperationsException;

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
