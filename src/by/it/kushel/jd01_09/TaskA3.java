package by.it.kushel.jd01_09;

import java.util.*;

/**
 * Created by Diomn on 25.05.2016.
 */
public class TaskA3 {
    public static void main(String[] args) {


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int scope = 15;
        int k=10;
        for (int i = 0; i<=k; i++){
            numbers.add((int)((2*scope+1)*Math.random())-scope);
        }
        System.out.println(numbers);
        int n = 0;
       for(int i=0; i<numbers.size(); i++){
           if (numbers.get(i-n)<0){
               numbers.add(numbers.get(i-n));
               numbers.remove(i-n);
               n =n+1;
           }
       }
System.out.println(numbers);
    }
}
