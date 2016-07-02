package by.it.sereda.jd02_01;

public class Buyer implements IBuyer, Runnable {

    private int number = 0;

    public Buyer(int number) {
        this.number = number;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " in shop");
    }

    @Override
    public void choosegoods() {
        try {
            int timeout = Utils.getTimeOut(500, 2000);
            Thread.sleep(timeout);
            System.out.println(this + " choose goods");
        } catch (InterruptedException e) {
            System.out.println(this + " crash");
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + " out from shop");
    }

    @Override
    public void run() {
        enterToMarket();
        choosegoods();
        goToOut();
    }

    @Override
    public String toString() {
        return "Buyer N=" + number;
    }

}
