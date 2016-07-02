package by.it.drachyova.jd01_09.Variables;

import by.it.drachyova.jd01_09.interfaces.*;
/**
 * реализация для переменной типа double
 */
public class VariableDouble extends AbstractVariable implements IVariable, IOperation{
    private double value;
    public VariableDouble(String str){ //конструктор инициализирует переменную полученной строкой
        setValue(str);
    }
    public VariableDouble(double value){ //конструктор иницилизирует переменную полученным значением
        this.value = value;
    }
    public  double getValue(){ //получение значения переменной
        return value;
    }
    @Override
    public void setValue(String str){ //запись значения в переменную
        value=Double.valueOf(str);
    }
    @Override
    public String toString(){ //преобразование переменной в строку
        return ((Double)value).toString();
    }
    @Override
    public AbstractVariable addition(AbstractVariable var) {
        if (var instanceof VariableDouble)
            return new VariableDouble(this.value + ((VariableDouble)var).value);
        return var.addition(this);
    }

    @Override
    public AbstractVariable substraction(AbstractVariable var) {
        if (var instanceof VariableDouble)
            return new VariableDouble(this.value - ((VariableDouble)var).value);
        VariableDouble minus=new VariableDouble(-1);
        return minus.multiplication(var.addition(this));
    }

    @Override
    public AbstractVariable multiplication(AbstractVariable var) {
        if (var instanceof VariableDouble)
            return new VariableDouble(this.value * ((VariableDouble)var).value);
        return var.multiplication(this);
    }

    @Override
    public AbstractVariable division(AbstractVariable var) {
        if (var instanceof VariableDouble)
            return new VariableDouble(this.value / ((VariableDouble)var).value);
        return super.division(var);
    }

  }
