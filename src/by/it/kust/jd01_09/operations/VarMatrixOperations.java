package by.it.kust.jd01_09.operations;

import by.it.kust.jd01_09.vars.VarMatrix;
import by.it.kust.jd01_09.vars.Variable;

/**
 * Created by Tanya Kust
 */
public class VarMatrixOperations extends VarMatrix {
    public VarMatrixOperations(String str) {
        super(str);
    }
    /**
     *Сложение m1+m2
     * @param var m2
     * @return результат - матрицв
     */
    @Override
    public Variable add(Variable var) {
        if (var instanceof VarMatrix)  // проверим, аргумент - матрица?
        {
            VarMatrix m1 = new VarMatrix(this);    // первый операнд
            VarMatrix m2 = (VarMatrix) var;         // второй
            for (int i = 0; i < m1.matrix.length; i++){
                for ( int j = 0; j < m1.matrix[0].length; j++)
                    m1.matrix[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
            }
            return m1;
        }
        return super.add(var);
    }

    /**
     * Вычитание m1-m2
     * @param var m2
     * @return результат - матрица
     */
    @Override
    public Variable sub(Variable var) {
        if (var instanceof VarMatrix)  // проверим, аргумент - матрица?
        {
            VarMatrix m1 = new VarMatrix(this);    // первый операнд
            VarMatrix m2 = (VarMatrix) var;         // второй
            for (int i = 0; i < m1.matrix.length; i++){
                for ( int j = 0; j < m1.matrix[0].length; j++)
                    m1.matrix[i][j] = m1.matrix[i][j] - m2.matrix[i][j];
            }
            return m1;
        }
        return super.sub(var);
    }

    /**
     * Умножение m1*m2
     * @param var m2
     * @return результат - иатрица
     */
    @Override
    public Variable mul(Variable var) {return super.mul(var);}

    /**
     * Деление m1/m2
     * @param var
     * @return
     */
    @Override
    public Variable div(Variable var) {return super.div(var);}
}
