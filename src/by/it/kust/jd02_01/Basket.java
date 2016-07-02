package by.it.kust.jd02_01;

import java.util.*;

/**
 * Created by Tanya Kust on 18.06.2016.
 */
public class Basket {
    public static void goodsToBasket() {
        Map<String, Integer> listOfGoods = new HashMap<String, Integer>() {   // перечень товаров маркета
            {
                this.put("Хлеб", 8000);
                this.put("Молоко", 10000);
                this.put("Масло", 17000);
                this.put("Мороженое", 7000);
            }
        };

        int size = Rnd.getNbrOfGoods(listOfGoods.size());   // случ.число - кол-во выбранных товаров (0,1,2,3,4)
        Map<String, Integer> goodsChosen = new HashMap<String, Integer>(size);  // карта для хранения выбранных товаров

        // получим случайные товары из списка и поместим их в новую карту
        for (int i=0; i<size; i++) {
            Object[] rndGoods = listOfGoods.keySet().toArray();
            Object key = rndGoods[new Random().nextInt(rndGoods.length)];
            if (!goodsChosen.containsKey(key)) {  // если такого товара еще нет в корзине, добавляем
                goodsChosen.put((String) key, listOfGoods.get(key));
            }else{        // если такой товар уже есть, то добавляем, увеличив его итоговую стоимость
                Integer newValue = listOfGoods.get(key)+listOfGoods.get(key);
                goodsChosen.put((String)key,newValue);
            }
        }
        System.out.println(goodsChosen);  // распечатаем выбранные покупателем товары с их ценой
    }

}
