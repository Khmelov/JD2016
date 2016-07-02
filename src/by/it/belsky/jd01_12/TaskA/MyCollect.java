package by.it.belsky.jd01_12.TaskA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by misha on 09.06.2016.
 */
public class MyCollect {
    public static List<Integer> getCross(List<Integer> list1, List<Integer> list2) {
        List<Integer> x = new ArrayList(list1); {
            x.retainAll(list2);
        }
        System.out.println("Результат пересечения  множеств: "+x);
        return x;
    }
    public static List<Integer> getUnion(List<Integer> list1, List<Integer> list2) {
        List<Integer> x = new ArrayList(list1);
        x.addAll(list2);
        System.out.println("Результат слияния множеств: "+x);
        return x;
    }

}