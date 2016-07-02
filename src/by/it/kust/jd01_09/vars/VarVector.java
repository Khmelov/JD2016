package by.it.kust.jd01_09.vars;

import by.it.kust.jd01_09.patterns.Patterns;
import by.it.kust.jd01_09.interfaces.IVariables;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tanya Kust
 */
public class VarVector extends Variable implements IVariables {

    public double[] vector;
    public VarVector(String str) {setFromStr(str);}

    public VarVector(VarVector init) {
        this.vector = new double[init.vector.length];
        System.arraycopy(init.vector, 0, this.vector, 0, this.vector.length);
    }

    /**
     * преобразование в строку
     * @return строку ввиде записи массива со скобками и запятыми
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        String prefix = "{";
        for (Double val: vector) {
            res.append(prefix).append(val.toString());
            prefix = ", ";
        }
        return res.append("}").toString();
    }

    /**
     * числа векторной записи из строки в массив
     * @param str
     */
    @Override
    public void setFromStr(String str) {
        String[] elem = str.split(",");
        vector = new double[elem.length];
        Matcher m = Pattern.compile(Patterns.exVal).matcher(str);
        int i = 0;
        while (m.find()) {
            vector[i] = Double.parseDouble(m.group());
            i++;
        }
    }
}
