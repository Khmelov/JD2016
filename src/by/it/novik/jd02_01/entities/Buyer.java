package by.it.novik.jd02_01.entities;

import by.it.novik.jd02_01.interfaces.IBuyer;
import by.it.novik.jd02_01.utils.RandomCounter;

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

    public Buyer (int id, Supermarket sm, boolean pensioner) {
        this.id = id;
        this.basket = null;
        this.sm = sm;
        this.pensioner = pensioner;
        thread = new Thread(this);
        this.thread.setName("Покупатель № "+ id +" ");
        thread.start();

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
                int i = 0;
                Map.Entry<Good,Integer> goodTake = null; //Выбранный товар по соответствующей цене
                int randomGood = RandomCounter.countRandom(i,sm.getAllGoods().size()-1);
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
    public void payGoods() {

    }

    @Override
    public void exitOutMarket() {
        System.out.println(this + "вышел из магазина");
        sm.setCountBaskets(sm.getCountBuyers()+1);
        sm.decrementCountOfBuyers(this);
    }

    @Override
    public void run() {
            enterToMarket();
            takeBasket();
            chooseGoods();
            payGoods();
            exitOutMarket();
        }
}
