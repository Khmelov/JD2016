package by.it.belsky.jd01_10.TaskB;

import by.it.belsky.jd01_10.TaskB.Vars.*;

/**
 * Created by misha on 01.06.2016.
 */
public class ConsoleRunner {
    public static void Print(Var v){
        if (v!=null) System.out.println(v);

    }
    public static void main(String[] args) {
        String vec1="{2,3,4}";
        String vec2="{5,6,7}";

        Print(new VarVectorOperation(vec1).mul(new VarFloat("2")));
        Print(new VarVectorOperation(vec1).div(new VarFloat("3")));
        Print(new VarVectorOperation(vec1).sub(new VarFloat("5")));
        Print(new VarFloatOperation("-4").add(new VarVectorOperation(vec1)));
        Print(new VarVectorOperation(vec1).add(new VarVectorOperation(vec2)));
        Print(new VarVectorOperation(vec1).sub(new VarVectorOperation(vec2)));
    }
}
