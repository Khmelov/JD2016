package by.it.drachyova.jd01_09.Variables;

import by.it.drachyova.jd01_09.interfaces.IOperation;
import by.it.drachyova.jd01_09.interfaces.IVariable;

/**
 * Абстрактный класс для абстрактной переменной
 */
public abstract class AbstractVariable implements IVariable, IOperation{

    @Override
    public void setValue(String str) {//запись значения в переменную
    }

    @Override
    public String toString() { //преобразование в строку

    return null;
    }
    @Override
    public AbstractVariable addition(AbstractVariable var){ //сложение
        System.out.println("Сложение невозможно");
        return null;
    }
    @Override
    public AbstractVariable substraction(AbstractVariable var){ //вычитание
        System.out.println("Вычитание невозможно");
        return null;
    }
    @Override
    public AbstractVariable multiplication(AbstractVariable var){ //умножение
        System.out.println("Умножение невозможно");
        return null;
    }
    @Override
    public AbstractVariable division(AbstractVariable var){ //деление
        System.out.println("Деление невозможно");
        return null;
    }
}
