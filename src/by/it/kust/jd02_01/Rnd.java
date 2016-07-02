package by.it.kust.jd02_01;

/**
 * Created by user_2 on 10.06.2016.
 */
public class Rnd {
    static int getTimeOut(int from, int to){
        return Math.max(from,0) + (int)(Math.random()*to+1);
    }

    static int getNbrOfGoods(int to){
        int n= (int)(Math.random()*(to+1));
        return n;
    }
}
