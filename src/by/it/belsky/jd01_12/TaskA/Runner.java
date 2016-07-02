package by.it.belsky.jd01_12.TaskA;

import java.util.List;
import java.util.Set;

/**
 * Created by misha on 09.06.2016.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Task A.1");
        VariantA1 var1 = new VariantA1();

        List<Integer> x = var1.ListofAllMarks();
        List<Integer> y = var1.ListofSatisfactoryMarks(x);
        System.out.println("Task A.2");
        VariantA2 var2 = new VariantA2();
        List<Integer> m = var2.VarietyA();
        List<Integer> n = var2.VarietyB();
        List<Integer> p = MyCollect.getCross(m, n);
        List<Integer> q = MyCollect.getUnion(m, n);
        System.out.println("TaskA.3");
        VariantA3 var3 = new VariantA3();
        List<Integer> v = var3.ListOfNumbers();
        List<Integer> z = var3.RemovingZero(v);
        List<Integer> l = var3.Sorting(v);
    }
}
