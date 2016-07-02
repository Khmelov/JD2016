package by.it.kushel.jd01_09;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Diomn on 26.05.2016.
 */
public class SetsAB {
        int scope = 10;

        public static Set<Integer> createSet(int maxSize) {
                int scope = 10;
                Set<Integer> setA = new TreeSet<Integer>();
                for (int i=0; i < maxSize; i++) {
                        setA.add((int) ((2 * scope + 1) * Math.random()) - scope);
                }
                return setA;
        }



}
