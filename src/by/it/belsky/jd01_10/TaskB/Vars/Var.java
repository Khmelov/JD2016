package by.it.belsky.jd01_10.TaskB.Vars;

import by.it.belsky.jd01_10.TaskB.Interfaces.IAdd;
import by.it.belsky.jd01_10.TaskB.Interfaces.IDiv;
import by.it.belsky.jd01_10.TaskB.Interfaces.IMul;
import by.it.belsky.jd01_10.TaskB.Interfaces.ISub;

/**
 * Created by misha on 01.06.2016.
 */
public abstract  class Var implements IAdd, IDiv, IMul, ISub {
    @Override
    public Var add(Var var) {
        new Error("Сложение невозможно");
        return null;
    }

    @Override
    public Var div(Var var) {
        new Error("Деление невозможно");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new Error("Умножение невозможно");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new Error("Вычитание невозможно");
        return null;
    }
}
