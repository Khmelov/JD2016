package by.it.belsky.jd02_03.TaskB;

/**
 * Created by misha on 21.06.2016.
 */
public class Cashier implements Runnable {
    private int num; //номер кассира

    public Cashier() {
        this.num = ++Dispetcher.countCashiers;
    }

    @Override
    public String toString() {
        return "Кассир-"+num;
    }

    @Override
    public void run() {
        //кассир начинает работу сразу
        System.out.println(this+" открыл кассу");
        //и закончит ее когда покупатели по плану будут обслужены
        while (!Dispetcher.finish()) {
            //получим покупателя из очереди. Поскольку очередь потокобезопасна
            //то дополнительная синхронизация не требуется.
            Buyer buyer=Queue.poll();
            if (buyer!=null) //есть клиент, обслуживание
                synchronized (buyer) {
                    System.out.println(this+" обслуживает клиента: "+buyer);
                    Help.sleep(Help.fromTo(2000, 5000));
                    System.out.println(this + " обслужил клиента: " + buyer);
                    //увеличим счетчик обслуженных клиентов
                    //вот такой счетчик будет работать с ошибкой
                    Dispetcher.countCompleteBuyers++;
                    //а вот так, уже правильно. Подумайте почему?
                    Dispetcher.acountCompleteBuyers.incrementAndGet();
                    buyer.iWait=false;
                    buyer.notify(); //отдаем блокировку обратно покупателю
                }
            else //если еще никто не дошел, подождем секунду
                Help.sleep(1000);
        }
        System.out.println(this+" закрыл кассу");
    }

}
