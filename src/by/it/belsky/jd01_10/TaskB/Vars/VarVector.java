package by.it.belsky.jd01_10.TaskB.Vars;

import by.it.belsky.jd01_10.TaskB.Interfaces.IVar;
import by.it.belsky.jd01_10.TaskB.PatternFloat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by misha on 01.06.2016.
 */
public class VarVector extends Var implements IVar {
    public double[] vector;

    public VarVector(String str) {
        setFrom(str);
    }

    VarVector(double[] vector) { //конструктор из массива
        this.vector = new double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    VarVector(VarVector init) { //конструктор-копия (можно также реализовать clone)
        this.vector = new double[init.vector.length];
        System.arraycopy(init.vector, 0, this.vector, 0, this.vector.length);
    }


    @Override
    public void setFrom(String str) {
        String[] elem = str.split(",");
        vector = new double[elem.length];
        Matcher m = Pattern.compile(PatternFloat.exVal).matcher(str);
        int i = 0;
        while (m.find()) {
            vector[i] = Double.parseDouble(m.group());
            i++;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        String prefix = "{";
        for (Double val : vector) {
            res.append(prefix).append(val.toString());
            prefix = ", ";
        }
        return res.append("}").toString();
    }
}
