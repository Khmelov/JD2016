package by.it.drachyova.jd02_03;

// интерфейс для покупателя
public interface IBuyer {

    void enterToMarket(); //вошел в магазин (мгновенно)

    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)

    void goToQueue(); //встал в очередь на кассу

    void goToOut(); //отправился на выход(мгновенно)
}
