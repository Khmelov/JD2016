package by.it.belsky.jd01_10.TaskB.Vars;

import by.it.belsky.jd01_10.TaskB.Interfaces.*;

/**
 * Created by misha on 01.06.2016.
 */
public class VarFloat extends Var implements IVar {
    public double value;

    public VarFloat(String str) {
        setFrom(str);
    }

    public VarFloat(double value) {
        this.value = value;
    }

    public double getValue() {
     return value;
    }



    @Override
    public void setFrom(String str) {
        value=Double.valueOf(str);
    }


}