package by.it.kust.jd01_12.taskA;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tanya Kust.
 */
public class TaskA2 {
    /**
     * Создает множество целых значений
     * @param size - размерность множества
     * @param dif - смещение (чтобы получить второй список со значениями, отличными от первого)
     * @return множество целых значений
     */
    public static Set<Integer> createNewSet(int size, int dif) {
        Set<Integer> set = new HashSet<>();
        for (int i=dif; i<(size+dif); i++ ){
            set.add(i);
        }
        return set;
    }


}
