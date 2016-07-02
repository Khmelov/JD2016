package by.it.kushel.jd02_03;

/**
 * Created by Diomn on 19.06.2016.
 */
public class Cashier implements Runnable {
    String name;
    int countOfCashier;

    Cashier(int countOfCashier) {
        name = "Кассир №"+ countOfCashier;
    }
public String toString(){
    return name;
}
    public void run() {

        while (true) {
            Buyer buyer = QueueBuyers.poll();
            if (buyer != null) {
                synchronized (buyer) {
                    System.out.println(name + " обслуживает покупателя №" + buyer);
                    try {
                        Thread.sleep((long) (Math.random() * 2000) + 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this + " обслужил покупателя" + buyer);
                    buyer.iWait = false;
                    buyer.notify();
                }

            } else {

                try {
                    System.out.println(this + " свободен");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
