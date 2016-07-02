package by.it.kushel.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Diomn on 12.06.2016.
 */
public class Runner {
    public static void main(String[] args) {
//        ExecutorService executor= Executors.newFixedThreadPool(2);
//        executor.execute(new Cashier());
//        executor.execute(new Cashier());
       int countOfCashier=2;
for(int i=1; i<=countOfCashier; i++){
    Cashier cashier = new Cashier(i);
    Thread th1ashier = new Thread(cashier);
    th1ashier.setDaemon(true);
    th1ashier.start();
}

      int countOfBuers=0;
        int numberOfBuyers = (int) (Math.random()*2+1);
        while (countOfBuers<=10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <= numberOfBuyers; i++) {
                //Buyer buyer = new Buyer(i);


                countOfBuers= countOfBuers+1;
                if (countOfBuers<=10)
                {
                    Buyer buyer=new Buyer(countOfBuers);
                    buyer.start();
                }

            }
        }
    }
}
