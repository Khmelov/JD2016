package by.it.drachyova.jd02_03;


import java.util.Random;

public class Utils {
    static final long init = System.currentTimeMillis();
    static final Random random = new Random(init);

    public static int getMyRandom(int start, int end) {
        int myRandom = start + random.nextInt(end - start + 1);
        return myRandom;
    }

    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
