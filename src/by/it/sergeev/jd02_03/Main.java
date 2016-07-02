package by.it.sergeev.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main (String [] args) throws InterruptedException {
        final int maxQueue = 40;
        //создаём пулл на пять потоков для касс
        ExecutorService executor= Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            executor.execute(new Cashier(i));
        }
        executor.shutdown();

        int countBuyers = 0;
        while (Manager.countBuyersIn < Manager.planBuyers){
            //как часто заходят покупатели в начале и в конце минуты
            Utils.sleep(Utils.howlongToSleep());
            //создаём нового покупателя
            if (QueueToPay.queueToPay.size() < maxQueue)
            {
            countBuyers = Utils.createNewBuyer(countBuyers);}
            else
            {
                Thread.sleep(1000);
            }
        }


        Thread.sleep(50000);
        System.out.println("Общая стоимость: "+ Profit.getTotalProfit());
        System.out.println("Каждая стоимость кассира: "+ Profit.getEachCashierProfit());
    }
}

