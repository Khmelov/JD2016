package by.it.sinkevich.jd01_12.TaskA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TaskA3 class
 *
 * @author Sinkevich Denis
 */
class TaskA3 {

    private List<Double> numbers;

    TaskA3() {
        numbers = new ArrayList<>();
        initListWithRandomValues();
    }

    private void initListWithRandomValues() {
        for (int i = 0; i < 10; i++) {
            double random = Math.rint(Math.random() * 20 - 10);
            numbers.add(random);
        }
    }

    void descendingSort() {
        Collections.sort(numbers);
        Collections.reverse(numbers);
    }

    List<Double> getNumbers() {
        return numbers;
    }
}
