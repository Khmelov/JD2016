package by.it.kushel.jd02_03;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Diomn on 19.06.2016.
 */
public class QueueBuyers {
    static ConcurrentLinkedQueue queueBuyers = new ConcurrentLinkedQueue();
    public static Buyer poll() {
        /*if (queueBuyers.isEmpty()){
            return null;
        }else*/
      return  (Buyer) queueBuyers.poll();
    }
    public static boolean add(Buyer buyer){
        return queueBuyers.add(buyer);
    }
}
