package by.it.drachyova.jd02_03;

// интерфейс для покупателя, использующего корзину

public interface IUseBasket {
    void takeBasket();  //взять корзину от 0.1 до 0.2 сек

    void putGoodsToBasket(); //положить выбранный товар в корзину от 0.1 до 0.2 сек
}
