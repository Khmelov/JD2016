package by.it.drachyova.jd01_12;


import java.util.HashSet;


    class MyCollect {
    static HashSet<Integer> getCross(HashSet<Integer> setA, HashSet<Integer> setB) {
        HashSet<Integer> cross = new HashSet<>();
        for (Integer element : setA) {
            if (setB.contains(element)) {
                cross.add(element);
            }
        }
        return cross;
    }

    static HashSet<Integer> getUnion(HashSet<Integer> setA, HashSet<Integer> setB) {
        HashSet<Integer> union = new HashSet<>(setA);
        for (Integer element : setB) {
            union.add(element);
        }
        return union;
    }
}
