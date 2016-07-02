package by.it.novik.jd01_13.matlab.entity;

/**
 * Created by Kate Novik.
 */
public interface IVariable {
    /**
     * Интерфейс действий с переменной
     */

    /**
     * Установить значение переменной
     * @param value Значение переменной типа Object
     */
    void setValue(Object value);

    /**
     * Получить значение переменной
     * @return Значение переменной типа Object
     */
    Object getValue();

    /**
     * Установить название переменной
     * @param nameVar Название переменной
     * @return true - переменная по имени сохранена
     */
    boolean saveByName(String nameVar);

    /**
     * Получить значение переменной по названию
     * @param nameVar Название переменной
     * @return Значение переменной типа Object
     */
    Object readByName(String nameVar);

    /**
     * Преобразование значение переменной в строку
     * @return Значение переменной в виде строки
     */
    String toString();
}
