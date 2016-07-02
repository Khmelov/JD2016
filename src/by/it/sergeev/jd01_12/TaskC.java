package by.it.sergeev.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    public static TreeMap<Integer, String> createTreeMap(String text) {
        TreeMap<Integer, String> tm = new TreeMap<>();
        Pattern word = Pattern.compile("[a-zA-Z]+");
        Matcher m = word.matcher(text);

        int n = 0;
        while (m.find()) {
            n++;
            String st = m.group();
            tm.put(n, st);
        }
        return tm;
    }

    public static TreeMap<Integer, String> compressedEncryption(TreeMap<Integer, String> tm) {
        TreeMap<Integer, String> cryption = new TreeMap<>();
        for (Map.Entry pair : tm.entrySet())
            if (!cryption.containsValue(pair.getValue()))
                cryption.put((Integer) pair.getKey(), (String) pair.getValue());
        return cryption;
    }

    public static void printEncryption(TreeMap<Integer, String> tm) {
        for (Map.Entry pair : tm.entrySet())
            System.out.print(pair.getValue() + "-" + pair.getKey() + "\t");
    }

    //C2.
    public static ArrayList<Object> createArrayListC2() {
        ArrayList<Object> A = new ArrayList<>();
        ArrayList<Object> B = new ArrayList<>();
        System.out.println("A" + " | " + "B");
        for (int i = 0; i < 11; i++) {
            int randomA = Util.generateRandom(10);
            A.add(randomA);
            int randomB = Util.generateRandom(10);
            B.add(randomB);
            System.out.println(A.get(i) + " | " + B.get(i));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
        MyCollect.getCross2(A, B);
        MyCollect.getUnion2(A, B);
        return A;
    }

    //C3.
    public static boolean brackets(String text){
        ArrayDeque<Character> adq = new ArrayDeque<>();
        for (char a : text.toCharArray())
        {
            if ('(' == a || '[' == a || '{' == a)
            {
                adq.push(a);
                continue;
            }
            if (')' == a || ']' == a || '}' == a)
            {
                if (!adq.isEmpty())
                {
                    char b = adq.pop();
                    if ((b == '(' && a == ')') || (b == '[' && a == ']') || (b == '{' && a == '}'))
                    {
                        continue;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                    {
                    return false;
                    }
            }
        }
        if (!adq.isEmpty())
        {
            return false;
        }
        return true;
    }
}