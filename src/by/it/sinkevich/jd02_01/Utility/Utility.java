package by.it.sinkevich.jd02_01.Utility;

import java.util.Random;

/**
 * Class for jd02_01
 *
 * @author Sinkevich Denis
 */
public class Utility {
    //Используется для расчёта случайных величин в задании
    private static final Random random = new Random(System.currentTimeMillis());
    //Общее число покупателей за весь день
    public static int buyersCount = 0;
    //Общее число покупателей в данный момент в магазине
    public static int buyersQuantity = 0;


    public static long getTimeOut (long from, long to) {
        int range = (int) (to - from);
        return from + random.nextInt(range + 1);
    }

    public static int clarifyNumberOfEntrants(int timerState, int enteringBuyers) {
        if (timerState < 30) {
            if (buyersQuantity >= 40) {
                enteringBuyers = 0;
            } else {
                int nextQuantity = buyersQuantity + enteringBuyers;
                if (nextQuantity > 40) {
                    enteringBuyers = 40 - buyersQuantity;
                }
            }
        } else {
            if (buyersQuantity >= 40 + 30 - timerState) {
                enteringBuyers = 0;
            } else {
                int nextQuantity = buyersQuantity + enteringBuyers;
                if (nextQuantity > 40) {
                    enteringBuyers = 40 - buyersQuantity;
                }
            }
        }
        return enteringBuyers;
    }
}
