package by.it.belsky.jd02_01;

/**
 * Created by misha on 10.06.2016.
 */
public class Utils {
   static int getTimeOut(int from, int to) {
       from=Math.max(from, 0);
       to=Math.max(to, from);
       int res=(int)(Math.random()*(to-from+1));
       res=from+res;

       return res;
    }
}
