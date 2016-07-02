package by.it.kust.jd02_01;

/**
 * Created by user_2 on 10.06.2016.
 */
public class Buyer implements IBuyer,Runnable,IUseBasket {
    private int number = 0;

    public Buyer(int number) {
        this.number = number;
    }

    // реализация интерфейсов
    @Override
    public void enterToMarket() {
        System.out.println(this + " entered the market");
    }

    @Override
    public void chooseGoods() {
        int timeout = Rnd.getTimeOut(500,2000);   // пауза на выбор товаров от 5 до 20 сек
        try {
            Thread.sleep(timeout);
            System.out.println(this + "chose goods");
        }catch (InterruptedException e){
            System.err.println(this + "Incorrect waiting time");
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + "leaved the market");
    }

    @Override
    public String toString() {   // в строку имя покупателя и его номер
        return "Buyer #" + number+" ";
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToOut();
    }

    @Override
    public void takeBasket() {
        int timeoutBasket = Rnd.getTimeOut(100,200);  // время для взятия корзины от 0,1 до 0,2 сек
        try {
            Thread.sleep(timeoutBasket);
            System.out.println(this + "took the basket");
        } catch (InterruptedException e) {
            System.err.println(this + "Incorrect waiting for basket time");
        }

    }

    @Override
    public void putGoodsToBasket() {
        int timeoutGoodsToBasket = Rnd.getTimeOut(100,200);   // время положить товары в корзину от 0,1 до 0,2 сек
        try {
            Thread.sleep(timeoutGoodsToBasket);
            System.out.println(this + "put goods to basket");
            Basket.goodsToBasket();
        } catch (InterruptedException e) {
            System.err.println(this + "Incorrect waiting for time (putting goods to basket");
        }

    }
}
