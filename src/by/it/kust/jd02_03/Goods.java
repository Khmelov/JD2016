package by.it.kust.jd02_03;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tanya Kust on 21.06.2016.
 */
public class Goods {

    static Map<String, Integer> listOfGoodsAndPrices = new HashMap<String, Integer>() {   // перечень товаров маркета
        {
            this.put("Хлеб", 10000);
            this.put("Молоко", 15000);
            this.put("Масло", 20000);
            this.put("Мороженое", 10000);
        }
    };
}
