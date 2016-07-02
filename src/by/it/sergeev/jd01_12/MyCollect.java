package by.it.sergeev.jd01_12;

import java.util.ArrayList;

public class MyCollect {
    public static ArrayList<Integer> getCross(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> cross = new ArrayList<Integer>();
        int c = 0;
        for ( int i = 0; i < A.size(); i++)
            for (int j = 0; j < B.size(); j++)
                if (A.get(i)==B.get(j)) {
                    cross.add(A.get(i));
                    c++;
                    break;
                }
        System.out.println("Количество повторов :");
        System.out.println(c);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        return cross;
        }
    public static ArrayList<Integer> getUnion (ArrayList<Integer> A,ArrayList<Integer> B){
        ArrayList<Integer> union =new ArrayList<Integer>();
        union.addAll(0,A);
        union.addAll(A.size(),B);
        System.out.println();
        for (Integer a : union) {
            System.out.print(a + " ");
        }
        return union;
    }

    public static ArrayList<Object> getCross2(ArrayList<Object> A, ArrayList<Object> B) {
        ArrayList<Object> cross = new ArrayList<Object>();
        int c = 0;
        for ( int i = 0; i < A.size(); i++)
            for (int j = 0; j < B.size(); j++)
                if (A.get(i)==B.get(j)) {
                    cross.add(A.get(i));
                    c++;
                    break;
                }
        System.out.println("Количество повторов :");
        System.out.println(c);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        return cross;
    }
    public static ArrayList<Object> getUnion2 (ArrayList<Object> A,ArrayList<Object> B){
        ArrayList<Object> union =new ArrayList<Object>();
        union.addAll(0,A);
        union.addAll(A.size(),B);
        System.out.println();
        for (Object a : union) {
            System.out.print(a + " ");
        }
        return union;
    }
}
