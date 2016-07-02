package by.it.sergeev.jd01_09.vars;

import by.it.sergeev.jd01_09.interfaces.IVariable;

public class DoubleValue extends Variable implements IVariable {

    private double value;


    public DoubleValue(String str) {                     //когда получили строку
        setFromString(str);
    }

    public DoubleValue(double value) {                    //когда получили число
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Variable add(Variable varAdd) {
        if (varAdd instanceof DoubleValue) //проверка (аргумент - скаляр?)
            return new DoubleValue(this.value + ((DoubleValue) varAdd).value); //результат
        return varAdd.add(this);//если арнумент не скаляр, то меняем местами.
    }

    @Override
    public Variable sub(Variable varSub) {
        if (varSub instanceof DoubleValue)
            return new DoubleValue(this.value - ((DoubleValue) varSub).value);
        DoubleValue minus = new DoubleValue(-1);
        return minus.mul(varSub.sub(this));
    }

    @Override
    public Variable mul(Variable varMul) {
        if (varMul instanceof DoubleValue)
            return new DoubleValue(this.value * ((DoubleValue) varMul).value);
        return varMul.mul(this);
    }

    @Override
    public Variable div(Variable varDiv) {
        if (varDiv instanceof DoubleValue)
            return new DoubleValue(this.value / ((DoubleValue) varDiv).value);
        return super.div(varDiv);//если аргемент не скаляр - деление невозможно.
    }

    @Override
    public String toString() {
        return ((Double)value).toString();
    }

    @Override
    public void setFromString(String str) {
        value = Double.valueOf(str);
    }
}

