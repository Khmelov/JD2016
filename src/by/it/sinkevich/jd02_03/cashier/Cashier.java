package by.it.sinkevich.jd02_03.cashier;

import by.it.sinkevich.jd02_03.buyer.Buyer;
import by.it.sinkevich.jd02_03.manager.Manager;
import by.it.sinkevich.jd02_03.superMarket.SuperMarket;
import by.it.sinkevich.jd02_03.utility.Utility;

/**
 * Class for jd02_03.
 * Класс описывает кассу супермаркета.
 *
 * @author Sinkevich Denis
 */
public class Cashier implements Runnable {

    private String name;

    public Cashier(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Касса №" + name;
    }

    @Override
    public void run() {
        System.out.println(this + " открылась.");
        while (Manager.servedCustomers < Manager.maximumServedCustomers) {
            Buyer customer = SuperMarket.serveBuyer();
            if (customer != null) {
                synchronized (customer) {
                    System.out.println(this + " начала обслуживание " + customer);
                    Utility.sleep(Utility.getTimeOut(5000, 7000));
                    Manager.servedCustomersLock.lock();
                    Manager.servedCustomers++;
                    Manager.servedCustomersLock.unlock();
                    Utility.synchroPrintln(this + " закончила обсдуживание " + customer +
                            "\nЧек:\n" + customer.getBasket().toString());
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Utility.sleep(500);
            }
        }
        System.out.println(this + " закончила работу!");
    }
}
