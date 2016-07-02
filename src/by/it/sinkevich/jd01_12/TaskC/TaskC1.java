package by.it.sinkevich.jd01_12.TaskC;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TaskC1 class
 *
 * @author Sinkevich Denis
 */
class TaskC1 {

    private Map<Integer, String> idNameMap;

    TaskC1() {
        idNameMap = new TreeMap<>();
    }

    //В качестве наимменований объектов принимаем слова из текста, каждому слову выдаём уникальный номер ID.
    Map<Integer, String> fillMapWithObjectNames() {
        Pattern pattern = Pattern.compile("\\b[A-Za-z]+\\b");
        String text = EnglishText.TEXT;
        Matcher matcher = pattern.matcher(text);
        int idCounter = 0;
        while (matcher.find()) {
            idCounter++;
            idNameMap.put(idCounter, matcher.group());
        }
        return idNameMap;
    }

    Map<Integer, String> compressList() {
        //Создаём список всех уникальных наименований записывая их в Set
        Set<String> uniqueValues = new HashSet<>(idNameMap.values());
        //Сравниваем все значения с уже имеющимисяс в коллекции, первое совпадение оставляем, остальные удаляем
        for (String objectName : uniqueValues) {
            int counter = 0;
            Set<Map.Entry<Integer, String>> entry = idNameMap.entrySet();
            Iterator<Map.Entry<Integer, String>> iterator = entry.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> pair = iterator.next();
                if (pair.getValue().equals(objectName)) {
                    if (counter == 0) {
                        counter++;
                    } else {
                        iterator.remove();
                    }
                }
            }
        }
        return idNameMap;
    }

    void printMap() {
        int counter = 1;
        for (Integer key : idNameMap.keySet()) {
            System.out.print(key + " = " + idNameMap.get(key));
            if (counter % 5 != 0) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
            counter++;
        }
    }
}
