package by.it.sergeev.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * продукты
 */
public class Goods {

    static Map<String, Integer> goodsMap = Utils.putGoodsFromFileIntoMap();

    public static String takeRandomGood (){

        List<String> goodsList = new ArrayList<>(goodsMap.keySet());
        return goodsList.get(Rnd.fromTo(0, goodsList.size() - 1));

    }


    public static Integer getPrice (String product){

        for (Map.Entry<String, Integer> entry : goodsMap.entrySet()) {
            if (entry.getKey().equals(product)) return entry.getValue();
        }
        return null;

    }
}