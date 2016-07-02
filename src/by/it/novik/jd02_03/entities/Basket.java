package by.it.novik.jd02_03.entities;

import by.it.novik.jd02_03.interfaces.IBasket;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Kate Novik.
 */
public class Basket implements IBasket {

    //Список товаров в корзине
    private HashMap<Good, Integer> goodsInBasket = new HashMap<>();

    public HashMap<Good, Integer> getGoodsInBasket() {
        return goodsInBasket;
    }

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
        Map.Entry<Good,Integer> goodTake = null; //Товар из корзины с соответствующей ценой
        Iterator<Map.Entry<Good,Integer>> it = goodsInBasket.entrySet().iterator();
        while (it.hasNext()) {
            goodTake = it.next();
            it.remove();
            break;
        }
    return goodTake;
    }
}
