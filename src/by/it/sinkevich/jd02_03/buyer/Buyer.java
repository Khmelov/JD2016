package by.it.sinkevich.jd02_03.buyer;

import by.it.sinkevich.jd02_03.basket.Basket;
import by.it.sinkevich.jd02_03.good.Good;
import by.it.sinkevich.jd02_03.good.Goods;
import by.it.sinkevich.jd02_03.superMarket.SuperMarket;

import static by.it.sinkevich.jd02_03.utility.Utility.*;

/**
 * Class for jd02_03
 *
 * @author Sinkevich Denis
 */
public class Buyer implements IBuyer, IUseBasket, Runnable {

    private String name;
    private Basket basket;
    private boolean isPensioneer = false;
    private boolean isWaiting = false;

    public Buyer() {
        int number = SuperMarket.customersCount.incrementAndGet();
        name = "Покупатель №" + number;
        if (getTimeOut(1, 4) % 4 == 0) {
            isPensioneer = true;
        }
    }

    @Override
    public void enterToMarket() {
        int buyersQuantity = SuperMarket.customersQuantity.incrementAndGet();
        StringBuilder stringBuilder = new StringBuilder(this + " входит в магазин.");
        stringBuilder.append(" Всего покупателей: ").append(buyersQuantity).append(".");
        if (isPensioneer) {
            stringBuilder.append("\n").append(this).append(" пенсионер");
        }
        synchroPrintln(stringBuilder.toString());
    }

    @Override
    public Good chooseGoods() {
        double k = 1;
        if (isPensioneer) {
            k = 1.5;
        }
        sleep(getTimeOut((int) (5000 * k), (int) (7000 * k)));
        return Goods.chooseOneRandomGood();
    }

    @Override
    public void exitFromMarket() {
        int buyersQuantity = SuperMarket.customersQuantity.decrementAndGet();
        synchroPrintln(this + " выходит из магазина. Всего покупателей в магазине: " + buyersQuantity + ".");
    }

    @Override
    public void takeBasket() {
        double k = 1;
        if (isPensioneer) {
            k = 1.5;
        }
        sleep(getTimeOut((int) (k * 500), (int) (k * 1000)));
        basket = new Basket();
        System.out.println(this + " берёт корзинку.");
    }

    @Override
    public synchronized void goToQueue() {
        System.out.println(this + " встаёт в очередь.");
        SuperMarket.goToQueue(this);
        isWaiting = true;
        while (isWaiting) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Поток был прерван во время ожидания в очереди!");
            }
        }
    }

    @Override
    public void putGoodsToBasket(Good good) {
        double k = 1;
        if (isPensioneer) {
            k = 1.5;
        }
        sleep(getTimeOut((int) (k * 250), (int) (k * 500)));
        basket.addGoodInBasket(good);
        System.out.println(this + " кладёт " + good + " в корзину.");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        int numberOfGoods = getTimeOut(1, 4);
        for (int i = 0; i < numberOfGoods; i++) {
            Good good = chooseGoods();
            putGoodsToBasket(good);
        }
        goToQueue();
        exitFromMarket();
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }

    public Basket getBasket() {
        return basket;
    }

    @Override
    public String toString() {
        return name;
    }
}
