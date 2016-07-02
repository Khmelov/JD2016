package by.it.sergeev.jd02_03;

import java.util.Random;

/**
 * рандом
 */
public class Rnd {

    static final long init = System.currentTimeMillis();
    static final Random random = new Random(init);

    static int fromTo(int from, int to){
        int delta = to - from + 1;
        return from + random.nextInt(delta);
    }
}