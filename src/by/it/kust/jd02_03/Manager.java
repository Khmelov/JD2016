package by.it.kust.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Tanya Kust.
 */
public class Manager {
    final static AtomicInteger countTotalBuyers = new AtomicInteger(0);   // общее кол-во покупателей
    final static AtomicInteger countCompleteBuyers = new AtomicInteger(0);  // кол-во покупателей на выход из магазина
    static int limitOfBuyers = 100;  // лимит покупателей

    /**
     * впускаем покупателей в магазин
     */
    public static void openMarketDoor(){
        boolean pensioner = false;
        while (countTotalBuyers.get()<limitOfBuyers){   // кол-во покупателей 100
            try {
                Thread.sleep(500);       // пауза 0,5 сек
            } catch (InterruptedException e) {
                System.err.println("Ошибка ожидания входа новых покупателей в магазин " + e);
            }
            int buyersIn = Rnd.fromTo(0,2);   // кол-во входящих покупателей за 1 раз (0 1 2)
            for (int j = 0; j< buyersIn; j++){
                countTotalBuyers.getAndIncrement();
                if (countTotalBuyers.get()%4==0){pensioner=true;}
                Buyer buyer = new Buyer(countTotalBuyers.get(),pensioner);
                Thread thBuyer = new Thread(buyer);
                thBuyer.start();
                pensioner = false;
                if (countTotalBuyers.get() == limitOfBuyers){
                    break;
                }
            }
        }
        System.out.println("Вошел 100-й покупатель. Лимит покупателей исчерпан. Не впускаем больше покупателей в магазин!");
    }
}
