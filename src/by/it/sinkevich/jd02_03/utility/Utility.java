package by.it.sinkevich.jd02_03.utility;

import java.util.Random;

/**
 * Class for jd02_03
 *
 * @author Sinkevich Denis
 */
public class Utility {
    //Используется для расчёта случайных величин в задании
    private static final Random random = new Random(System.currentTimeMillis());

    public static int getTimeOut(int from, int to) {
        int range = to - from;
        return from + random.nextInt(range + 1);
    }

    public static void sleep(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Поток не смог даже уснуть без ошибки(((");
        }
    }

    public static void synchroPrintln(String s) {
        synchronized (System.out) {
            System.out.println(s);
            System.out.flush();
        }
    }
}
