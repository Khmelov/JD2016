package by.it.belsky.jd02_01;

/**
 * Created by misha on 10.06.2016.
 */
public class Byer implements IByer, Runnable {
private int number =0;

    public Byer(int number){
        this.number=number;
    }

    @Override
    public void enterToMArket() {
        System.out.println(this.toString()+" in shop");
    }

    @Override
    public void chooseGoods() {
   int timeout = Utils.getTimeOut(500,2000);
        try {
        Thread.sleep(timeout);
            System.out.println(this+" choose goods");
    } catch (InterruptedException e) {
            System.out.println(this+" crash");
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this+" out the shop");
    }

    @Override
    public void run() {
        enterToMArket();
        chooseGoods();
        goToOut();

    }


    @Override
    public String toString() {
        return "Buyer N="+this.number;
    }
}



