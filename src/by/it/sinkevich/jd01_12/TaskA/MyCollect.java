package by.it.sinkevich.jd01_12.TaskA;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class for TaskA2
 *
 * @author Sinkevich Denis
 */
class MyCollect {

    static Set<Integer> getCross(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> result = new HashSet<>();
        for (Integer element : setA) {
            if (setB.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    static Set<Integer> getUnion(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> result = new HashSet<>(setA);
        for (Integer element : setB) {
            result.add(element);
        }
        return result;
    }
}
