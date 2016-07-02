package by.it.novik.jd01_13.taskC.exceptions;

/**
 * Created by Kate Novik.
 */
public class EmptyNameException extends Exception {
    //Создадим 4 конструктора
    public EmptyNameException() {
    }

    public EmptyNameException(String message, Throwable exception) {
        super(message, exception);
    }

    public EmptyNameException(String message) {
        super(message);
    }

    public EmptyNameException(Throwable exception) {
        super(exception);
    }
}
