package by.it.novik.jd02_06.matlab.creator;

import by.it.novik.jd02_06.matlab.entity.Variable;

/**
 * Created by Kate Novik.
 */
public abstract class CreatorVariables {

    /**
     * Метод создания переменных
     * @param var Строка для передачи в конструктор создаваемой переменной
     * @return Переменная типа Variable
     */
    public abstract Variable createVariable (String var);

    public abstract Variable createVariable ();
}
