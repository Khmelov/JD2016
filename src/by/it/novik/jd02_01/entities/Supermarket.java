package by.it.novik.jd02_01.entities;

import by.it.novik.jd02_01.interfaces.ISupermarket;
import by.it.novik.jd02_01.utils.RandomCounter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Kate Novik.
 */
public class Supermarket implements ISupermarket {

    //Поле id супермаркета
    public int idSM = 1;
    //Поле товары в магазине
    private HashMap<Good, Integer> allGoods;
    //Поле количество покупателей
    private volatile int countBuyers;
    //Поле количество корзинок
    private int countBaskets;

    public Supermarket() {
        this.allGoods = new HashMap<>();
        this.countBuyers = 10;
        this.countBaskets = 0;
    }

    public Supermarket(HashMap<Good, Integer> allGoods, int countBuyers, int countBaskets) {
        this.allGoods = allGoods;
        this.countBuyers = countBuyers;
        this.countBaskets = countBaskets;
    }

    @Override
    public HashMap<Good, Integer> getAllGoods() {
        return this.allGoods;
    }

    @Override
    public int getCountBuyers() {
        return this.countBuyers;
    }

    public int getCountBaskets() {
        return this.countBaskets;
    }

    public void setCountBaskets(int countBaskets) {
        this.countBaskets = countBaskets;
    }

    @Override
    public void incrementCountOfBuyers(Buyer buyer) {
        if (buyer != null) {
            this.countBuyers++;
        }

    }

    @Override
    public void decrementCountOfBuyers(Buyer buyer) {
        if (buyer != null) {
            this.countBuyers--;
        }

    }

    @Override
    public Good createGood(int idGood, String nameGood, String producer, int cost) {
        if (idGood != 0 && nameGood != null && producer != null && cost != 0) {
            Good good = new Good(idGood, nameGood, producer);
            if (!allGoods.containsKey(good)) {
                allGoods.put(good,cost);
            }
            else {
                Iterator<Map.Entry<Good,Integer>> it = allGoods.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Good,Integer> set = it.next();
                    if (set.getKey().equals(good)) {
                        set.setValue(cost);
                    }
                }
            }
            return good;
        }
        return null;
    }

    @Override
    public Basket decrementBaskets() {
        if (countBaskets > 0) {
            countBaskets--;
            return new Basket();
        }
        return null;
    }

    @Override
    public void addBuyersForSec (int time) {
        if (time <= 30) {
            int count = RandomCounter.countRandom(1, 5);
            while ((getCountBuyers() + count) <= time + 10) {
                count++;
            }
            for (int i = 0; i < count; i++) {
                if ((getCountBuyers() + 1) % 4 != 0) { //Проверка на не каждый четвертый - обычный покупатель
                   new Buyer(getCountBuyers() + 1, this, false);//Создаем покупателя
                } else { //В случае, если каждый четвертый, то пенсионер - флаг true
                    new Buyer(getCountBuyers() + 1, this, true);//Создаем покупателя
                }
                countBuyers++;

            }
        } else if (time > 30 && time <= 60) {
            int count = RandomCounter.countRandom(1, 3);
            while ((getCountBuyers() + count) > (40 + (30 - time))) {
                count--;
            }
            while ((getCountBuyers() + count) < (40 + (30 - time))) {
                count++;
            }
            for (int i = 0; i < count; i++) {
                if ((getCountBuyers() + 1) % 4 != 0) { //Проверка на не каждый четвертый - обычный покупатель
                    new Buyer(getCountBuyers() + 1, this, false);//Создаем покупателя
                } else { //В случае, если каждый четвертый, то пенсионер - флаг true
                    new Buyer(getCountBuyers() + 1, this, true);//Создаем покупателя
                }
                countBuyers++;
            }
        }
    }
}
