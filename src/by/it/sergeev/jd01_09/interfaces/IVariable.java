package by.it.sergeev.jd01_09.interfaces;

import by.it.sergeev.jd01_09.vars.Variable;

import java.io.IOException;

public interface IVariable {
    Variable add(Variable varAdd);
    Variable sub(Variable varSub);
    Variable mul(Variable varMul);
    Variable div(Variable varDiv);
    String toString();
    void setFromString(String str) throws IOException;;
}





