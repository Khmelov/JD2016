package by.it.belsky.jd02_01;

/**
 * Created by misha on 10.06.2016.
 */
public class Runner {

    static int counterBuyers=0;
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            int countBuyer = Utils.getTimeOut(0, 2);
            for (int j = 0; j < countBuyer; j++) {
                counterBuyers++;
                Byer byer = new Byer(counterBuyers);
                Thread thBuyer = new Thread(byer);//передаётся любой экз любого класса (глоавное чтобы был метод RUN)
                thBuyer.start();
            }
        }
    }

}