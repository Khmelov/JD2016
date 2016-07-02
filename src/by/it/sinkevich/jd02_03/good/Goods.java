package by.it.sinkevich.jd02_03.good;

import by.it.sinkevich.jd02_03.utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for jd02_03
 *
 * @author Sinkevich Denis
 */
public class Goods {

    private static Map<String, Double> goodsAndPrices;

    static {
        goodsAndPrices = new HashMap<>();
        goodsAndPrices.put("Бухло", 1000.);
        goodsAndPrices.put("Закусь", 100.);
        goodsAndPrices.put("Запивон", 10.);
        goodsAndPrices.put("Что-то полезное", 1.);
    }

    public static Good chooseOneRandomGood() {
        int number = Utility.getTimeOut(0, goodsAndPrices.size() - 1);
        List<String> listForRandom = new ArrayList<>(goodsAndPrices.keySet());
        String goodName = listForRandom.get(number);
        return new Good(goodName);
    }

    static double getPriceOfGood(String name) {
        return goodsAndPrices.get(name);
    }
}
