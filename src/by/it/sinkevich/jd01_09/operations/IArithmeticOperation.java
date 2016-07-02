package by.it.sinkevich.jd01_09.operations;

import by.it.sinkevich.jd01_09.variables.MathLabVariable;

/**
 * Интерфейс содержит методы арифметических операций для переменных типа {@code MathLabVariable}
 *
 * @author Sinkevich Denis
 */
public interface IArithmeticOperation {
    /**
     * Метод складывает две переменные
     *
     * @param first  первая переменная тип {@code MathLabVariable}
     * @param second вторая переменная тип {@code MathLabVariable}
     * @return результат сложения тип {@code mathLabVariable}
     */
    MathLabVariable addition(MathLabVariable first, MathLabVariable second);

    /**
     * Метод вычитает две переменные
     *
     * @param first  первая переменная тип {@code MathLabVariable}
     * @param second вторая переменная тип {@code MathLabVariable}
     * @return результат вычитания тип {@code mathLabVariable}
     */
    MathLabVariable subtraction(MathLabVariable first, MathLabVariable second);

    /**
     * Метод перемножает две переменные
     *
     * @param first  первая переменная тип {@code MathLabVariable}
     * @param second вторая переменная тип {@code MathLabVariable}
     * @return результат перемножения тип {@code mathLabVariable}
     */
    MathLabVariable multiplication(MathLabVariable first, MathLabVariable second);

    /**
     * Метод делит две переменные
     *
     * @param first  первая переменная тип {@code MathLabVariable}
     * @param second вторая переменная тип {@code MathLabVariable}
     * @return результат деления тип {@code mathLabVariable}
     */
    MathLabVariable division(MathLabVariable first, MathLabVariable second);
}
