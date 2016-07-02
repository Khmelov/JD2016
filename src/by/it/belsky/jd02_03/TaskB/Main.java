package by.it.belsky.jd02_03.TaskB;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by misha on 21.06.2016.
 */
public class Main {
    public static void main(String[ ] args) {
        //открываем и "по новому" запускаем пул из 2 касс (но сам пул рассчитан на 5)
        ExecutorService executor= Executors.newFixedThreadPool(5);
        executor.execute(new Cashier()); //это класс, реализующий Runnable
        executor.execute(new Cashier()); //это класс, реализующий Runnable

        //теперь "по старинке" запускаем покупателей
        while (!Dispetcher.planComplete()) {
            Help.sleep(1000); //ожидание в 1 секунду
            int count= Help.fromTo(0, 2); //сколько приходит покупателей: 0 1 2
            for (int i = 0; i <= count; i++) {
                new Buyer();
                if (Dispetcher.planComplete())
                    break;
            }
        }
        //после завершения всех потоков касс остановим всё
        executor.shutdown();

    }
}
