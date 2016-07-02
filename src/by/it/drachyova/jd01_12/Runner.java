package by.it.drachyova.jd01_12;

import by.it.drachyova.jd01_06.*;
import by.it.drachyova.jd01_06.Text;

import java.util.*;


public class Runner {
    public static void main(String[] args) {
        System.out.println("Task A1");
        ArrayList<Integer> markList=TaskA1.createMarkList();
        System.out.println("Список оценок учеников");
        TaskA1.printList(markList);
        System.out.println("Удалили неудовлетворительные оценки");
        TaskA1.deleteBadMarks(markList);
        TaskA1.printList(markList);
        System.out.println("Task A2");
        HashSet<Integer> A=TaskA2.createHashSetA();
        System.out.print("A: ");
        TaskA2.printHashSet(A);
        HashSet<Integer> B= TaskA2.createHashSetB();
        System.out.print("B: ");
        TaskA2.printHashSet(B);
        System.out.println("Пересечение");
        System.out.println(MyCollect.getCross(A,B));
        System.out.println("Объединение");
        System.out.println(MyCollect.getUnion(A,B));
        System.out.println("Task A3");
        ArrayList<Integer> list=TaskA3.listCreator();
        System.out.println("Произвольный список");
        TaskA1.printList(list);
        System.out.println("Переставим отрицательные элементы в конец, положительные - в начало списка");
        TaskA3.listSort(list);
        TaskA1.printList(list);
        System.out.println("Task B1");
        HashMap<String,Integer> hashMap=TaskB1.createHashMap();
        TaskB1.printHashMap(hashMap);
        System.out.println("Task B2");
        ArrayList<Integer> arrayList=TaskB2.createArrayList(10);
        LinkedList<Integer>linkedList=TaskB2.createLinkedList(10);
        System.out.println("Метод processArray отрабатывает за "+ TaskB2.processArray(arrayList));
        System.out.println("Метод processLinked отрабатывает за "+ TaskB2.processLinked(linkedList));
    }
}
