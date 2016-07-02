package by.it.kushel.jd02_03;

/**
 * Created by Diomn on 12.06.2016.
 */
public class Buyer extends Thread implements IBuyer {
    int numberOfBuyer;
    String name;
    boolean iWait=false;
    Buyer(int numberOfBuyer){
        this.numberOfBuyer=numberOfBuyer;
        name = "Покупатель №"+this.numberOfBuyer;
    }
    public String toString(){
        return name;
    }

    @Override
    public void start() {
        super.start();
    }

    public void run(){
        enterToMarket();
       chooseGoods();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(name+" зашел в магазин");

    }

    @Override
    public void chooseGoods() {
        try {
            sleep((long) (Math.random()*1000)+1);
            System.out.println(name+" выбрал товар");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
public void goToQueue() {
    synchronized(this) {
        System.out.println(this + " занял очередь в кассу");
        QueueBuyers.add(this);
        try {
            iWait=true;
            while (iWait){
            wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " расплатился");
    }
}


    @Override
    public void goToOut() {
        System.out.println(name+" вышел из магазина");

    }
}
