package by.it.kust.jd01_09.interfaces;

import by.it.kust.jd01_09.vars.Variable;

/**
 * Created by Tanya Kust
 */
public interface IVariables {
    Variable add(Variable var);  //сложение
    Variable sub(Variable var);  //вычитание
    Variable mul(Variable var);  //усножение
    Variable div(Variable var); //деление
    String toString();   //метод вывода переменной в строку
    void setFromStr(String str);  //метод чтения значения переменной из строки
}
