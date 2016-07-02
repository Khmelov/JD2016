package by.it.kust.jd01_12.taskA;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tanya Kust.
 */
public class MyCollect {
    /**
     * Пересечение множеств А и В
     * @param A множество А от 0 до 9
     * @param B множество В от 5 до 12
     * @return множество пересечения значений
     */
    public static Set<Integer> getCross(Set<Integer> A, Set<Integer> B){
        Set<Integer> cross = new HashSet<>(A);
        cross.retainAll(B);
        return cross;
    }

    /**
     * Объединение множеств А и В
     * @param A множество А от 0 до 9
     * @param B множество В от 5 до 12
     * @return множество объединенных значений
     */
    public static Set<Integer> getUnion(Set<Integer> A, Set<Integer> B){
        Set<Integer> union = new HashSet<>(A);
        union.addAll(B);
        return union;
    }
}
