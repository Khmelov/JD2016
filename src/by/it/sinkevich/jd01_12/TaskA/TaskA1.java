package by.it.sinkevich.jd01_12.TaskA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TaskA1 class
 *
 * @author Sinkevich Denis
 */
class TaskA1 {

    private int numberOfStudents;
    private List<Integer> marks;

    TaskA1() {
        numberOfStudents = 10;
        marks = new ArrayList<>();
    }

    TaskA1(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        marks = new ArrayList<>(numberOfStudents);
    }

    void initListWithRandomMarks(int minMark, int maxMark) {
        for (int i = 0; i < numberOfStudents; i++) {
            marks.add(i, getRandomMark(minMark, maxMark));
        }
    }

    void deleteUnsatisfactoryMarks() {
        Iterator<Integer> iterator = marks.iterator();
        while (iterator.hasNext()) {
            Integer mark = iterator.next();
            if (mark < 4) {
                iterator.remove();
            }
        }
    }

    private Integer getRandomMark(int minMark, int maxMark) {
        double random = Math.random() * (maxMark - minMark) + minMark;
        return (int) Math.round(random);
    }

    void printList() {
        System.out.println(marks);
    }
}
