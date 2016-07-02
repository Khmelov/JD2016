package by.it.belsky.jd02_01;

/**
 * Created by misha on 10.06.2016.
 */
public interface IByer {
    void enterToMArket(); // вошел в магазин (мгновенно)
    void chooseGoods(); // выбрал товар (от 0.5 до 2 сек)
    void goToOut(); // отправился на выход (мгновенно)
}
