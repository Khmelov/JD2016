package by.it.kust.jd01_09.operations;

import by.it.kust.jd01_09.vars.VarDouble;
import by.it.kust.jd01_09.vars.Variable;

/**
 * Created by Tanya Kust
 */
public class VarDoubleOperations extends VarDouble{
    public VarDoubleOperations(String str) {
        super(str);
    }

    /**
     * сложение двух скаляров
     * @param var
     * @return скаляр
     */
    @Override  //
    public Variable add(Variable var) {
        if (var instanceof VarDouble)  //проверим, аргумент - скаляр?
            return new VarDouble(this.value + ((VarDouble)var).value);  //выводим итог
        return var.add(this);
    }

    /**
     * разность двух скаляров
     * @param var
     * @return скаляр
     */
    @Override
    public Variable sub(Variable var) {
        if (var instanceof VarDouble)  //проверим, аргумент - скаляр?
            return new VarDouble(this.value - ((VarDouble)var).value);  //выводим итог
        VarDouble minus = new VarDouble(-1);  //готовим -1
        return minus.mul(var.sub(this));  //выводим итог = (-1)*(V - f)
    }

    /**
     * умножение двух скаляров
     * @param var
     * @return скаляр
     */
    @Override
    public Variable mul(Variable var) {
        if (var instanceof VarDouble)  //проверим, аргумент - скаляр?
            return new VarDouble(this.value * ((VarDouble)var).value);  //выводим итог
        return var.mul(this);
    }

    /**
     * деление двух скаляров
     * @param var
     * @return скаляр
     */
    @Override
    public Variable div(Variable var) {
        if (var instanceof VarDouble)  //проверим, аргумент - скаляр?
            return new VarDouble(this.value / ((VarDouble)var).value);  //выводим итог
        return super.div(var);
    }
}
