package by.it.sergeev.jd02_03;

/**
 * интерфейс для касс
 */
public interface ICashier {

    void takeBuyerFromQueue();
    void accountCashier();
    void clientMayExit();
    void calculateProfit();

}