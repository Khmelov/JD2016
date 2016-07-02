package by.it.kust.jd01_09;

import by.it.kust.jd01_09.operations.VarDoubleOperations;
import by.it.kust.jd01_09.operations.VarMatrixOperations;
import by.it.kust.jd01_09.operations.VarVectorOperations;
import by.it.kust.jd01_09.vars.Variable;

/**
 * Created by Tanya Kust
 */
public class Runner {
    private static void printOneVar(Variable v) {

        if (v!=null) System.out.println(v);
    }

    public static void main(String[] args) {
        System.out.println("\nпроверка с двумя скалярами:");
        printOneVar(new VarDoubleOperations("2.0").add(new VarDoubleOperations("-3.0")));
        printOneVar(new VarDoubleOperations("1.5").sub(new VarDoubleOperations("-1")));
        printOneVar(new VarDoubleOperations("2.0").mul(new VarDoubleOperations("-1")));
        printOneVar(new VarDoubleOperations("-3").div(new VarDoubleOperations("1.5")));

        String v = "{1,2,3}";
        System.out.println("\nпроверка с векторами справа и скалярои слева:");
        printOneVar(new VarVectorOperations(v).add(new VarDoubleOperations("2.0")));
        printOneVar(new VarVectorOperations(v).sub(new VarDoubleOperations("2.0")));
        printOneVar(new VarVectorOperations(v).mul(new VarDoubleOperations("2.0")));
        printOneVar(new VarVectorOperations(v).div(new VarDoubleOperations("2.0")));

        System.out.println("\nпроверка со сколярами справа и с вектором слева:");
        printOneVar(new VarDoubleOperations("2.0").add(new VarVectorOperations(v)));
        printOneVar(new VarDoubleOperations("2.0").sub(new VarVectorOperations(v)));
        printOneVar(new VarDoubleOperations("2.0").mul(new VarVectorOperations(v)));
        printOneVar(new VarDoubleOperations("2.0").div(new VarVectorOperations(v)));

        System.out.println("\nпроверка +-*//* операций с двумя векторами");
        printOneVar(new VarVectorOperations(v).add(new VarVectorOperations(v)));
        printOneVar(new VarVectorOperations(v).sub(new VarVectorOperations(v)));
        printOneVar(new VarVectorOperations(v).mul(new VarVectorOperations(v)));
        printOneVar(new VarVectorOperations(v).div(new VarVectorOperations(v)));

        String m = "{{1,2},{3,4}}";
        System.out.println("\nпроверка с матрицей ...");
        printOneVar(new VarMatrixOperations(m).add(new VarMatrixOperations(m)));
        printOneVar(new VarMatrixOperations(m).sub(new VarMatrixOperations(m)));
        printOneVar(new VarMatrixOperations(m).mul(new VarMatrixOperations(m)));
        printOneVar(new VarMatrixOperations(m).div(new VarMatrixOperations(m)));
    }
}
