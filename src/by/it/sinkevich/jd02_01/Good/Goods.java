package by.it.sinkevich.jd02_01.Good;

import by.it.sinkevich.jd02_01.Utility.Utility;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for jd02_01
 *
 * @author Sinkevich Denis
 */
public class Goods {

    private static Map<String, Integer> goodsAndPrices;

    static {
        goodsAndPrices = new HashMap<>();
        goodsAndPrices.put("бухло", 1000);
        goodsAndPrices.put("закусь", 100);
        goodsAndPrices.put("запивон", 10);
        goodsAndPrices.put("что-то полезное", 1);
    }

    public static Good chooseOneRandomGood() {
        int number = (int) Utility.getTimeOut(0, goodsAndPrices.size() - 1);
        switch (number) {
            case 0:
                return new Good("бухло", goodsAndPrices.get("бухло"));
            case 1:
                return new Good("закусь", goodsAndPrices.get("закусь"));
            case 2:
                return new Good("запивон", goodsAndPrices.get("запивон"));
            default:
                return new Good("что-то полезное", 1);
        }
    }
}
