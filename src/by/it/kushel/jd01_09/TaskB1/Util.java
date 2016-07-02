package by.it.kushel.jd01_09.TaskB1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Diomn on 27.05.2016.
 */
public class Util {
    Pattern pat;
    Matcher mat;

    public void textSplit(String str) {
        pat = Pattern.compile("(^|[^A-Za-z])([A-Za-z]++)");
        mat = pat.matcher(str);
        Map<String, Integer> hm = new HashMap<String, Integer>();
        while (mat.find()) {
            String word = mat.group(2);
            if (hm.containsKey(word)) {
                int prevCounts = hm.get(word);
                hm.put(word, prevCounts + 1);
            } else {
                hm.put(word, 1);
            }
        }
        for (String word : hm.keySet()) {
            System.out.println(word + " --> " + hm.get(word));
        }
    }
}
