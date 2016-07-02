package by.it.kust.jd01_09.vars;

import by.it.kust.jd01_09.interfaces.*;

/**
 * Created by Tanya Kust
 */
public class VarDouble extends Variable implements IVariables {
    public double value;
    public VarDouble(String str){setFromStr(str);} // из строки
    public VarDouble(double value) {this.value = value;} //из числа
    public double getValue() {return value;}

    /**
     * преобразование в строку
     * @return
     */
    @Override
    public String toString() {
        return ((Double)value).toString();}

    /**
     * из строки в число
     * @param str
     */
    @Override
    public void setFromStr(String str) {
        value=Double.valueOf(str);}
}
