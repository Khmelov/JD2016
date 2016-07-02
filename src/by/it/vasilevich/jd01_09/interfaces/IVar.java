package by.it.vasilevich.jd01_09.interfaces;

/**
 * Created by user_2 on 18.05.2016.
 */
public interface IVar extends IAdd, IDiv, ISub, IMul {
    String toString();//переводим переменную в строку
    void setFrom(String str);//чтение значения переменной из строки
}
