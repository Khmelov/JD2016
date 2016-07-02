package by.it.kust.jd02_03;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Tanya Kust.
 */
public class QueueBuyers {
    public final static ConcurrentLinkedDeque buyersQueue = new ConcurrentLinkedDeque();  // очередь покупателей

    /**
     * добавление покупателя в очередь на кассы
     * @param buyer - покупатель
     * @param pensioner - если пенсионер, то добавляем в начало очереди
     */
    public static void add(Buyer buyer, boolean pensioner){
        if (pensioner == true) {
            buyersQueue.addFirst(buyer);   // если пенсионер - добавим в начало очереди
        }else {
            buyersQueue.addLast(buyer);
        }
    }

    /**
     * извлекаем покупателя из очереди
     * @return - если очередь пуста, возвращаем значение null
     */
    public static Buyer poll(){
        if (!buyersQueue.isEmpty()){
            return (Buyer)buyersQueue.poll();
        }else {
            return null;
        }
    }
}
