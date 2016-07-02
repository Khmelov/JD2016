package by.it.sinkevich.jd01_12.TaskC;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class for TaskC2
 *
 * @author Sinkevich Denis
 */
class GenericMyCollect <E> {

    Set<E> getCross(Set<E> setA, Set<E> setB) {
        Set<E> result = new HashSet<>();
        for (E element : setA) {
            if (setB.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    Set<E> getUnion(Set<E> setA, Set<E> setB) {
        Set<E> result = new HashSet<>(setA);
        for (E element : setB) {
            result.add(element);
        }
        return result;
    }
}
