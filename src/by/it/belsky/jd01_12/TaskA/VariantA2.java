package by.it.belsky.jd01_12.TaskA;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by misha on 09.06.2016.
 */
class VariantA2 {
    public List<Integer> VarietyA() {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {  //создание множества А
            list1.add(i);
        }
        System.out.println("Перовое множество: " + list1);
        return list1;
    }

    public List<Integer> VarietyB() {
        List<Integer> list2 = new ArrayList<>();
        for (int i = 7; i < 16; i++) {  //создание множества Б
            list2.add(i);
        }
        System.out.println("Второе множество: " + list2);
        return list2;
    }
}