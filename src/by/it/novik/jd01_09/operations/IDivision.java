package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.exceptions.ErrorOperationsException;

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
    Variable division (Variable valueOne, Variable valueTwo) throws ErrorOperationsException;
}
