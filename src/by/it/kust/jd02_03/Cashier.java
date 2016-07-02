package by.it.kust.jd02_03;

/**
 * Created by Tanya Kust.
 */
public class Cashier implements Runnable {
    private int num;   // номер кассы
    public Cashier(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Касса №" + num + " ";
    }

    @Override
    public void run() {
        System.out.println(this + " готова к работе ");
        while (Manager.countCompleteBuyers.get()<=Manager.limitOfBuyers){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Buyer buyer = QueueBuyers.poll();   // берем покупателя из очереди
            if (buyer!=null){
                synchronized (buyer){
                    System.out.println(this + " обслуживание клиента " + buyer);
                    try {
                        Thread.sleep(Rnd.fromTo(2000,5000));   // касса обслуживает клиента
                    } catch (InterruptedException e) {
                        System.err.println("Ошибка обсуживания у кассы " + e);
                    }
                    System.out.println(this + " завершено обслуживание клиента " + buyer);
                    Manager.countCompleteBuyers.getAndIncrement();
                    buyer.notify();
                }
            }else {
                try {
                    Thread.sleep(500);   // ждем пополнения очереди
                    if (Manager.countCompleteBuyers.get() == Manager.limitOfBuyers){
                        break;
                    }
                } catch (InterruptedException e) {
                    System.err.println("Ошибка ожидания пополнения очереди " + e);
                }
            }
        }
        System.out.println(this + " закрыта.");
    }
}
