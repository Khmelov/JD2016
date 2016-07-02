package by.it.kust.jd02_03;

/**
 * Created by user_2 on 10.06.2016.
 */
public class Buyer implements IBuyer,Runnable,IUseBasket {
    private int number;  // номер покупателя
    private boolean pensioner;  // пенсионер (в 2 раза медленнее)
    private int timeout;
    public static long goodsAmount;
    static boolean iWait = false;   // покупатель ожидает в очереди

    public Buyer(int number, boolean pensioner) {
        this.number = number;
        this.pensioner = pensioner;
        this.goodsAmount = 0;
    }

    @Override
    public String toString() {   // в строку имя покупателя и его номер
        if (!pensioner) {
            return "Buyer #" + number + " ";
        }else {
            return "Buyer #" + number + " пенсионер ";
        }
    }

    @Override
    public void run() {
            enterToMarket();
            takeBasket();
            chooseGoods();
            goodsAmount = putGoodsToBasket();
            goToQueue(goodsAmount);
            goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в маркет");
    }

    @Override
    public void takeBasket() {
        if (!pensioner){
            timeout = Rnd.fromTo(100,200);  // время для взятия корзины от 0,1 до 0,2 сек
        }else {
            timeout = Rnd.fromTo(100,200)*2;  // время для взятия корзины пенсионером в 2 раза медленнее
        }
        try {
            Thread.sleep(timeout);
            System.out.println(this + "взял корзину");
        } catch (InterruptedException e) {
            System.err.println(this + "Ошибка ожидания корзины");
        }
    }

    @Override
    public void chooseGoods() {
        if (!pensioner) {
            timeout = Rnd.fromTo(500, 2000);   // пауза на выбор товаров от 5 до 20 сек
        }else {
            timeout = Rnd.fromTo(500, 2000)*2;   // пауза на выбор товаров пенсионером в 2 раза медленнее
        }
        try {
            System.out.println(this + "выбирает товары");
            Thread.sleep(timeout);
        }catch (InterruptedException e){
            System.err.println(this + "Ошибка выбора товаров");
        }
    }

    @Override
    public long putGoodsToBasket() {
        if (!pensioner) {
            timeout = Rnd.fromTo(100, 200);   // время положить товары в корзину от 0,1 до 0,2 сек
        }else {
            timeout = Rnd.fromTo(100, 200);   // время положить товары в корзину пенсионером в 2 раза медленнее
        }
        try {
            Thread.sleep(timeout);
            System.out.print(this + "добавил товары в корзину: ");
            goodsAmount = Basket.goodsToBasket();
        } catch (InterruptedException e) {
            System.err.println(this + "Ошибка добавления товаров в корзину");
        }
        return goodsAmount;
    }

    public void goToQueue(long amount) {
        if (amount > 0) {
            synchronized (this) {
                QueueBuyers.add(this, pensioner);
                iWait = true;
                System.out.print(this + "стал в очередь.");
                System.out.print(" Сейчас в очереди " + QueueBuyers.buyersQueue.size() + " человек(а)\n");
                while (iWait == true) {
                    try {
                        wait();           // ожидаем notify от кассы
                        iWait = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // ожидание окончено, notify от кассира
                System.out.println(this + "покинул кассу");
            }
        } else {
            iWait = false;
            System.out.println(this + "направился к выходу");
            Manager.countCompleteBuyers.getAndIncrement();
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из маркета");
    }

}
