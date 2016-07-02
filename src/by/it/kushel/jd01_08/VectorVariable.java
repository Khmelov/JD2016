package by.it.kushel.jd01_08;

/**
 * Created by Diomn on 21.05.2016.
 */
public class VectorVariable implements IVariable {
    private Double[] value;


    public VectorVariable() {

    }
    public VectorVariable(Double[] value) {

        this.value = value;

    }
    /*public VectorVariable(String string) {
        this.value = Double.valueOf(string);
    }*/

    @Override
    public void setValue(Object value) {
        this.value = (Double[])value;
    }

    public Double[] getValue() {
        return value;
    }

    public String toString(){
        String str1 ="";
        for(int i =0; i<value.length; i++){
        //str1 =str1+Math.rint(100*value[i]/100) + ", ";
            str1 =str1+value[i] + ", ";
        }
 str1="["+str1.substring(0,str1.length()-2)+"]";
        return str1;
    }
}
