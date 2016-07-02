package by.it.drachyova.jd01_09.interfaces;

import by.it.drachyova.jd01_09.Variables.*;

/**
 * Интерфейс для арифметических операций
 */
public interface IOperation {
    AbstractVariable addition (AbstractVariable var); //сложение
    AbstractVariable substraction (AbstractVariable var); //вычитание
    AbstractVariable multiplication (AbstractVariable var); //умножение
    AbstractVariable division(AbstractVariable var); //деление
}
