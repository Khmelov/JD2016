package by.it.kust.jd01_09.vars;

import by.it.kust.jd01_09.interfaces.*;
import by.it.kust.jd01_09.errors.Error;

/**
 * Created by Tanya Kust
 */
public abstract class Variable implements IVariables{

    @Override
    public Variable add(Variable var) {
        new Error("Сложение невозможно");
        return null;
    }

    @Override
    public Variable sub(Variable var) {
        new Error("Вычитание невозможно");
        return null;
    }

    @Override
    public Variable mul(Variable var) {
        new Error("Умножение невозможно");
        return null;
    }

    @Override
    public Variable div(Variable var) {
        new Error("Деление невозможно");
        return null;
    }
}
