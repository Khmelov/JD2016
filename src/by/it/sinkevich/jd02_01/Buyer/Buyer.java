package by.it.sinkevich.jd02_01.Buyer;

import by.it.sinkevich.jd02_01.Basket.Basket;
import by.it.sinkevich.jd02_01.Good.Good;
import by.it.sinkevich.jd02_01.Good.Goods;
import by.it.sinkevich.jd02_01.Utility.Utility;

/**
 * Class for jd02_01
 *
 * @author Sinkevich Denis
 */
public class Buyer implements IBuyer, IUseBasket, Runnable {

    private String name;
    private Basket basket;
    private boolean isPensioneer = false;

    public Buyer() {
        int number = ++Utility.buyersCount;
        name = "Покупатель №" + number;
        if (Utility.getTimeOut(1, 4) % 4 == 0) {
            isPensioneer = true;
        }
    }

    @Override
    public void enterToMarket() {
        int buyersQuantity = ++Utility.buyersQuantity;
        System.out.println(this + " входит в магазин. Всего покупателей: " + buyersQuantity + ".");
        if (isPensioneer()) {
            System.out.println("Он пенсионер!");
        }
    }

    @Override
    public Good chooseGoods() {
        try {
            double k = 1;
            if (isPensioneer()) {
                k = 1.5;
            }
            Thread.sleep(Utility.getTimeOut((long) (5000 * k), (long) (7000 * k)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Good good = Goods.chooseOneRandomGood();
        System.out.println(this + " выбирает " + good);
        return good;
    }

    @Override
    public void exitFromMarket() {
        int buyersQuantity = --Utility.buyersQuantity;
        System.out.println(this + " выходит из магазина, он купил " + showAllGoods() + "всего покупателей " + buyersQuantity + ".");
    }

    @Override
    public void takeBasket() {
        try {
            double k = 1;
            if (isPensioneer()) {
                k = 1.5;
            }
            Thread.sleep(Utility.getTimeOut((long) (k * 500), (long) (k * 1000)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basket = new Basket();
        System.out.println(this + " берёт корзинку.");
    }

    @Override
    public void putGoodsToBasket(Good good) {
        try {
            double k = 1;
            if (isPensioneer()) {
                k = 1.5;
            }
            Thread.sleep(Utility.getTimeOut((long) (k * 250), (long) (k * 500)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basket.addGoodInBasket(good);
        System.out.println(this + " кладёт " + good + " в корзину.");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        int numberOfGoods = (int) Utility.getTimeOut(1, 4);
        for (int i = 0; i < numberOfGoods; i++) {
            Good good = chooseGoods();
            putGoodsToBasket(good);
        }
        exitFromMarket();
    }

    private Basket showAllGoods() {
        return basket;
    }

    @Override
    public String toString() {
        return name;
    }

    private boolean isPensioneer() {
        return isPensioneer;
    }
}
