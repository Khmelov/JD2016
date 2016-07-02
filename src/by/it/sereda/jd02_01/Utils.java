package by.it.sereda.jd02_01;

public class Utils {
    static int countBuyers = 0;

    static int getTimeOut(int from, int to) {
        return Math.max(from, 0) + (int) (Math.random() * to + 1);
    }
}
