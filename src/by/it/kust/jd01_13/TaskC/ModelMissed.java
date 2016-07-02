package by.it.kust.jd01_13.TaskC;

/**
 * Created by Tanya Kust on 09.06.2016.
 */
public class ModelMissed extends Exception{  // содаем свое исключение
    // нужно четыре конструктора для своего исключения
    public ModelMissed() {
    }

    public ModelMissed(String message) {
        super(message);
    }

    public ModelMissed(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelMissed(Throwable cause) {
        super(cause);
    }
}
