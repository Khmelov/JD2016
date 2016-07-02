package by.it.kust.jd01_12.taskB;

import by.it.kust.jd01_12.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

/**
 * Created by Tanya Kust.
 */
public class TaskB2 {
    /**
     * Удаляет элементы в ArrayList
     * @param length - размерность списка
     * @return затраченное время в микросекундах
     */
    public static String processArray(int length) {
        double start = System.nanoTime();
        ArrayList<Integer> persons = new ArrayList<>();
        for (int i=0; i<length; i++){
            persons.add(i);
        }
        Utils.printData("Исходный ArrayList:", persons);
        //int step=1;
        while (persons.size()>1) {
            Iterator<Integer> it = persons.iterator();
            while (it.hasNext()) {
                it.next();
                if (it.hasNext()) {
                    it.next();
                    it.remove();
                    //Utils.printData("После шага: " + step, persons);
                    //step++;
                }
            }
        }
        double end = System.nanoTime();
        double time = end - start;
        return "Удаление в ArrayList заняло " + time/1000 + " микросекунд";
    }

    /**
     * Удаляет элементы в LinkedList
     * @param length - размерность списка
     * @return затраченное время в микросекундах
     */
    public static String processLinked(int length) {
        double start = System.nanoTime();
        LinkedList<Integer> persons = new LinkedList<>();
        for (int i=0; i<length; i++){
            persons.add(i);
        }
        Utils.printData("\nИсходный LinkedList:", persons);
        //int step=1;
        while (persons.size()>1) {
            Iterator<Integer> it = persons.iterator();
            while (it.hasNext()) {
                it.next();
                if (it.hasNext()) {
                    it.next();
                    it.remove();
                    //Utils.printData("После шага: " + step, persons);
                    //step++;
                }
            }
        }
        double end = System.nanoTime();
        double time = end - start;
        return "Удаление в LinkedList заняло " + time/1000 + " микросекунд";
    }

}
