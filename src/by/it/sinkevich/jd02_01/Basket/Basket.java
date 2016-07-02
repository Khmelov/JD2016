package by.it.sinkevich.jd02_01.Basket;

import by.it.sinkevich.jd02_01.Good.Good;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for jd02_01
 *
 * @author Sinkevich Denis
 */
public class Basket {

    private List<Good> basket = new ArrayList<>();

    public void addGoodInBasket(Good good) {
        basket.add(good);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Good good : basket) {
            stringBuilder.append(good.toString()).append(", ");
        }
        return stringBuilder.toString();
    }
}
