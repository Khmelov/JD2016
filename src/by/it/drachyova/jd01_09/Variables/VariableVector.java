package by.it.drachyova.jd01_09.Variables;

import by.it.drachyova.jd01_09.interfaces.IVariable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.it.drachyova.jd01_09.Patterns;
/**
 * реализация для переменной типа double[]
 */
public class VariableVector extends AbstractVariable implements IVariable{

    private double[] vector;
    public VariableVector(String str)//конструктор инициализирует массив полученной строкой
    {
        setValue(str);
    }

    VariableVector(double[] vector) {//конструктор иницилизирует массив полученным массивом
        this.vector = new double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    VariableVector(VariableVector init) {//конструктор-копия
        this.vector = new double[init.vector.length];
        System.arraycopy(init.vector, 0, this.vector, 0, this.vector.length);
    }

    @Override //сложение
    public AbstractVariable addition (AbstractVariable var) {
        if (var instanceof VariableVector)

        {

            VariableVector v1 = new VariableVector(this);
            VariableVector v2 = (VariableVector) var;
            if(v1.vector.length==v2.vector.length) {
                for (int i = 0; i < v1.vector.length; i++) {
                    v1.vector[i] = v1.vector[i] + v2.vector[i];
                }
            }
            return v1;
        }

        if (var instanceof VariableDouble)
        {
            VariableVector v1 = new VariableVector(this);
            double v2 = ((VariableDouble) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] + v2;
            }
            return v1;
        }
        return super.addition(var);
    }


    @Override//вычитание
    public AbstractVariable substraction(AbstractVariable var) {

        if (var instanceof VariableVector)
        {
            VariableVector v1 = new VariableVector(this);
            VariableVector v2 = (VariableVector) var;
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2.vector[i];
            }
            return v1;
        }

        if (var instanceof VariableDouble)
        {
            VariableVector v1 = new VariableVector(this);
            double v2 = ((VariableDouble) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2;
            }
            return v1;
        }

        return super.substraction(var);
    }


    @Override//умножение
    public AbstractVariable multiplication(AbstractVariable var) {
        if (var instanceof VariableVector)
        {
            double f=0;
            VariableVector v1 = new VariableVector(this);
            VariableVector v2 = (VariableVector) var;
            if(v1.vector.length==v2.vector.length) {
                for (int i = 0; i < v1.vector.length; i++) {
                    f = f + (v1.vector[i] * v2.vector[i]);
                }
            }
                return new VariableDouble(f);
        }
        if (var instanceof VariableDouble)
        {
            VariableVector v1 = new VariableVector(this);
            double v2 = ((VariableDouble) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] * v2;
            }
            return v1;
        }
        return super.multiplication(var);
    }

    @Override//деление
    public AbstractVariable division(AbstractVariable var) {
        if (var instanceof VariableDouble)
        {
            VariableVector v1 = new VariableVector(this);
            double v2 = ((VariableDouble) var).getValue();
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] / v2;
            }
            return v1;
        }
        return super.division(var);
    }





    @Override//преобразование в строку
    public String toString() {
        StringBuilder res=new StringBuilder("");
        String prefix="{";
        for (Double val:vector) {
            res.append(prefix).append(val.toString());
            prefix=", ";
        }
        return res.append("}").toString();
    }


    @Override//заполнение из строки
    public void setValue(String str) {
        String[] elem=str.split(",");
        vector=new double[elem.length];
        Matcher m=Pattern.compile(Patterns.exVal).matcher(str);
        int i=0;
        while (m.find()) {
            vector[i]=Double.parseDouble(m.group());
            i++;
        }
    }
}
