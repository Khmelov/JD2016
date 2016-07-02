package by.it.kust.jd01_13.TaskC;

/**
 * Created by Tanya Kust on 19.05.2016.
 */
public class Main {
    /**
     * задание 5. interface Mobile <-- abstract class Siemens Mobile <-- class Model.
     * @param args модель, цена
     */
    public static void main(String[] args) {
        Model model1;
        try {
            //model1 = new Model("CX75", 300);
            model1 = new Model("", 300);  //спровоцируем исключение, не указав модель телефона
            model1.showModel();
            model1.showPrice();
            model1.switchOn();
            model1.helloMessage();
            model1.checkBalance();
            model1.flightModeOn();
            model1.flightModeOff();
            model1.switchOff();
        } catch (ModelMissed e) {
            System.err.println(e.getMessage());;
        }

    }
}
