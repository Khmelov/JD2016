package by.it.sinkevich.jd01_13.TaskC;

/**
 * Класс исключений для задания jd01_13 TaskC
 */
class PlayerException extends Exception {

    public PlayerException() {
        super();
    }

    PlayerException(String message) {
        super(message);
    }

    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerException(Throwable cause) {
        super(cause);
    }
}
