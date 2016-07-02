package by.it.novik.jd02_06.matlab.creator;

import by.it.novik.jd02_06.matlab.entity.VectorValue;

/**
 * Created by Катя.
 */
public class CreatorVectorValue extends CreatorVariables {

    @Override
    public VectorValue createVariable(String var) {
        return new VectorValue(var);
    }

    @Override
    public VectorValue createVariable() {
        return new VectorValue();
    }
}
