package by.it.sergeev.jd02_04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    public static String Line() {
        String text = null;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            text = bf.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка!");
        }
        return text;
    }

    public static List<String> Hex(String s) {

        List<String> list = new ArrayList<>();
        Pattern pat = Pattern.compile("\\b0x[\\da-fA-F]+\\b");
        Matcher mat = pat.matcher(s);
        while (mat.find()) {
            list.add(mat.group());
        }
        return list;
    }

    public static void printHex(List<String> list) {

        for (String s : list) {
            System.out.println(s);
        }
    }
}
