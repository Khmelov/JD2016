package by.it.novik.jd02_01.utils;

import java.util.Random;

/**
 * Created by Kate Novik.
 */
public class RandomCounter {

    /**
     * Функция вычисления случайного времени ожидания
     * @param start Минимальное время ожидания
     * @param end Максимальное время ожидания
     * @return Случайное время ожидания из заданного диапазона
     */
    public static int countRandom (int start, int end) {
        //Создаем объект Random
        Random random = new Random();
        //Вычисляем предел диапазона случайных чисел
        int delta = end - start + 1;
        //Находим случайное число
        int timeWait = start + random.nextInt(delta);
        return timeWait;
    }
}
