package by.it.belsky.jd02_03.TaskB;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by misha on 21.06.2016.
 */
public class Dispetcher {
        private static final int planCount=5;

        //члены класса для начала обслуживания
        static int countBuyers=0; //общий счетчик покупателей
        static boolean planComplete() {   //метод определяющий выполнение плана
            return countBuyers>=planCount;
        }
        //члены класса для завершения обслуживания
        //общий счетчик обслуженных покупателей
        static int countCompleteBuyers=0;

        //метод определяющий конец обслуживания
        static boolean finish() {
            return countCompleteBuyers>=planCount;
        }

        //Подсказка. Это еще один вариант общего счетчика обслуженных покупателей
        static AtomicInteger acountCompleteBuyers=new AtomicInteger(0);

        static int countCashiers=0; //общий счетчик кассиров

}
