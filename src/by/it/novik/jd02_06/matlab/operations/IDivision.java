package by.it.novik.jd02_06.matlab.operations;

import by.it.novik.jd02_06.matlab.entity.Variable;
import by.it.novik.jd02_06.matlab.exceptions.ErrorOperationsException;

/**
 * Created by Катя.
 */
public interface IDivision {
    /**
     * Операция деления Division
     * @param valueOne Делимое
     * @param valueTwo Делитель
     * @return Результат деления
     */
    Variable division(Variable valueOne, Variable valueTwo) throws ErrorOperationsException;
}
