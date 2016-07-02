package by.it.sergeev.jd02_03;

import java.util.HashMap;
import java.util.Map;


/**
 * покупатель
 */
public class Buyer extends Thread implements Runnable,IBuyer, IUseBasket {

    private int num;
    private Basket basket;
    private boolean retired;
    private boolean waitInTheQueue = true;

    public Buyer(int num, boolean retired) {

        Manager.addCountBuyersIn();
        this.num = num;
        this.retired = retired;
        this.setName("Покупатель №" + num + " ");
        start();
    }

    public boolean isRetired() {
        return retired;
    }

    public int getNum() {
        return num;
    }

    public  void setWaitInTheQueue(boolean wait) {
        this.waitInTheQueue = wait;
    }

    public Map<String, Integer> getBacket() {
        return basket.getGoods();
    }


    @Override
    public void run (){
        enterMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        exitMarket();

    }

    @Override
    public String toString (){

        return this.getName();
    }

    @Override
    public void enterMarket(){

        System.out.println(this+" зашёл в магазин.");
    }

    @Override
    public void chooseGoods(){

        Map<String,Integer> buyerBacketMap = new HashMap<>();
        int goodsQuantity = Rnd.fromTo(1, 4);
        for (int i = 0; i < goodsQuantity; i++){

            String randomGood = Goods.takeRandomGood();
            putGoodsIntoBasket(randomGood);
            buyerBacketMap.put(randomGood, Goods.getPrice(randomGood));
        }
        basket = new Basket(buyerBacketMap, this.num);

        System.out.print(this+" выбрал товар "+(retired?",подумав некоторое время. ":"быстро. "));
        System.out.println(basket);
    }

    @Override
    public void exitMarket(){

        System.out.println(this+" вышел с магазина.");
    }

    @Override
    public void takeBasket() {
        int pause = retired? Rnd.fromTo(200, 500): Rnd.fromTo(300, 700);
        Utils.sleep(pause);
        System.out.println(this+" взял корзину.");
    }

    @Override
    public void putGoodsIntoBasket(String good) {
        int pause = retired? Rnd.fromTo(100, 200): Rnd.fromTo(150, 300);
        Utils.sleep(pause);
        System.out.println(this+" положил товар \""+good+"\" в корзину.");

    }


    @Override
    public void goToQueue()  {
        synchronized (this){
            QueueToPay.putBuyer(this);
            System.out.println(this + " пошёл в очередь.");
            while (waitInTheQueue){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
