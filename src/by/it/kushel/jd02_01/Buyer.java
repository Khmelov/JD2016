package by.it.kushel.jd02_01;

/**
 * Created by Diomn on 12.06.2016.
 */
public class Buyer extends Thread implements IBuyer {
    int numberOfBuyer;
    String name;
    Buyer(int numberOfBuyer){
        this.numberOfBuyer=numberOfBuyer;
        name = "Покупатель №"+this.numberOfBuyer;
    }

    @Override
    public void start() {
        super.start();
    }

    public void run(){
        enterToMarket();
       chooseGoods();
       goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(name+"зашел в магазин");

    }

    @Override
    public void chooseGoods() {
        try {
            sleep((long) (Math.random()*1000)+1);
            System.out.println(name+"выбрал товар");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goToOut() {
        System.out.println(name+"вышел из магазина");

    }
}
