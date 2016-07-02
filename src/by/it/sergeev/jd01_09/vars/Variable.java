package by.it.sergeev.jd01_09.vars;

import by.it.sergeev.jd01_09.interfaces.IVariable;

public abstract class Variable implements IVariable {

    @Override
    public Variable add(Variable varAdd) {
        new Error("Сложение невозможно");
        return null;
    }

    @Override
    public Variable sub(Variable varSub) {
        new Error("Вычитание невозможно");
        return null;
    }

    @Override
    public Variable mul(Variable varMul) {
        new Error("Умножение невозможно");
        return null;
    }

    @Override
    public Variable div(Variable varDiv) {
        new Error("Деление невозможно");
        return null;
    }
}

