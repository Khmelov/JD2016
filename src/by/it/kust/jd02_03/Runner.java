package by.it.kust.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Tanya Kust.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Маркет открывается");
        ExecutorService executor = Executors.newFixedThreadPool(5);   // подготавливаем 5 касс
        for (int i = 1; i <= 5; i++){
            executor.execute(new Cashier(i));   // открываем кассы
        }
        Manager.openMarketDoor();  // впускаем покупателей
        while (Manager.countCompleteBuyers.get() <= Manager.limitOfBuyers) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Ошибка ожидания выполнения лимита маркета " + e);
            }
            if (Manager.countCompleteBuyers.get() == Manager.limitOfBuyers){
                    try {
                        Thread.sleep(2000);  // дает время выйти последним покупателям
                    } catch (InterruptedException e) {
                        System.err.println("Ошибка ожидания обслуживания последних покупателей " + e);
                    }
                    executor.shutdown();
                    System.out.println("Все кассы закрыты");
                    break;
                }
        }

        //System.out.println("Количество активных потоков = " + Thread.activeCount());
        System.out.println("Всего вошло покупателей " + Manager.countTotalBuyers);
        System.out.println("Всего вышло покупателей  " + Manager.countCompleteBuyers);
        System.out.println("Общая выручка магазина = " + Basket.marketProfit);
    }

}
