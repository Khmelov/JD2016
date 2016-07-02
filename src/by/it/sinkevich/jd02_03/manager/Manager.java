package by.it.sinkevich.jd02_03.manager;

import by.it.sinkevich.jd02_03.superMarket.SuperMarket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class for jd02_03.
 * Класс описыввает менеджера супермаркета, который открывает и закрывает супермаркет,
 * может добавлять и удалять кассы.
 *
 * @author Sinkevich Denis
 */
public class Manager {

    public static final Lock servedCustomersLock = new ReentrantLock();
    public static final int maximumServedCustomers = 50;
    public static int servedCustomers = 0;
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public static void openSuperMarket(String marketName, Manager manager) {
        System.out.println(manager + " открывает супермаркет \"" + marketName + "\"!");
        new Thread(new SuperMarket(marketName, manager)).start();
    }

    @Override
    public String toString() {
        return "Менеджер " + name;
    }
}
