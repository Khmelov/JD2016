package by.it.sinkevich.jd02_01;

import by.it.sinkevich.jd02_01.Buyer.Buyer;
import by.it.sinkevich.jd02_01.Utility.Utility;

/**
 * Class for jd02_01
 *
 * @author Sinkevich Denis
 */
class Runner {

    public static void main(String[] args) {

        int timer = 0;
        for (int i = 0; i < 120; i++) {
            int enteringBuyers = (int) Utility.getTimeOut(1, 3);
            //Метод уточняет количество входящих покупателей при граничных значениях
            enteringBuyers = Utility.clarifyNumberOfEntrants(timer, enteringBuyers);
            for (int buyers = 0; buyers < enteringBuyers; buyers++) {
                Buyer buyer = new Buyer();
                Thread thread = new Thread(buyer);
                thread.start();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 60 != 0) {
                timer++;
            } else {
                timer = 0;
            }
        }
        System.out.println("Main finished!");
    }
}
