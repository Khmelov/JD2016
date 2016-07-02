package by.it.sinkevich.jd02_03.basket;

import by.it.sinkevich.jd02_03.good.Good;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for jd02_03
 *
 * @author Sinkevich Denis
 */
public class Basket {

    private List<Good> basket;

    public Basket() {
        basket = new ArrayList<>();
    }

    public void addGoodInBasket(Good good) {
        basket.add(good);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        double summaryPrice = 0;
        for (Good good : basket) {
            stringBuilder.append(good.getName()).append(" = ").append(good.getPrice()).append("\n");
            summaryPrice += good.getPrice();
        }
        stringBuilder.append("Сумма чека: ").append(summaryPrice);
        return stringBuilder.toString();
    }
}
