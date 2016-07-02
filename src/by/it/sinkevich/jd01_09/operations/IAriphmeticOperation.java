package by.it.sinkevich.jd01_09.operations;

import by.it.sinkevich.jd01_09.variables.MathLabVariable;

/**
 * Created by Computer on 16.05.2016.
 *
 * @author Sinkevich Denis
 */
public interface IAriphmeticOperation {

    MathLabVariable addition(MathLabVariable first, MathLabVariable second);

    MathLabVariable substraction(MathLabVariable first, MathLabVariable second);

    MathLabVariable multiplication(MathLabVariable first, MathLabVariable second);

    MathLabVariable division(MathLabVariable first, MathLabVariable second);
}
