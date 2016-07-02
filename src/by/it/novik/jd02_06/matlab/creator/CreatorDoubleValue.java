package by.it.novik.jd02_06.matlab.creator;

import by.it.novik.jd02_06.matlab.entity.DoubleValue;
import by.it.novik.jd02_06.matlab.entity.Variable;

/**
 * Created by Kate Novik.
 */
public class CreatorDoubleValue extends CreatorVariables {

    @Override
    public DoubleValue createVariable(String var) {
        return new DoubleValue(var);
    }

    @Override
    public DoubleValue createVariable() {
        return new DoubleValue();
    }
}
