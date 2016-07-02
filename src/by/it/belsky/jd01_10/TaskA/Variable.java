package by.it.belsky.jd01_10.TaskA;

import by.it.akhmelev.jd01_06.Level_A.Data;

import java.awt.geom.Arc2D;

/**
 * Created by misha on 29.05.2016.
 */
public class Variable implements Ivariable {
    private Double value;

    public Variable() {
    }

    public Variable(String string) {
        this.value = Double.valueOf(string);
    }

    public Variable(Double value) {
        this.value = value;
    }

    @Override
    public Variable add(Variable varAdd) {
        Variable out = new Variable();
        out.value = this.value + varAdd.value;
        return out;
    }

    @Override
    public Variable sub(Variable varSub) {
        Variable out = new Variable();
        out.value = this.value - varSub.value;
        return out;
    }

    @Override
    public Variable mul(Variable varMul) {
        Variable out = new Variable();
        out.value = this.value * varMul.value;
        return out;
    }

    @Override
    public Variable div(Variable varDiv) {
        Variable out = new Variable();
        out.value = this.value / varDiv.value;
        return out;
    }

    public String toString() {
        return value.toString();
   }
}