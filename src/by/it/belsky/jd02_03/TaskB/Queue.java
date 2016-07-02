package by.it.belsky.jd02_03.TaskB;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by misha on 21.06.2016.
 */
public class Queue {

    //экземпляр очереди. Приватный т.к. очередь одна-единственная
    private final static ConcurrentLinkedQueue queueBuyers=new ConcurrentLinkedQueue();

    //замена статического метода на экземплярный из ConcurrentLinkedQueue;
    public static boolean add(Buyer buyer) {
        return queueBuyers.add(buyer);
    }

    //замена статического метода на экземплярный из ConcurrentLinkedQueue;
    public static Buyer poll() {
        if (queueBuyers.isEmpty()) {
            return null;
        } else {
            return (Buyer) queueBuyers.poll();
        }
    }
}

