package by.it.sinkevich.jd01_09.exceptions;

/**
 * Класс описывает основные типы исключений в приложении МатЛаб
 *
 * @author Sinkevich Denis
 */
public class MathLabException extends Exception {
    public MathLabException() {
        super();
    }

    public MathLabException(String message) {
        super(message);
    }

    public MathLabException(String message, Throwable cause) {
        super(message, cause);
    }

    public MathLabException(Throwable cause) {
        super(cause);
    }
}
