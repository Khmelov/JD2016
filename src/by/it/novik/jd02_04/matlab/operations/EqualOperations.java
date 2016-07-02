package by.it.novik.jd02_04.matlab.operations;

import by.it.novik.jd01_13.matlab.entity.Variable;
import by.it.novik.jd01_13.matlab.operations.*;


/**
 * Created by Kate Novik.
 */
public class EqualOperations implements by.it.novik.jd01_13.matlab.operations.IEquality {
    /**
     * Метод равенства
     * @param nameVar Название переменной
     * @param value Значение переменной
     * @return true - имени переменной присвоено значение
     */
    @Override
    public boolean equality(String nameVar, Variable value) {
        if (!nameVar.isEmpty()) {
            value.saveByName(nameVar);
            return true;
        }
        return false;
    }
}
