package by.it.novik.jd01_13.taskC.Furniture;


import by.it.novik.jd01_13.taskC.Entity.Things;
import by.it.novik.jd01_13.taskC.exceptions.EmptyNameException;

/**
 * Created by Kate Novik.
 */
public interface IFurniture {
    /**
     * Опишем возможные действия с мебелью
     * interface Мебель <-- abstract class Шкаф <-- class Книжный Шкаф.
     */

    /**
     * Метод открыть (разложить) мебель
     * @return true - открыт
     */
    boolean open ();

    /**
     * Метод закрыть (сложить) мебель
     * @return true - закрыт
     */
    boolean close ();

    /**
     * Метод положить вещь
     * @param thing Вещь
     * @return true - вещь положена
     */
    boolean put(Things thing);

    /**
     * Метод получить вещь по названию
     * @param name Название вещи
     * @return Найденная вещь
     */
    Things getByName(String name) throws EmptyNameException;

    /**
     * Метод переместить мебель
     * @param xNext Параметр перемещения по X
     * @param yNext Параметр перемещения по Y
     */
    void move (double xNext, double yNext);

    /**
     * Метод собрать мебель
     * @return true - мебель собрана
     */
    boolean assemble ();

    /**
     * Метод разобрать мебель
     * @return true - мебель разобрана
     */
    boolean disassemble ();

    /**
     * Метод очистить
     * @return true - очищен
     */
    boolean clean ();
}
