package by.it.kushel.jd01_08;

/**
 * Created by Diomn on 21.05.2016.
 */
public class DoubleVariable implements IVariable{
    Double value;

DoubleVariable(Double value){
    this.value=value;
}
    DoubleVariable(){};
   /*DoubleVariable(String var){
        this.var=Double.valueOf(var);

    }*/

    @Override
    public void setValue(Object value) {

        this.value = (double)value;
    }
    @Override
    public Object getValue() {

        return value;
    }

public String toString(){
    return Double.toString(Math.rint(100*value)/100);
}


}
