package by.it.kust.jd01_12.taskB;

import java.util.HashMap;

/**
 * Created by Tanya Kust.
 */
public class TaskB1 {
    /**
     * Создает карту(ключ,значение), массив слов и заполняет карту словами из массива с указанием кол-ва повторений
     * @return карту (слово, кол-во поторений)
     */
   public static HashMap<String,Integer> createHashMap(){
       HashMap<String,Integer> wordsToHashMap = new HashMap<>();
       String[] words = Text.text.split("[^a-zA-Z]+");
       for (int i=0; i<words.length; i++){
           if (!wordsToHashMap.containsKey(words[i])){
               wordsToHashMap.put(words[i],1);
           }else {
               wordsToHashMap.replace(words[i],wordsToHashMap.get(words[i])+1);
           }
       }
       return wordsToHashMap;
   }


}
