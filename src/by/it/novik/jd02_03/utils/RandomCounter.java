package by.it.novik.jd02_03.utils;

import java.util.Random;

/**
 * Created by Kate Novik.
 */
public class RandomCounter {
    //Инициализация по текущему времени
    static final long init=System.currentTimeMillis();
    //Создание объекта random c инициализацией по текущему времени
    static final Random random = new Random(init);

    /**
     * Функция вычисления случайного времени ожидания
     * @param start Минимальное время ожидания
     * @param end Максимальное время ожидания
     * @return Случайное время ожидания из заданного диапазона
     */
    public static int countRandom (int start, int end) {
        //Вычисляем предел диапазона случайных чисел
        int delta = end - start + 1;
        //Находим случайное число
        int timeWait = start + random.nextInt(delta);
        return timeWait;
    }
}
