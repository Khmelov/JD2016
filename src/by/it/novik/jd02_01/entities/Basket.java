package by.it.novik.jd02_01.entities;

import by.it.novik.jd02_01.interfaces.IBasket;
import by.it.novik.jd02_01.utils.RandomCounter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kate Novik.
 */
public class Basket implements IBasket {

    //Список товаров в корзине
    private HashMap<Good, Integer> goodsInBasket = new HashMap<>();

    @Override
    public void putGoodInBasket(Good good, int cost) {
        if (good != null) {
            goodsInBasket.put(good,cost);
        }
        else {
            System.out.println("Good is null!");
        }
    }

    @Override
    public Map.Entry<Good,Integer> takeGoodFromBasket() {
        int i = 0;
        Map.Entry<Good,Integer> goodTake = null; //Товар из корзины с соответствующей ценой
        int randomGood = RandomCounter.countRandom(i,goodsInBasket.size()); //Выбираем случайным образом товар из корзины
        for (Map.Entry<Good,Integer> set : goodsInBasket.entrySet()) {
            if (i == randomGood) {
                goodTake = set;
                break;
            }
            i++;
        }
    return goodTake;
    }
}
