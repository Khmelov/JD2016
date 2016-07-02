package by.it.novik.jd01_06;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kate Novik.
 */
public class TaskC {

    /**
     * Форматирование текста с выравниванием по обоим краям
     */
    public void alignLines() {
        System.out.println("Выполнить форматирование с выравниванием по обоим краям.");
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        String poem = data.getPoem(); //Вызываем метод для получения поля poem
        String[] lines = poem.split("\\n"); //Разбиваем по переводу строки весь текст
        int maxLine = 0; //Максимальная длина строки
        for (String line : lines) { //Вычисление максимальной строки в тексте
            if (maxLine < line.length()) {
                maxLine = line.length();
            }
        }
        for (String line : lines) {
            String[] words = line.split("\\s"); //Разбиение строки на массив слов
            int n = maxLine - line.length(); //Вычисляем количество нехватающих пробелов
            int k = n / (words.length - 1); //Целая часть при делении укажет, нколичество вставляемых пробелов между всеми словами в строке
            String l = "";
            int d = n % (words.length - 1); //Указывает между сколькими словами нужно добавить еще по пробелу
            String spacesLine = " ";
            for (int i = 0; i < k; i++) {
                spacesLine += " ";
            }
            for (int i = 0; i < words.length; i++) {
                if (i != words.length - 1) {
                    l = l + words[i] + spacesLine;
                    if (i < d) {
                        l += " ";
                    }
                } else {
                    l = l + words[i];
                }
            }
            System.out.println(l);
        }
    }

    /**
     *Получение строки (String) ровно (!) в в миллион символов из случайных слов стихотворения путем конкатенации.
     *Слова через пробел. Последнее слово нужно подобрать по длине.
     * @return Скорость выполнения программы в мс
     */
    public long randomWordsFirst () {
        System.out.println("Получение строки ровно (!) в в миллион символов из случайных слов стихотворения.");
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        String poem = data.getPoem(); //Вызываем метод для получения поля poem
        String[] words = poem.split("[^а-яА-ЯёЁ]+");
        String line = "";
        String space = " ";
        int limit = 1000000;
        long start=System.currentTimeMillis(); //Начальное время выполнения
        int i = 0;
        while (line.length() < limit) {
            Random r = new Random();
            //получаем случайную строку
            int iRand = r.nextInt(words.length);
            String wRand = words[iRand];
//           System.out.println(wRand);
            if (wRand.length() + 1 < limit - line.length()) {
                line = line.concat(wRand).concat(space);}
            if (wRand.length() + 1 == limit - line.length()) {
                line = line.concat(wRand);}

            if (wRand.length() > limit - line.length()) {
                while (line.length() + wRand.length() != limit) {
                    r = new Random();
                    //получаем случайную строку
                    iRand = r.nextInt(words.length);
                    wRand = words[iRand];
                }
                line = line.concat(wRand);
            }
            i++;
            //if(i % 100 == 0) {
            //    System.out.println("Part length: " + line.length());
            //}
        }
        System.out.println(line + ",  \n"  + "Метод1 " + line.length() + "  " + (System.currentTimeMillis()-start) + "мс");
return System.currentTimeMillis()-start;
    }

    /**
     *Получение строки (StringBuilder) ровно (!) в в миллион символов из случайных слов стихотворения путем конкатенации.
     *Слова через пробел. Последнее слово нужно подобрать по длине.
     * @return Скорость выполнения программы в мс
     */
    public long randomWordsSecond () {
        System.out.println("Получение строки ровно (!) в в миллион символов из случайных слов стихотворения.");
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        String poem = data.getPoem(); //Вызываем метод для получения поля lukomor
        String[] words = poem.split("[^а-яА-ЯёЁ]+");
        StringBuilder line = new StringBuilder(1000000);
        String space = " ";
        int limit = 1000000;
        long start=System.currentTimeMillis();
        int i = 0;
        while (line.length() < limit) {
            Random r = new Random();
            //получаем случайную строку
            int iRand = r.nextInt(words.length);
            String wRand = words[iRand];
//           System.out.println(wRand);
            if (wRand.length() + 1 < limit - line.length()) {
                line = line.append(wRand).append(space);}
            if (wRand.length() + 1 == limit - line.length()) {
                line = line.append(wRand);}

            if (wRand.length() > limit - line.length()) {
                while (line.length() + wRand.length() != limit) {
                    r = new Random();
                    //получаем случайную строку
                    iRand = r.nextInt(words.length);
                    wRand = words[iRand];
                }
                line = line.append(wRand);
            }
           // i++;
           // if(i % 100 == 0) {
           //     System.out.println("Part length: " + line.length());
           // }
        }
        System.out.println(line + ",  \n" + "Метод2 " + line.length() + "  " + (System.currentTimeMillis()-start)+ "мс");
return System.currentTimeMillis()-start;
    }


    /**
     * Сортировка слов текста в порядке убывания их длин, все слова одинаковой длины - в порядке возрастания в них количества гласных букв.
     * Одинаковые слова сгруппировать и выводить один раз с числом их повторов в тексте. Регистр неважен.
     */
    public void sortDescendingLengthOfWords() {
        System.out.println("Сортировка слов текста в порядке убывания их длин, при == - в порядке возрастания кол-ва гласных букв, группировка одинаковых слов.");
        Data data = new Data(); //Создаем объект с полем для хранения стихотворения
        String poem = data.getPoem(); //Вызываем метод для получения поля poem
        String[] words = poem.split("[^а-яА-ЯёЁ]+");
        Map<String, Integer> repeats = new HashMap<>(); //Создаем MapValues для хранения одинаковых слов (ключ-слово, value-количество повторений)
        for (int i = 0; i < words.length - 1; i++) {
            if (!words[i].isEmpty()) { //Если нет пустых значений

                for (int j = i + 1; j < words.length; j++) {
                    if (!words[i].equalsIgnoreCase(words[j])) {
                        if (words[i].length() != words[j].length()) { //Пузырьковая сортировка по длине
                            if (words[i].length() < words[j].length()) {
                                String temp = words[i];
                                words[i] = words[j];
                                words[j] = temp;
                            }
                        } else {
                            int countI = 0; //Количество гласных букв в первом слове
                            int countJ = 0; //Количество гласных букв во втором слове
                            Pattern p = Pattern.compile("[яыуаиеоюэЯЫУАИЕОЮЭ]");
                            Matcher m = p.matcher(words[i]);
                            while (m.find()) {
                                countI++;
                            }
                            m.reset(words[j]);
                            while (m.find()) {
                                countJ++;
                            }
                            if (countI > countJ) { //Сравнивает слова по количеству гласных букв
                                String temp = words[i];
                                words[i] = words[j];
                                words[j] = temp;
                            }
                        }
                    } else {
                        words[j] = ""; //Если слова равны, то заменяем на пустое повторяющееся слово
                        if (repeats.containsKey(words[i])) { //Проверка на наличие повторяющегося слова в MapValues
                            repeats.put(words[i], repeats.get(words[i]) + 1);
                        } else {
                            repeats.put(words[i], 2);
                        }

                    }
                }
            }

        }
        System.out.println("Отсортированные слова");
        int col = 1;
        for (String word : words) { //Вывод отсортированных слов
            if (!word.isEmpty()) { //Не выводим пустые значения
                if (repeats.containsKey(word)) {//Если слово для вывода содержится в MapValues, то выводим его с количеством повторений
                    System.out.print(word.concat("(").concat(repeats.get(word).toString()).concat(") "));
                } else {
                    System.out.print(word.concat(" "));
                }
                col++;
                if (col % 16 == 0) { //Вывод слов в 16 колонок
                    System.out.println("");
                }
            }

        }
    }
}
