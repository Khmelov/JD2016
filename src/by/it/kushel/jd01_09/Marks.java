package by.it.kushel.jd01_09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Diomn on 25.05.2016.
 */
public class Marks {
    public static void main(String[] args) {
int n =10;
        List mark = new ArrayList<Integer>();
        for (int i=0; i<=n; i++) {
            mark.add((int) (10 * Math.random()) + 1);
        }
        System.out.println("Заполнение случайными оценками:"+ mark);
        Iterator iterator=mark.iterator();
        while (iterator.hasNext()){
            Integer m = (Integer) iterator.next();
            if (m<4){
                iterator.remove();
            }
            }
        System.out.print("После удаления оценок <4: "+ mark);
        }



}
