package by.it.sergeev.jd01_12;

import java.util.Random;

/**
 * Created by Spec on 28.05.16.
 */
public class Util {
    //А1.
    private static Random random = new Random();

    static int generateRandom(int n) {
        return Math.abs(random.nextInt()) % n;
    }

    private static Random randomPosNeg = new Random();

    static int generateRandomPositiveNegative(int m) {
    int a = randomPosNeg.nextInt(2 * m + 1) - m;
    return a;

    }
}
