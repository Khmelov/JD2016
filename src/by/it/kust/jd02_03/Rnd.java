package by.it.kust.jd02_03;

import java.util.Random;

/**
 * Created by Tanya Kust.
 */
public class Rnd {
    static final long init = System.currentTimeMillis();
    static final Random random = new Random(init);

    /**
     * получение случайного значения в промежутке
     * @param from от
     * @param to до
     * @return целое значение
     */
    static int fromTo(int from, int to){
        int w = to - from +1;
        int rnd = from + random.nextInt(w);
        return rnd;
    }

    /*static int rndGoods(int from, int to){
        int w = to - from;
        int rnd = from + random.nextInt(w);
        return rnd;
    }*/

}
