package by.it.sergeev.jd02_03;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * прибыль
 */
public class Profit {

    private static Map<Integer, Integer> eachCashierProfit = new ConcurrentSkipListMap<>(); //аналог TreeMap с поддержкой многопоточности
    private static int totalProfit;
    private final static Lock lockProfit = new ReentrantLock();

    public static int getTotalProfit() {
        return totalProfit;
    }

    public static Map<Integer, Integer> getEachCashierProfit() {
        return eachCashierProfit;
    }

    public static void addCashierProfit(int cashierNum, int profit){

        int newProfit = eachCashierProfit.containsKey(cashierNum)?profit + eachCashierProfit.get(cashierNum):profit;
        eachCashierProfit.put(cashierNum,newProfit);
    }

    public static void addTotalProfit (int profit){

        try {
            lockProfit.lock();
            totalProfit+=profit;
        } finally {
            lockProfit.unlock();
        }
    }
}