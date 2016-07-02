package by.it.kust.jd01_13.TaskC;

/**
 * Created by Tanya Kust on 21.05.2016.
 */
public class Model extends AbstractSiemensMobile {

    public Model(String model, int price) throws ModelMissed {
        super(model, price);
    }

    @Override  //реализация абстрактного метода
    public void showModel(){
        System.out.println("Модель телефона: " + super.getModel());
    }

    @Override
    public void showPrice() {super.showPrice();}

    @Override
    public void switchOn() {
        super.switchOn();
    }

    @Override
    public void helloMessage() {
        super.helloMessage();
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
    }

    @Override
    public void flightModeOn() {
        super.flightModeOn();
    }

    @Override
    public void flightModeOff() {
        super.flightModeOff();
    }

    @Override
    public void switchOff() {
        super.switchOff();
    }
}
