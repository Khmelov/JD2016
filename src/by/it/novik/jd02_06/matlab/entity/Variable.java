package by.it.novik.jd02_06.matlab.entity;

import by.it.novik.jd01_13.matlab.entity.IVariable;

/**
 * Created by Kate Novik.
 */
public abstract class Variable implements IVariable {
    /**
     * Абстрактный класс всех переменных Matlab
     */
    // Поле значение переменной типа Object
//    private Object value;
//
//    public Variable() {
//        this.value = null;
//    }
//    public Variable(Object value) {
//        this.value = value;
//    }
//
//    @Override
//    public Object getValue() {
//        return value;
//    }
//
//    @Override
//    public void setValue(Object value) {
//        this.value = value;
//    }
//    // Объявим абстрактный метод установки значения переменной со строки
//    public abstract void setValue (String value);
//
//    @Override
//    public String toString() {
//        return value.toString();
//    }

    @Override
    public Object getValue() { return null; }

    @Override
    public void setValue(Object value) {}

    @Override
    public boolean saveByName(String nameVar) { return false; }

    @Override
    public Object readByName(String nameVar) { return null; }

    // Объявим абстрактный метод установки значения переменной со строки
    public abstract void setValue (String value);

    @Override
    public String toString() {
        return null;
    }


}
