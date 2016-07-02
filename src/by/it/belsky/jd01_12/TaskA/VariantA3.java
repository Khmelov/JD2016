package by.it.belsky.jd01_12.TaskA;

import java.util.*;

/**
 * Created by misha on 11.06.2016.
 */
public class VariantA3 {
    public List<Integer> ListOfNumbers() {
        List<Integer> list = new ArrayList<>();
        {
            for (int i = 0; i < 18; i++)
                list.add((int) (Math.random() * 15 - 9));

        }

        return list;
    }

    public List<Integer> RemovingZero(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        {
            while (iterator.hasNext()) {
                Integer mark = iterator.next();
                if (mark == 0) {
                    iterator.remove();
                }
            }
            System.out.println("Список случайных чисел:                     " + list);
        }
        return list;
    }
    public List<Integer> Sorting (List<Integer> list)  {
        //List<Integer> sort = new ArrayList<>(list);
     Collections.sort(list, Collections.reverseOrder());

        System.out.println("Cписок, отсортированный в обратном порядке :"+list);
        return list;
       }

    }

