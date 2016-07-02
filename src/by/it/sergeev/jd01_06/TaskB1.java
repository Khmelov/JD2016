package by.it.sergeev.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void PushkinB() {
        char[] chars = "БВГДЖЗЙКЛМНПРСТФХЦЧШЩ".toCharArray();
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("\\b([а-яА-ЯёЁ])(.+?)\\b").matcher(Pushkin.getString());
        //PatternFloat compile(String regex) – возвращает PatternFloat, который соответствует regex.
        //Matcher matcher(CharSequence input) – возвращает Matcher, с помощью которого можно находить соответствия в строке input.
        //\b  Граница слова
        int count = 0;
        while (m.find()) {
            if (m.group(2).length() == 4 && Arrays.binarySearch(chars, m.group(1).toUpperCase().charAt(0)) >= 0) {
                count++;
                System.out.print(m.group() + " ");
                m.appendReplacement(sb, "___"); //добавление и замена
            }
        }
        System.out.println();
        System.out.println("Количество слов: " + count + '\n');
        m.appendTail(sb); //после appendReplacement добавления оставшейся части строки в sb
        System.out.println(sb);

        }
    }
