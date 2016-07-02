package by.it.kushel.jd01_09;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Diomn on 26.05.2016.
 */
public class MyCollect {


public static Set<Integer> unionOfSets(Set set1, Set set2) {
    Set<Integer> set3 = new TreeSet<Integer>();
    set3.addAll(set1);
    set3.addAll(set2);

    return set3;
}
    public static Set<Integer> intersectionOfSets (Set set1, Set set2){
        Set<Integer> set3 = new TreeSet<Integer>();
        Iterator<Integer> itr=set1.iterator();
        while (itr.hasNext()){
            Integer elementOfSet1 = itr.next();
            for (Object elementOfSet2 : set2){
              if (elementOfSet1==elementOfSet2){
                  set3.add(elementOfSet1);
              }
            }
        }
        return set3;
    }
    }
