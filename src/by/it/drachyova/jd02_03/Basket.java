package by.it.drachyova.jd02_03;

import by.it.drachyova.jd02_03.Utils;

import java.util.HashMap;

//У каждого покупателя набор из 1..4 товаров из фиксированного списка с ценой
// (рекомендуется hashmap, где товар – key, цена – value).
// Товары с ценой были выведены на консоль в процессе обслуживания.
// Выведена общая сумма чека.

public class Basket {
    static HashMap<String, Integer> fillBasket() {
        int quantityOfGoods = Utils.getMyRandom(1, 4);
        HashMap<String, Integer> basket = new HashMap<>(quantityOfGoods);
        switch (quantityOfGoods) {
            case 1:
                basket.put("хлеб", 15000);
                System.out.println(basket);
                System.out.println("Итого 15000 рублей.");
                break;
            case 2:
                basket.put("кефир", 12000);
                basket.put("молоко", 11000);
                System.out.println(basket);
                System.out.println("Итого 23000 рублей.");
                break;
            case 3:
                basket.put("хлеб", 15000);
                basket.put("молоко", 11000);
                basket.put("сыр", 50000);
                System.out.println(basket);
                System.out.println("Итого 76000 рублей.");
                break;
            case 4:
                basket.put("хлеб", 15000);
                basket.put("молоко", 11000);
                basket.put("рыба", 90000);
                basket.put("мясо", 120000);
                System.out.println(basket);
                System.out.println("Итого 6000 рублей.");
        }
        return basket;
    }

}
