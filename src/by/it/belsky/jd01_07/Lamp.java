package by.it.belsky.jd01_07;

/**
 * Created by misha on 23.05.2016.
 */
public class Lamp {
    private boolean isOn;

    public void on() {
        isOn = true;
        System.out.println("Лампа включилась ");
    }

    public void off() {
        isOn = false;
        System.out.println("Лампа выключилась ");
    }
    public boolean GetState() {
        if (isOn)
            System.out.println("Текущее сocтояние включено " );
        else
            System.out.println("Текущее сocтояние выключено " );
        return isOn;


    }
}
