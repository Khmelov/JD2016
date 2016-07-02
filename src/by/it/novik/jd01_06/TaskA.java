package by.it.novik.jd01_06;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Created by Kate Novik.
 */
public class TaskA {

    /**
     * Замена в каждом слове текста буквы No 5-ю и 7-ю символом #. Для слов короче 5 корректировку не выполнять.
     */
    public void replaceCharInPoem() {
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        StringBuilder poem = new StringBuilder(data.getPoem()); //Вызываем метод для получения поля lukomor
        String regx = "[а-яА-ЯёЁ]{5,}";
        Pattern pat = Pattern.compile(regx);
        Matcher mat = pat.matcher(poem);
        while (mat.find()) {
            int start = mat.start();//запоминаем позицию 1-го символа, удовлетворяющий шаблону последовательности
            int length = mat.group().length();//запоминаем длину последовательности
            poem.setCharAt(start+4, '#');
            if (length > 6) {
                poem.setCharAt(start + 6, '#');
            }
        }
        System.out.println("Текст с символом '#' на 5-м и 7-м месте в словах, удовлеттворяющих паттерну");
        System.out.println(poem); //Печать текста

    }

    /**
     * Определение количества раз повторения в тексте каждого слова, которое встречается в нем.
     */
    public void repeatWords() {
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        String poem = data.getPoem(); //Вызываем метод для получения поля lukomor
       // String poemS = poem.toString();
        String regx = "[^а-яА-ЯёЁ]+";
        String[] arrayWords = poem.split(regx);
        long start = System.currentTimeMillis();
        for (int i = 0; i < arrayWords.length; i++) {
            if (!arrayWords[i].isEmpty()) {
                int count = 1;
                for (int j = i + 1; j < arrayWords.length; j++) {
                    if (arrayWords[i].equals(arrayWords[j])) {
                        count++;
                        arrayWords[j] = "";
                    }
                }
                System.out.println("Число повторов \"" + arrayWords[i] + "\" count=" + count);

            }
        }
        System.out.println("Затрачено времени: " + (System.currentTimeMillis() - start) + " ms");
       //Второй способ решения и вычисление времени, затраченного на него
        String[] arrayWords2 = poem.split(regx);
        Map<String, Integer> repeats = new HashMap<>();
        start = System.currentTimeMillis();
        for(String word: arrayWords2){
            int value = repeats.containsKey(word) ?  (repeats.get(word) + 1) : 1;
            repeats.put(word,value);
        }
        System.out.println("Затрачено времени 2: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(repeats);
    }

    /**
     *Поиск количества слов, начинающихся и заканчивающихся гласной буквой.
     */
    public void countWordsWithVowel (){
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        StringBuilder poem = new StringBuilder(data.getPoem()); //Вызываем метод для получения поля lukomor
        String regx = "(^|[^а-яА-ЯёЁ]+)([яыуаиеоюэЯЫУАИЕОЮЭ])([а-яА-ЯёЁ]*[яыуаиеоюэЯЫУАИЕОЮЭ]|)[^а-яА-ЯёЁ]+";
        Pattern pat = Pattern.compile(regx);
        Matcher mat = pat.matcher(poem);
        int count=0;
        while (mat.find()) {
                count++;
          }
        System.out.println("Количество слов, начинающихся и заканчивающихся гласной буквой count=" + count);
        }

}