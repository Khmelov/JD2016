package by.it.kust.jd02_03;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Tanya Kust.
 */
public class Basket {
    public static AtomicLong marketProfit = new AtomicLong(0);  // общая выручка магазина

    /**
     * покупатель кладет товары в корзину
     * @return сумму выбранных товаров
     */
    public static long goodsToBasket() {
        Map<String, Integer> goods = Goods.listOfGoodsAndPrices;  //  все товары магазина с ценами
        long totalAmount = 0;  // общая сумма выбранных товаров
        int goodsQuantity = Rnd.fromTo(0,goods.size());   // кол-во выбранных товаров (0,1,2,3)
        List<String> goodsChosen = new ArrayList<>();  // список выбранных покупателем товаров

        // получим случайные товары из списка и поместим их с ценами в новый список
        for (int i=0; i<goodsQuantity; i++) {
            Object[] rndGoods = goods.keySet().toArray();
            Object item = rndGoods[new Random().nextInt(rndGoods.length)];
            goodsChosen.add(i, item + " " + goods.get(item));
            totalAmount+=goods.get(item);
        }
        marketProfit.getAndAdd(totalAmount);
        if (!goodsChosen.isEmpty()) {
            System.out.print(goodsChosen + " Общая сумма товаров = " + totalAmount + "\n");  // выводим выбранные товары с ценой
            return totalAmount;
        }else {
            System.out.print(" Ничего не выбрано. Корзина пуста!" + "\n");
            return 0;
        }
    }

}
