package by.it.novik.jd02_06.log;

/**
 * Created by Kate Novik.
 */
public class RunLogger {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        for (int i = 1; i<11; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Ошибка прерывания" + e);
                e.printStackTrace();
            }
            logger.writeLogInFile("Ошибка № " + i);

        }
    }
}
