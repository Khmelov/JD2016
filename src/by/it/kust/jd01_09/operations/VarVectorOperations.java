package by.it.kust.jd01_09.operations;

import by.it.kust.jd01_09.vars.VarDouble;
import by.it.kust.jd01_09.vars.VarVector;
import by.it.kust.jd01_09.vars.Variable;

/**
 * Created by Tanya Kust
 */
public class VarVectorOperations extends VarVector {
    public VarVectorOperations(String str) {
        super(str);
    }
    /**
     *Сложение v1+v2
     * @param var v2
     * @return результат - вектор
     */
    @Override
    public Variable add(Variable var) {
        if (var instanceof VarVector)  // проверим, аргумент - вектор?
        {
            VarVector v1 = new VarVector(this);    // первый операнд
            VarVector v2 = (VarVector)var;         // второй
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] + v2.vector[i];
            }
            return v1;
        }

        if (var instanceof VarDouble)  // проверим, аргумент - скаляр?
        {
            VarVector v1 = new VarVector(this);    // первый операнд
            double v2 = ((VarDouble)var).getValue();         // второй
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] + v2;
            }
            return v1;
        }
        return super.add(var);
    }

    /**
     * Вычитание v1-v2
     * @param var v2
     * @return результат - вектор
     */
    @Override
    public Variable sub(Variable var) {
        if (var instanceof VarVector)  // проверим, аргумент - вектор?
        {
            VarVector v1 = new VarVector(this);    // первый операнд
            VarVector v2 = (VarVector)var;         // второй
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2.vector[i];
            }
            return v1;
        }

        if (var instanceof VarDouble)  // проверим, аргумент - скаляр?
        {
            VarVector v1 = new VarVector(this);    // первый операнд
            double v2 = ((VarDouble)var).getValue();         // второй
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] - v2;
            }
            return v1;
        }
        return super.sub(var);
    }

    /**
     * Умножение v1*v2
     * @param var v2
     * @return результат - вектор
     */
    @Override
    public Variable mul(Variable var) {
        if (var instanceof VarVector)  // проверим, аргумент - вектор?
        {
            double f = 0;
            VarVector v1 = new VarVector(this);    // первый операнд
            VarVector v2 = (VarVector)var;         // второй
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] * v2.vector[i];
            }
            return v1;
        }
        if (var instanceof VarDouble)  // проверим, аргумент - скаляр?
        {
            VarVector v1 = new VarVector(this);    // первый операнд
            double v2 = ((VarDouble)var).getValue();         // второй
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] * v2;
            }
            return v1;
        }
        return super.mul(var);
    }

    /**
     * Деление v1/v2
     * @param var
     * @return результат - вектор
     */
    @Override
    public Variable div(Variable var) {
        if (var instanceof VarDouble)  // проверим, аргумент - скаляр?
        {
            VarVector v1 = new VarVector(this);    // первый операнд
            double v2 = ((VarDouble)var).getValue();         // второй
            for (int i = 0; i < v1.vector.length; i++) {
                v1.vector[i] = v1.vector[i] / v2;
            }
            return v1;
        }
        return super.div(var);
    }

}
