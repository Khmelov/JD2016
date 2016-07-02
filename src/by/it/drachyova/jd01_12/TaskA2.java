package by.it.drachyova.jd01_12;

import java.util.HashSet;
import java.util.Random;

/**
     Определить два множества (A и B) на основе целых чисел. Создать отдельный класс MyCollect и
     статические методы в нем для определения пересечения множеств getCross и объединения множеств
     getUnion. Показать работу этих методов на примере двух множеств (A и B).
*/
    class TaskA2 {
        static HashSet<Integer> createHashSetA() {
            HashSet<Integer> hashSet = new HashSet<>();
                for (int i = 0; i < 15; i++) {
                    hashSet.add(i+5);
                }
        return hashSet;
    }
    static HashSet<Integer> createHashSetB() {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 15; i++) {
            hashSet.add(i+8);
        }
        return hashSet;
    }
    static  void printHashSet(HashSet<Integer>hashSet){
        System.out.println(hashSet);
    }
}
