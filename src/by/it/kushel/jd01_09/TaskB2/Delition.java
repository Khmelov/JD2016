package by.it.kushel.jd01_09.TaskB2;

        import java.util.ArrayList;
        import java.util.LinkedList;

/**
 * Created by Diomn on 31.05.2016.
 */
public class Delition {
    public static void processArray(int n) {


        ArrayList<Integer> list = new ArrayList<Integer>();
        double start = (double) System.nanoTime();
        for (int i = 0; i <= n - 1; i++) {
            list.add(i + 1);
        }
        System.out.println(list);
        for (int j = 0; j <= list.size(); j++) {
            if (((j + 1) < list.size() - 1)) {
                list.remove(j + 1);
                System.out.println(list);
            }
            else if ((j + 1) == (list.size())- 1) {
                list.remove(j + 1);
                System.out.println(list);
                j = -1;
            } else if(list.size()>1){
                j=-2;}
            }
                double finish = (double) System.nanoTime();
                double timeOfExecuting = finish - start;
                System.out.println(list + "Executing time ArrayList= " + timeOfExecuting/1000 + " microsec");
            }
    public static void processLinked(int n) {


        LinkedList<Integer> list = new LinkedList<Integer>();
        double start = (double) System.nanoTime();
        for (int i = 0; i <= n - 1; i++) {
            list.add(i + 1);
        }
        System.out.println(list);
        for (int j = 0; j <= list.size(); j++) {
            if (((j + 1) < list.size() - 1)) {
                list.remove(j + 1);
                System.out.println(list);
            }
            else if ((j + 1) == (list.size())- 1) {
                list.remove(j + 1);
                System.out.println(list);
                j = -1;
            } else if(list.size()>1){
                j=-2;}
        }
        double finish = (double) System.nanoTime();
        double timeOfExecuting = finish - start;
        System.out.println(list + "Executing time LinkedList= " + timeOfExecuting/1000 + " microsec");
    }
    }