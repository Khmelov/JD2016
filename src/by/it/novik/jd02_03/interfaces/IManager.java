package by.it.novik.jd02_03.interfaces;

import by.it.novik.jd02_03.entities.Supermarket;

/**
 * Created by Kate Novik.
 */
public interface IManager {

    /**
     * Метод создания кассиров
     * @param count количество кассиров
     */
    void createCashiers (int count);

    /**
     * Метод открытия новой кассы
     */
    void openCashier ();

    /**
     * Метод акрытия всех касс
     */
    void closeCashiers();
}
