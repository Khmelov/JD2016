package by.it.sinkevich.jd01_12.TaskC;

import java.util.HashSet;
import java.util.Set;

/**
 * TaskC2 class
 *
 * @author Sinkevich Denis
 */
class TaskC2 {

    private Set<Integer> setA;
    private Set<Integer> setB;
    private Set<String> setStrA;
    private Set<String> setStrB;


    TaskC2() {
        setA = new HashSet<>();
        setB = new HashSet<>();
        setStrA = new HashSet<>();
        setStrB = new HashSet<>();
        fillLists();
    }

    private void fillLists() {
        for (int i = 0; i < 10; i++) {
            double random = Math.random() * 20 - 10;
            setA.add((int) Math.round(random));
            random = Math.random() * 20 - 10;
            setB.add((int) Math.round(random));
            random = Math.random() * 20 - 10;
            setStrA.add(String.valueOf(Math.round(random)));
            random = Math.random() * 20 - 10;
            setStrB.add(String.valueOf(Math.round(random)));
        }
    }

    Set<Integer> getSetA() {
        return setA;
    }

    Set<Integer> getSetB() {
        return setB;
    }

    Set<String> getSetStrA() {
        return setStrA;
    }

    Set<String> getSetStrB() {
        return setStrB;
    }
}
