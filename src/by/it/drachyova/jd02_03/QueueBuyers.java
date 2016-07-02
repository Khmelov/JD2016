package by.it.drachyova.jd02_03;

import java.util.concurrent.ConcurrentLinkedDeque;

//очередь покупателей на кассу


public class QueueBuyers {

    private final static ConcurrentLinkedDeque queueBuyers = new ConcurrentLinkedDeque();

    public static void add(Buyer buyer) {
        if (buyer.isPensioner == true) {              //если покупатель пенсионер
            queueBuyers.addFirst(buyer);           //ставим первым в очередь
        }                                          // если обычный покупатель
        else queueBuyers.addLast(buyer);           //ставим его последним
    }

    public static Buyer poll() {
        if (queueBuyers.isEmpty()) {
            return null;
        } else {
            return (Buyer) queueBuyers.poll();
        }
    }

    public static int getSize() {
        return queueBuyers.size();
    }
}

