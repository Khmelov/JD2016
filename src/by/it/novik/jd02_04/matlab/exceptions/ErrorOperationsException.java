package by.it.novik.jd02_04.matlab.exceptions;

/**
 * Created by Kate Novik.
 */
public class ErrorOperationsException extends Exception {

    // public void error(String typeError) {
//        System.out.println("Error: ".concat(typeError));
//    }

    /**
     * Конструкторы для созданного ErrorOperationsException
     */
    public ErrorOperationsException() {
    }

    public ErrorOperationsException(String message) {
        super(message);
    }

    public ErrorOperationsException(Throwable exception) {
        super(exception);
    }

    public ErrorOperationsException(String message, Throwable exception) {
        super(message, exception);
    }

}
