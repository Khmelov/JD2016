package by.it.sergeev.jd01_12;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;


public class TaskB {
    //B1.
    public static void createHashMap() {
        StringBuilder text = new StringBuilder(Text.getString());
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        Pattern word = Pattern.compile("[a-zA-Z]+");
        Matcher m = word.matcher(text);
        while (m.find()) {
            String key = text.substring(m.start(), m.end());
            if (hm.containsKey(key)) {
                hm.put(key, hm.get(key) + 1);
            } else hm.put(key, 1);


            for (Map.Entry entry : hm.entrySet()) {
                System.out.println("\"" + entry.getKey() + "\" повторяется " + entry.getValue() + " раз(а)");
            }
        }
    }
    //B2.
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));






    public static ArrayList<Integer> createArray(int count){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(i+1);
        }
        return list;
    }
}
