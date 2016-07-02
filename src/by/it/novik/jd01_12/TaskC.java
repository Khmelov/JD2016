package by.it.novik.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kate Novik.
 */
public class TaskC  {
   private String text = "Is it possible to live without traveling? Probably yes, but very difficult.\n" +
                          "Millions of people travel around the world just for fun.\n" +
                          "Travels broaden the mind, make a person be more friendly and open.\n" +
                          "Journeys could be made in different ways.\n" +
                          "You might travel by plane, by bus, by rail or by your own car.\n" +
                          "As for me, I'm just crazy about travelling by sea.\n" +
                          "I believe that this voyage gives you a lot of unforgettable emotions and impressions.\n" +
                          "If you make for the open sea by ferry, in this case you have a wonderful opportunity\n" +
                          "to see the depth of the sea, the purity of water and living marine animals in all their beauty.\n" +
                          "Besides, a good opportunity arises - swimming in pure water.\n" +
                          "Nevertheless, I do not like jellyfish too much and at any case try to avoid their presence.";
//private String text = "true, false, true, yes, no, no";


    /**
     * Получение TreeMap из слов и их шифра (хэшкода)
     * @return TreeMap <Integer,List<String>>
     */
    public Map<Integer,Set<String>> getObjectsWithHashCode () {
        // Разделим текст на массив слов
        String[] words = text.split("[^a-zA-Z]+");
        // Объявим переменную для вычисления hashcode слова
        Integer hash;
        // Создадим TreeMap для хранения слов, отсортированных по ключу-хэшу
        Map<Integer,Set<String>> c1 = new TreeMap<>();
        for (int i=0; i<words.length;i++) {
           hash = words[i].hashCode();
            //hash = i;
            if (!c1.containsKey(hash)) {
                Set<String> list = new HashSet<>();
                list.add(words[i]);
                c1.put(hash,list); }
            else {
                Set<String> currList = c1.get(hash);
                currList.add(words[i]);
                c1.put(hash,currList);
            }
        }
        return c1;
    }

    /**
     * Сжатие MapValues (удаление повторяющихся значений)
     * @param c1 текущий MapValues
     * @return сжатый MapValues
     */
    public Map<Integer,Set<String>> compressionMap (Map<Integer,Set<String>> c1) {
        //Создадим map для хранения повторяющихся значений
        Map<Integer,Set<String>> result = new TreeMap<> ();
        int k; int i=1;
        //Запишем в map result необходимые для удаления повторяющиеся значения и соответствующие им ключи
        for (Map.Entry<Integer,Set<String>> entry : c1.entrySet()) {
            k=1;
            Set<String> temp1 = entry.getValue();
            i++;
            for (Map.Entry<Integer,Set<String>> r : c1.entrySet()) {
                if (k>=i) {
                    Set<String> temp2 = r.getValue();
                    Set<String> temp3 = new HashSet<>(temp1);
                    temp3.retainAll(temp2); //Нахождение пересечений
                    if (!temp3.isEmpty()) {
                        result.put(r.getKey(),temp3);
                    }
                }
                k++;
            }
        }
        // Распечатаем MapValues result, содержащий значения для удаления
        System.out.println(result);
        // Создаем итератор для удаления повторяющихся значений в c1
        Iterator<Map.Entry<Integer,Set<String>>> it = c1.entrySet().iterator();
        for (Map.Entry<Integer,Set<String>> r : result.entrySet()) {
            Integer key = r.getKey();
            Set<String> s = r.getValue();
            while (it.hasNext()) {
                Map.Entry<Integer,Set<String>> map = it.next();
                Integer key2 = map.getKey();
                Set<String> set = map.getValue();
                //Удаляем повторяющиеся значения из MapValues c1
                if (key.equals(key2) && set.size()>1) {
                   set.removeAll(s);
                    break;
                }
                else if (key.equals(key2) && set.size()==1) {
                    it.remove();
                    break;
                }
            }
        }
        return c1;
    }


    /**
     * Определение пересечения двух множеств
     * @param setA Множество А
     * @param setB Множество В
     * @return Результат пересечения множеств А и В
     */
    public  Set<Object> getCross (Set<Object> setA, Set<Object> setB) {
        Set<Object> listCrossing = new HashSet<>(setA);
        listCrossing.retainAll(setB); // Метод возвращает пересечение множеств
        return listCrossing;
    }

    /**
     * Объединение двух множеств
     * @param setA Множество А
     * @param setB Множество В
     * @return Результат объединения множеств А и В
     */
    public Set<Object> getUnion (Set<Object> setA, Set<Object> setB) {
        Set<Object> listUnion = new HashSet<>(setA);
        listUnion.addAll(setB); // Метод возвращает объединение множеств
        return listUnion;
    }

    /**
     * Проверка строки на корректность расстановки скобок
     * @param line строка
     * @return результат проверки на корректность
     */
    public String checkExp (String line) {
        boolean check = false;
        //Создаем LinkedList для хранения найденных открывающихся скобок
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
    while (i<line.length()) {
    if (line.charAt(i) == '{' || line.charAt(i) == '[' || line.charAt(i) == '(') {
        list.addFirst(Character.toString(line.charAt(i)));
    }
    if (line.charAt(i) == '}' || line.charAt(i) == ']' || line.charAt(i) == ')' && !list.isEmpty()) {
        if (list.getFirst().equals("{") && line.charAt(i) == '}') {
            list.removeFirst();
        }
        else if (list.getFirst().equals("[") && line.charAt(i) == ']') {
            list.removeFirst();
        }
        else if (list.getFirst().equals("(") && line.charAt(i) == ')') {
            list.removeFirst();
        }
        else {
            return "Расстановка не корректная";
        }
    }
    else if (line.charAt(i) == '}' || line.charAt(i) == ']' || line.charAt(i) == ')' && list.isEmpty()) {

        return "Расстановка не корректная";
    }
    i++;
}
        if (!list.isEmpty()) {
            return "Расстановка не корректная";
        }
        return "Расстановка корректная";
    }

}
