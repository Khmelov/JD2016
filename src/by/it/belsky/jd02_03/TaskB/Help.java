package by.it.belsky.jd02_03.TaskB;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by misha on 21.06.2016.
 */
class Help {
    static final long init = System.currentTimeMillis();
    static final Random random = new Random(init);

    static int fromTo(int from, int to) {
        //вычислим время ожидания
        int delta = to - from + 1;
        int msWait = from + random.nextInt(delta);
        return msWait;
    }

    //чтобы не загромождать код вынесем try для sleep в свой отдельный метод
    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Map<String, Double> goods () {
        Map <String, Double> products = new HashMap<>();
        products.put("Сыр", 4.5);
        products.put("Вино", 8.3);
        products.put("Виноград", 2.0);
        products.put("Масло", 1.9);
        products.put("Хлеб", 0.9);
        products.put("Носки", 2.9);
        products.put("Картофель", 0.3);
        products.put("Шоколад", 2.1);
        products.put("Молоко", 1.0);
        products.put("Вешалка", 0.6);
        return products;
    }

    static int numberOfGoods (int from, int to) {
        from = Math.max(from, 0);
        to = Math.max(to, from);
        int res = from + (int)(Math.random()*(to-from));
        return res;
    }
}
