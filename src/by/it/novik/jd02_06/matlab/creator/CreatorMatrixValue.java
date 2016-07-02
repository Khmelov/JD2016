package by.it.novik.jd02_06.matlab.creator;

import by.it.novik.jd02_06.matlab.entity.MatrixValue;

/**
 * Created by Kate Novik.
 */
public class CreatorMatrixValue extends CreatorVariables {

    @Override
    public MatrixValue createVariable(String var) {
        return new MatrixValue(var);
    }

    @Override
    public MatrixValue createVariable() {
        return new MatrixValue();
    }
}
