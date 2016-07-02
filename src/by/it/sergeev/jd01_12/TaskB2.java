package by.it.sergeev.jd01_12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Integer;

public class TaskB2 {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(r.readLine());
        Timer t = new Timer();
        ArrayList<Integer> arraylist = new ArrayList<>();
        LinkedList<Integer> linkedlist = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            arraylist.add(i);
            linkedlist.add(i);
        }
        int arraycount = 0; //круг
        boolean arraydel = false;
        while (arraylist.size() != 1) {
            Iterator<Integer> iterator = arraylist.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (arraydel) {
                    iterator.remove();
                }
                arraydel = !arraydel;
            }arraycount++;
            System.out.println(arraycount + " круг метода ArrayList" + arraylist);
        }
        int linkedcount = 0;
        boolean linkeddel = false;//круг
        while (linkedlist.size() != 1) {
            Iterator<Integer> iterator = linkedlist.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (linkeddel) {
                    iterator.remove();
                }
                linkeddel = !linkeddel;
            }
            linkedcount++;
            System.out.println(linkedcount + " круг метода LinkedList" +linkedlist);
        }
        System.out.println("Метод ArrayList. " + t + arraylist);
        System.out.println("Метод LinkedList. " + t + linkedlist);
    }
    public static class Timer{
        private  long iniTime;
        private  Double Delta;
        public Timer(){
            iniTime=System.nanoTime();
        }
        public  String toString(){
            Delta=(double)(System.nanoTime()-iniTime)/1000;
            iniTime=System.nanoTime();
            return "Прошло "+Delta.toString()+" микросекунд.";
        }
    }
}

