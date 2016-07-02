package by.it.vasilevich.jd01_09.vars;

import by.it.vasilevich.jd01_09.interfaces.*;

/**
 * Created by user_2 on 18.05.2016.
 */
public abstract class Var implements IAdd, ISub, IMul, IDiv {

    @Override
    public Var add (Var var){
        new Error ("Сложение невозможно");
        return null;
    }

    @Override
    public Var sub (Var var){
        new Error ("Вычитание невозможно");
        return null;
    }

    @Override
    public Var mul (Var var){
        new Error ("Умножение невозможно");
        return null;
    }

    @Override
    public Var div (Var var){
        new Error ("Деление невозможно");
        return null;
    }
}
