package by.it.sergeev.jd02_03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * менеджер
 */
public class Manager {

    public static int countBuyersIn = 0;
    public static int countBuyersOut = 0;
    public static int countCashier = 0;
    public static final int planBuyers = 100;
    private static final Lock countLock = new ReentrantLock();

    public static void addCountBuyersIn(){
        try {
            countLock.lock();
            countBuyersIn++;
        } finally {
            countLock.unlock();
        }
    }

    public static void addCountBuyersOut(){
        try {
            countLock.lock();
            countBuyersOut++;
        } finally {
            countLock.unlock();
        }
    }

    public static void addCountCashier(){
        try {
            countLock.lock();
            countCashier++;
        } finally {
            countLock.unlock();
        }
    }

    public static void reduceCountCashier(){
        try {
            countLock.lock();
            countCashier--;
        } finally {
            countLock.unlock();
        }
    }
}