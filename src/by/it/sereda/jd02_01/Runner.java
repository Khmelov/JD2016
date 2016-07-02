package by.it.sereda.jd02_01;

import by.it.akhmelev.jd01_02.Util;

import java.io.BufferedReader;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int countBuyer = Utils.getTimeOut(0, 2);
            for (int j = 0; j < countBuyer; j++) {
                Buyer buyer = new Buyer(++Utils.countBuyers);
                Thread thBuyer = new Thread(buyer);
                thBuyer.start();
            }
        }
    }
}
