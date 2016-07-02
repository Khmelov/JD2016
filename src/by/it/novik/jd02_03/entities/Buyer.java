package by.it.novik.jd02_03.entities;

import by.it.novik.jd02_03.interfaces.IBuyer;
import by.it.novik.jd02_03.utils.RandomCounter;

import java.util.Map;


/**
 * Created by Kate Novik.
 */
public class Buyer implements IBuyer, Runnable  {
    //Поле id окупателя
    private int id;
    //Поле пенсионер
    private boolean pensioner;
    //Поле корзинка
    private Basket basket;
    //Поле объекта супермаркет
    private final Supermarket sm;
    //Поле потока
    private Thread thread;
    //Флаг того, что покупатель в ожидании
    public boolean iWait=false; //флаг того, что покупатель в ожидании

    public Buyer (int id, Supermarket sm, boolean pensioner) {
        this.id = id;
        this.basket = null;
        this.sm = sm;
        this.pensioner = pensioner;
        thread = new Thread(this);
        this.thread.setName("Покупатель № "+ id +" ");
        thread.start();

    }

    public boolean isPensioner() {
        return pensioner;
    }

    public Basket getBasket() {
        return basket;
    }

    /**
     * Метод возвращения строкового представления покупателя
     * @return строковое представление покупателя
     */
    @Override
    public String toString() {
        return this.thread.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");
    }

    @Override
    public void takeBasket() {
        try {
            //Вызываем метод с генератором случайных чисел для генерации числа в промежутке от 100 до 200 мс
            int pause = RandomCounter.countRandom(100,200);
            Thread.sleep(pause);
            if (pensioner) {
                Thread.sleep(pause/2);
            }
            basket = sm.decrementBaskets();
            if ( basket != null) {
                System.out.println(this + "взял корзину");
            } else {
                System.out.println(this + "не взял корзину");
            }
        }
        catch (InterruptedException e) {
            System.out.println(this + " : некорректное завершение ожидания!");
        }
    }

    @Override
    public void chooseGoods() {
        try {
            //Максимальное количество товаров, положенных в корзину
            int maxGoods = RandomCounter.countRandom(1,4);
            while (maxGoods != 0) {
            //Вызываем метод с генератором случайных чисел для генерации числа в промежутке от 500 до 2000 мс
            int pause1 = RandomCounter.countRandom(500,2000);
            Thread.sleep(pause1); //Останавливаем поток на время pause1 для выбора товара
                if (pensioner) {
                    Thread.sleep(pause1/2);
                }
                //Выбирем случайный товар в магазине
                int i = 1;
                Map.Entry<Good,Integer> goodTake = null; //Выбранный товар по соответствующей цене
                int randomGood = RandomCounter.countRandom(i,sm.getAllGoods().size());
                for (Map.Entry<Good,Integer> set : sm.getAllGoods().entrySet()) {
                    if (i == randomGood) {
                        goodTake = set;
                        break;
                    }
                    i++;
                }
                System.out.println(this + " выбрал товар.");
                //Вызываем метод с генератором случайных чисел для генерации числа в промежутке от 100 до 200 мс
                int pause2 = RandomCounter.countRandom(100,200);
                Thread.sleep(pause2); //Останавливаем поток на время pause2, чтобы положить товар в корзину
                if (pensioner) {
                    Thread.sleep(pause2/2);
                }
                if (goodTake != null) {
                    basket.putGoodInBasket(goodTake.getKey(), goodTake.getValue());
                    System.out.println(this + " положил товар " + goodTake.getKey().toString() + " = " + goodTake.getValue().toString() + " в корзину");
                }
                maxGoods--;
            }

        }
        catch (InterruptedException e) {
            System.out.println(this + " : некорректное завершение ожидания!");
        }

    }

    @Override
    public void standInQueue() {
        sm.addBuyerInQueueCashRegister(this); //Добавление в очередь
        System.out.println("Покупатель " + this + " стал в очередь");
        synchronized (this) {
            iWait=true;
            while (iWait) {
                try { //ожидаем notify и iWait==false от кассира.
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.println(this + " : некорректное завершение ожидания в очереди!");
                }
            }
        }

    }

    @Override
    public void payGoods() {
        System.out.println(this + " на кассе");
        synchronized (this) {
            iWait=true;
            while (iWait) {
                try { //ожидаем notify и iWait==false от кассира.
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.println(this + " : некорректное завершение ожидания в очереди!");
                }
            }
        }
        System.out.println(this + "оплатил товары в кассе");
    }

    @Override
    public void exitOutMarket() {
        System.out.println(this + "вышел из магазина");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sm.setCountBaskets(sm.getCountBaskets()+1);
        sm.decrementCountOfBuyers(this);
        //System.err.println("count " + sm.getCountBuyers());
    }

    @Override
    public void run() {
            enterToMarket();
            takeBasket();
            chooseGoods();
            standInQueue();
            payGoods();
            exitOutMarket();
        }
}
