package by.it.kushel.jd01_09;

import java.util.Set;

/**
 * Created by Diomn on 26.05.2016.
 */
public class RunSets {
    public static void main(String[] args) {
Set setA= SetsAB.createSet(10);
        Set setB=SetsAB.createSet(10);
        System.out.println("setA: " + setA);
        System.out.println("setB: " + setB);
        System.out.println("Объединение множеств A, B: " + MyCollect.unionOfSets(setA,setB));
        System.out.println("Пересечение множеств A, B: "+ MyCollect.intersectionOfSets(setA, setB));


    }
}
