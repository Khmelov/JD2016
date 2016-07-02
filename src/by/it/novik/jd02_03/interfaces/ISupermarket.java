package by.it.novik.jd02_03.interfaces;

import by.it.novik.jd02_03.entities.Basket;
import by.it.novik.jd02_03.entities.Buyer;
import by.it.novik.jd02_03.entities.Good;

import java.util.HashMap;


/**
 * Created by Kate Novik.
 */
public interface ISupermarket {
    /**
     * Получить список товаров из файла
     * @return HashMap<Good,Integer>, где ключ - товар, значение - количество
     */
    HashMap<Good,Integer> getAllGoods();

    /**
     * Получить количество покупателей
     * @return количество покупателей
     */
    int getCountBuyers();

    /**
     * Увеличить количество покупателлей в магазине
     * @param buyer созданный покупатель
     */
    void incrementCountOfBuyers(Buyer buyer);

    /**
     * Уменьшить количество покупателлей в магазине
     * @param buyer созданный покупатель
     */
    void decrementCountOfBuyers(Buyer buyer);

    /**
     * Создать товар
     * @param idGood id товара
     * @param nameGood имя товара
     * @param producer производитель товара
     * @param  cost цена товара
     * @return созданный товар
     */
    Good createGood(int idGood, String nameGood, String producer, int cost);

    /**
     * Уменьшение корзин в магазине
     * @return корзинку
     */
    Basket decrementBaskets();

    /**
     * Добавление покупателей за i-ую сек в минуте
     * @param time i-ая сек в минуте
     */
    void addBuyersForSec(int time);

}
