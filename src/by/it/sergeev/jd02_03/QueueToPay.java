package by.it.sergeev.jd02_03;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * очередь в кассу
 */
public class QueueToPay {


    public static final Deque<Buyer> queueToPay = new ConcurrentLinkedDeque<>();


    public static synchronized void putBuyer (Buyer buyer){
        if (buyer.isRetired()) {
            queueToPay.offerFirst(buyer);
        }
        else{
            queueToPay.offer(buyer);
        }
    }

    public static synchronized Buyer getBuyer () {

        if(queueToPay.isEmpty()) return null;
        else return queueToPay.remove();
    }
}