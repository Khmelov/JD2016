package by.it.sinkevich.jd02_03.buyer;

import by.it.sinkevich.jd02_03.good.Good;

/**
 * Interface for jd02_03
 *
 * @author Sinkevich Denis
 */
interface IBuyer {

    void enterToMarket();

    Good chooseGoods();

    void exitFromMarket();

    void takeBasket();

    void goToQueue();
}
