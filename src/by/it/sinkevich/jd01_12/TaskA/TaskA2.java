package by.it.sinkevich.jd01_12.TaskA;

import java.util.HashSet;
import java.util.Set;

/**
 * TaskA2 class
 *
 * @author Sinkevich Denis
 */
class TaskA2 {

    private Set<Integer> setA;
    private Set<Integer> setB;


    TaskA2() {
        setA = new HashSet<>();
        setB = new HashSet<>();
        fillLists();
    }

    private void fillLists() {
        for (int i = 0; i < 10; i++) {
            double random = Math.random() * 20 - 10;
            setA.add((int) Math.round(random));
            random = Math.random() * 20 - 10;
            setB.add((int) Math.round(random));
        }
    }

    Set<Integer> getSetA() {
        return setA;
    }

    Set<Integer> getSetB() {
        return setB;
    }
}
