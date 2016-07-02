package by.it.sinkevich.jd02_01.Buyer;

import by.it.sinkevich.jd02_01.Good.Good;

/**
 * Interface for jd02_01
 *
 * @author Sinkevich Denis
 */
interface IBuyer {

    void enterToMarket();

    Good chooseGoods();

    void exitFromMarket();

    void takeBasket();
}
