package by.it.sergeev.jd02_03;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * кассир
 */
public class Cashier implements Runnable, ICashier {

    private  Buyer buyer;
    private int num;
    private int bill = 0;
    private final Lock countLock = new ReentrantLock();


    public Cashier(int num){
        this.num = num;
    }
    public int getNum() {
        return num;
    }
    public int getBill() {
        return bill;
    }

    @Override
    public void run() {

        while (Manager.countBuyersIn==0|| Manager.countBuyersIn> Manager.countBuyersOut) {

            if (QueueToPay.queueToPay.size()>= Manager.countCashier*5) { //менеджер следит чтоб было, не более 5 касс
                takeBuyerFromQueue();
                accountCashier();
                clientMayExit();
                calculateProfit();
            }
            Utils.sleep(1000);
        }
    }

    @Override
    public  void takeBuyerFromQueue() {

        this.buyer = QueueToPay.getBuyer();
        if (this.buyer!=null) {
            Manager.addCountCashier();
            Manager.addCountBuyersOut();
            System.out.println(buyer + " пошёл за кассу #" +num +".");
        }
        else{
            Utils.sleep(1000);
            takeBuyerFromQueue();
        }
    }


    @Override
    public synchronized void accountCashier(){
        Utils.sleep(Rnd.fromTo(2000, 5000));
        String s = this.buyer + " покупает: ";
        StringBuilder buyerBill = new StringBuilder(s);

        for (Map.Entry<String, Integer> entry : this.buyer.getBacket().entrySet()) {
            String good = entry.getKey();
            Integer price = entry.getValue();
            String item = good + " : " + price + "; ";
            buyerBill.append(item);
            this.bill += price;
        }

        String billToPay = "Платит: " + this.bill+". ";
        buyerBill.append(billToPay);
        System.out.println(buyerBill);
    }

    @Override
    public  void clientMayExit(){
        synchronized (this.buyer) {
            this.buyer.setWaitInTheQueue(false);
            this.buyer.notify();
        }
    }

    @Override
    public  void calculateProfit (){

        Profit.addCashierProfit(this.num, this.bill);
        Profit.addTotalProfit(this.bill);
        Utils.printCashierTable(this);
        Manager.reduceCountCashier();

        this.bill=0;

    }
}
