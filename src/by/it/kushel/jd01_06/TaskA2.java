
package by.it.kushel.jd01_06;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Diomn on 10.05.2016.
 */
public class TaskA2 {
    public static void main(String[] arg) {
        Pattern pat;
        Matcher mat;
        boolean found;
        String str = new String(Data.lukomor);
        pat = Pattern.compile("(^|[^А-яа-яЁё])([А-Яа-яЁё]++)");
        mat = pat.matcher(str);// Создание объекта класса Matcher с помощью фабричного метода matcher
        Map<String, Integer> hm = new HashMap<String, Integer>();


        while (mat.find()) {

            String word = mat.group(2).toLowerCase();

            if (hm.containsKey(word)) {
                int prevCounts = hm.get(word);
                hm.put(word, prevCounts + 1);
            } else {
                hm.put(word, 1);
            }
        }
        for (String word : hm.keySet()) {
            System.out.println(word+" --> " +hm.get(word));
        }

    }
}
