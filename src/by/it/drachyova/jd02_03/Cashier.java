package by.it.drachyova.jd02_03;

public class Cashier implements Runnable {
    private int number;

    public Cashier() {
        this.number = Manager.countCashiers.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Кассир " + number;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу");
        while (!(Manager.countCompleteBuyers.intValue() == 100)) {
            Buyer buyer = QueueBuyers.poll();
            if (buyer != null)
                synchronized (buyer) {
                    System.out.println(this + " обслуживает клиента: " + buyer);
                    Utils.sleep(Utils.getMyRandom(2000, 5000));
                    System.out.println(this + " обслужил клиента: " + buyer);
                    Manager.countCompleteBuyers.incrementAndGet();
                    buyer.isWait = false;
                    buyer.notify();
                }
            else
                Utils.sleep(1000);
        }
        System.out.println(this + " закрыл кассу");
    }

}
