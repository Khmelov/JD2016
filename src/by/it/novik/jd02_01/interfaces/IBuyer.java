package by.it.novik.jd02_01.interfaces;

/**
 * Created by Kate Novik.
 */
public interface IBuyer {
    /**
     * Покупатель входит в магазин
     */
    void enterToMarket();

    /**
     * Взять корзинку
     */
    void takeBasket();

    /**
     * Покупатель выбирает товар
     */
    void chooseGoods();

    /**
     * Покупатель оплачивает товар
     */
    void payGoods();

    /**
     * Покупатель выходит из магазина
     */
    void exitOutMarket();
}
