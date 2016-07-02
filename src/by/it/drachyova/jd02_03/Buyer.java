package by.it.drachyova.jd02_03;

public class Buyer implements IBuyer, IUseBasket, Runnable {
    int number;                                                            //номер покупателя
    String name;                                                           //имя покупателя
    boolean isPensioner = false;                                             //является ли пенсионером
    public boolean isWait = false;                                           //ожидает ли своей очереди

    public Buyer() {                                                        //конструктор для покупателя
        this.number = Manager.countBuyers.incrementAndGet();
        if (number % 4 == 0) {                                                   //каждый четвертый пенсионер
            isPensioner = true;
        }
        this.name = "Покупатель " + number;
        Thread thread = new Thread(this);
        thread.start();
    }


    public String toString() {
        return this.name;
    }

    @Override
    public void enterToMarket() {// войти в магазин (мгновенно)
        System.out.println(this + " вошел в магазин.");
    }

    @Override
    public void takeBasket() {                                              // взять корзину (от 0.1 до 0.2 секунды)
        int timeOut = Utils.getMyRandom(100, 200);
        try {
            if (!isPensioner) {
                Thread.sleep(timeOut);
            } else {
                Thread.sleep(timeOut * 2);                                  //если пенсионер в 2 раза медленее
            }
            System.out.println(this + " взял корзину.");
        } catch (InterruptedException e) {
            System.out.println(this + " не смог взять корзину." + e.getMessage());
        }
    }

    @Override
    public void chooseGoods() {                                            //выбрать товар (от 0,5 до 2 секунд)
        int timeOut = Utils.getMyRandom(500, 2000);
        try {
            if (!isPensioner) {
                Thread.sleep(timeOut);
            } else {
                Thread.sleep(timeOut * 2);                                     //если пенсионер в 2 раза медленее
            }
            System.out.println(this + " выбрал товар.");
        } catch (InterruptedException e) {
            System.out.println(this + " не смог выбрать товар." + e.getMessage());
        }
    }

    @Override
    public void putGoodsToBasket() {                     //положить выбранный товар в корзину (от 0.1 до 0.2 секунды)
        int timeOut = Utils.getMyRandom(100, 200);
        try {
            if (!isPensioner) {
                Thread.sleep(timeOut);
            } else {
                Thread.sleep(timeOut * 2);                                  //если пенсионер в 2 раза медленее
            }
            System.out.println(this + " положил товар в корзину: ");
            Basket.fillBasket();
        } catch (InterruptedException e) {
            System.out.println(this + " не смог положить товар в корзину." + e.getMessage());
        }
    }

    @Override
    public void goToQueue() {                                               //встать в очередь на кассу
        synchronized (this) {
            System.out.println(this + " встал в очередь на кассу");
            QueueBuyers.add(this);
            isWait = true;
            while (isWait) try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this + " закончил оплату товаров в кассе");
        }
    }

    @Override
    public void goToOut() {//отправился на выход(мгновенно)
        System.out.println(this + " вышел из магазина.");
    }      //выйти из магазина

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goToOut();

    }
}
