package by.it.kust.jd01_13.TaskC;

/**
 * Created by Tanya Kust on 19.05.2016.
 */
public interface IMobile {
    /**
     * задание 5. interface Mobile <-- abstract class Siemens Mobile <-- class Model.
     */
    void showPrice();      // метод показывает цену
    void switchOn();      // метод включает телефон
    void helloMessage();  // метод показывает заставку-приветствие
    void checkBalance();    // метод проверяет баланс
    void flightModeOn();   //  метод включает режим полета
    void flightModeOff();  // метод выключает режим полета
    void switchOff();      //  метод выключает телефон
}
