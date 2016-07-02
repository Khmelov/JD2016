package by.it.belsky.jd01_12.TaskA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by misha on 09.06.2016.
 */
public class VariantA1 {
    public List<Integer> ListofAllMarks() {
        List<Integer> studentmarks = new ArrayList();

        for (int i = 0; i < 15; i++) {
            studentmarks.add((int) (Math.random() * 10 + 1)); //запись случайных оценок
        }
        System.out.println("Список всех оценок учеников:  " + studentmarks);
return studentmarks;
    }

    public List<Integer> ListofSatisfactoryMarks(List<Integer> studentmarks ) {

        Iterator<Integer> iterator = studentmarks.iterator();
        while (iterator.hasNext()) {
            Integer mark = iterator.next();
            if (mark < 4) {
                iterator.remove();
            }
        }
        System.out.println("Список удовлетворительных" + "\n" + "оценок учеников:              " + studentmarks);
        return studentmarks;
    }

}

