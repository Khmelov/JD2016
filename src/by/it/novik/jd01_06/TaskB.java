package by.it.novik.jd01_06;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kate Novik.
 */
public class TaskB {

    /**
     * Удаление из текста все слова длины 5, начинающиеся на согласную букву
     */
   /* //2-й способ решения
        public void deleteWords (){
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        StringBuilder poem = new StringBuilder (data.getPoem()); //Вызываем метод для получения поля lukomor
        String regx="[а-яА-ЯёЁ]+";
        Pattern p =Pattern.compile(regx);
        Matcher m=p.matcher(poem);
        String consonants="абвгджзклмнпрстфхцчшщ";
        consonants=consonants+consonants.toUpperCase();
     while (m.find()){
         String word=m.group();
         if(word.length()==5){
         char first=word.charAt(0);
         if (consonants.indexOf(first)>=0){
             poem.delete(m.start(),m.end()+1);//удаляем слово длиной 5
             m.reset(); //Перезагружаем matcher для подхвата новой строки
         }}
     }
        System.out.println("Из текста удалить все слова длины 5, начинающиеся на согласную букву.");
        System.out.println(poem);
    }
*/
    public void deleteWords() {
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        StringBuilder poem = new StringBuilder(data.getPoem()); //Вызываем метод для получения поля lukomor
        String regx = "(^|[^а-яА-ЯёЁ]+)([абвгджзклмнпрстфхцчшщАБВГДЖЗКЛМНПРСТФХЦЧШЩ][а-яА-ЯёЁ]{4})[^а-яА-ЯёЁ]+";
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(poem);
        while (m.find()) {
            poem.delete(m.start(2), m.end(2));//удаляем слово длиной 5 (2-я группа в регулярке)
            m.reset(); //Перезагружаем matcher для подхвата новой строки

        }
        System.out.println("Из текста удалить все слова длины 5, начинающиеся на согласную букву.");
        System.out.println(poem);
    }

    /**
     * Вывод предложений заданного текста в порядке возрастания количества слов в каждом из них без переноса строк в каждом предложении.
     */
    public void outputTextSortUpCountOfWords() {
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        StringBuilder poem = new StringBuilder(data.getPoem()); //Вызываем метод для получения поля lukomor
        String regx = "[а-яА-ЯёЁ:;,\\s-]+(\\.\\.\\.)?[а-яА-ЯёЁ:;,\\s-]+[\\.?!](\\s|$)";
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(poem);
        int count = 0; //Количество предложений в тексте
        //Определяем количество предложений в тексте
        while (m.find()) {
            count++;
        }
        //Создаем массив предложений размером count
        String[] sentences = new String[count];
        int i = 0;
        m.reset(); //Перегрузка Matcher
        while (m.find()) {
            //Убираем переводы строки в каждом предложении
            sentences[i] = m.group().replaceAll("\\n", " ");
            i++;
        }
        //Создаем MapValues для хранения пары количество слов в предложениии-список предложений (т.к. могут быть с одинаковым размером предложении)
        Map<Integer, List<String>> countWordsSentences = new HashMap<>();
        for (String sen : sentences) {
            String[] arrayWords = sen.split("[^а-яА-ЯёЁ]"); //Массив слов для каждого предложения
            if (countWordsSentences.containsKey(arrayWords.length)) { //Проверка на наличия такого ключа(размера массива слов) в MapValues
                List<String> listSentences = countWordsSentences.get(arrayWords.length); //Получение листа по ключу и добавление к нему ещё одного предложения
                listSentences.add(sen);
            } else {
                List<String> listSentences = new ArrayList<>(); //Создание нового листа
                listSentences.add(sen);
                countWordsSentences.put(arrayWords.length, listSentences); //Добавление листа с ключом в MapValues
            }
        }
        //Получение списка ключей(количество слов в предложении) для сортировки
        List<Integer> amountWords = new ArrayList<>(countWordsSentences.keySet());
        Collections.sort(amountWords);
        System.out.println("Вывод предложений в порядке возрастания количества слов в каждом из них без переноса строк в предложениях.");
        for (Integer k : amountWords) {
            for(String sen : countWordsSentences.get(k)) {
                System.out.println(sen);
            }
        }
    }

    /**
     * Сортировка слов в тексте по убыванию количества вхождений заданного символа, а в случае равенства — по алфавиту.
     *
     * @param key Символ для поиска в слове
     */
    public void sortDescendingAmountCharactersInWord(char key) {
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        String poem = data.getPoem(); //Вызываем метод для получения поля lukomor
        String regx = "[^а-яА-ЯёЁ]+";
        String[] arrayWords = poem.split(regx);
        String min;
        int count_first;
        int count_second;
        for (int i = 0; i < arrayWords.length - 1; i++) {

            //System.out.println(arrayWords[i].length());
            for (int k = i + 1; k < arrayWords.length; k++) {
                count_second = 0;
                count_first = 0;
                for (int j = 0; j < arrayWords[i].length(); j++) {
                    if (arrayWords[i].charAt(j) == key || arrayWords[i].charAt(j) == Character.toUpperCase(key)) {
                        count_first++;
                    }
                }
                //System.out.println(arrayWords[k].length());
                for (int j = 0; j < arrayWords[k].length(); j++) {
                    if (arrayWords[k].charAt(j) == key || arrayWords[k].charAt(j) == Character.toUpperCase(key)) {
                        count_second++;
                    }
                }
                // System.out.println(count_second);
                if (count_first < count_second) {
                    min = arrayWords[i];
                    arrayWords[i] = arrayWords[k];
                    arrayWords[k] = min;
                    // count_first=count_second;
                }
                if (count_first == count_second) {
                    if (arrayWords[i].compareToIgnoreCase(arrayWords[k]) > 0) {
                        min = arrayWords[k];
                        arrayWords[k] = arrayWords[i];
                        arrayWords[i] = min;
                    }
                }
            }
        }
        System.out.println("Сортировка слов в тексте по убыванию количества вхождений заданного символа, а в случае равенства — по алфавиту.");
        int col = 1;
        for (String word : arrayWords) {
            System.out.print(word.concat(" "));
            if (col % 5 == 0)
                System.out.println("");
            col++;

        }
        System.out.println("");

    }

}
