package by.it.sinkevich.jd02_06.taskA;

/**
 * Main class for jd02_06
 *
 * @author Sinkevich Denis
 */
class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLoggerInstance();
        try {
            throw new Exception("Ошибка в методе main!");
        } catch (Exception e) {
            logger.writeErrorMessage(e.getMessage());
        }
    }
}
