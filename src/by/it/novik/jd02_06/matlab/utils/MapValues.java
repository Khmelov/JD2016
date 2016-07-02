package by.it.novik.jd02_06.matlab.utils;

import by.it.novik.jd02_06.matlab.entity.Variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kate Novik.
 */
public class MapValues {
    // Создание одного объекта в классе Singleton MapValues
    private static Map<String,Variable> instance = new HashMap<>();

    private MapValues() {}

    /**
     * Получение единственного экземпляра класса MapValues
     * @return Экземпляр класса MapValues
     */
    public static Map<String,Variable> getInstance () {
        return MapValues.instance;
    }
}
