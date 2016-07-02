package by.it.sinkevich.jd02_03.superMarket;

import by.it.sinkevich.jd02_03.buyer.Buyer;
import by.it.sinkevich.jd02_03.cashier.Cashier;
import by.it.sinkevich.jd02_03.manager.Manager;
import by.it.sinkevich.jd02_03.utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class for jd02_03.
 * Класс описывает супермаркет.
 *
 * @author Sinkevich Denis
 */
public class SuperMarket implements Runnable {

    private String name;
    private final static ConcurrentLinkedQueue<Buyer> customers = new ConcurrentLinkedQueue<>();
    public static AtomicInteger customersCount;
    public static AtomicInteger customersQuantity;
    private List<Cashier> cashiers;
    private Manager manager;

    public SuperMarket(String marketName, Manager manager) {
        name = marketName;
        customersCount = new AtomicInteger(0);
        customersQuantity = new AtomicInteger(0);
        cashiers = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            cashiers.add(new Cashier(String.valueOf(i + 1)));
        }
        this.manager = manager;
    }

    @Override
    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(cashiers.get(i));
        }
        int timer = 0;
        while (customersCount.get() < Manager.maximumServedCustomers) {
            int enteringBuyers = Utility.getTimeOut(1, 3);
            //Метод уточняет количество входящих покупателей при граничных значениях
            enteringBuyers = clarifyNumberOfEntrants(timer, enteringBuyers);
            for (int buyers = 0; buyers < enteringBuyers; buyers++) {
                if (customersCount.get() == Manager.maximumServedCustomers) {
                    break;
                }
                Buyer buyer = new Buyer();
                Thread thread = new Thread(buyer);
                thread.start();
                Thread.yield();
            }
            Utility.sleep(1000);
            timer++;
            if (timer % 60 == 0) {
                timer = 0;
            }
        }
        executor.shutdown();
        System.out.println(this + " закончил работу!");
    }

    public static boolean goToQueue(Buyer buyer) {
        boolean succes = customers.add(buyer);
        Utility.synchroPrintln("Размер очереди: " + customers.size());
        return succes;
    }

    public static Buyer serveBuyer() {
        if (customers.isEmpty()) return null;
        else return customers.poll();
    }

    private int clarifyNumberOfEntrants(int timerState, int enteringBuyers) {
        int buyersQuantity = customersQuantity.get();
        if (timerState < 30) {
            if (buyersQuantity >= 40) {
                enteringBuyers = 0;
            } else {
                int nextQuantity = buyersQuantity + enteringBuyers;
                if (nextQuantity > 40) {
                    enteringBuyers = 40 - buyersQuantity;
                }
            }
        } else {
            if (buyersQuantity >= 40 + 30 - timerState) {
                enteringBuyers = 0;
            } else {
                int nextQuantity = buyersQuantity + enteringBuyers;
                if (nextQuantity > 40) {
                    enteringBuyers = 40 - buyersQuantity;
                }
            }
        }
        return enteringBuyers;
    }

    @Override
    public String toString() {
        return "Супермаркет " + name;
    }
}
