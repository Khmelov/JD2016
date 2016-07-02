package by.it.novik.jd01_12;

import java.util.*;
import static by.it.novik.jd01_12.Utils.*;

/**
 * Created by Kate Novik.
 */
public class TaskB {

private String text =
                "The city of Washington was designed in the late eighteenth century.\n" +
                "It is coextensive with the District of Columbia.\n" +
                "When George Washington was elected President of the United States, there was no permanent capital to house the government.\n" +
                "Since members of Congress could not agree as to where the capital should be located, it was decided to choose a special place for the new capital.\n" +
                "The State of Maryland agreed to allot a wild and marshy area on the Potomac River.\n" +
                "The region was called the District of Columbia, after Christopher Columbus, and the capital was called Washington, after George Washington.\n" +
                "Work on the new capital began in 1791.\n" +
                "The man who designed the city was Major Pierre-Charles L'Enfant.\n" +
                "His grand geometric plan envisioned stately buildings as the city's core and a grassy, park-like mall with uninterrupted vistas west from the Capitol Building to the Potomac River.\n" +
                "Yet, even by the turn of the twentieth century, Washington showed little of the grandeur of this vision.\n" +
                "In the crowded area north of the Mall, factories and mills rubbed shoulders with stores, hotels, restaurants, and row houses.\n" +
                "The Mall itself had been broken into segments and landscaped with winding carriage roads and varied plantings that destroyed its symmetry.\n" +
                "For a time the Mall was also a transportation center, with railroad tracks crossing at Sixth Street that created an eyesore and safety hazard.\n" +
                "In 1901, as citizens sought to beautify urban areas throughout the United States, the Senate Park Commission (commonly known as the McMillan Commission after its chairman, Senator James McMillan) developed an influential new plan for Washington.\n" +
                "This plan aimed to return the city to the formality envisioned in the late eighteenth century and to invest it with a grandeur reflecting the nation's new sense of wealth and stature.\n" +
                "The Mall was to become a wide, formal lawn flanked by rows of trees, against a backdrop of classical buildings, many with domes.\n" +
                "At the foot of Capitol Hill, a Union Square was to be built with mounted statues of Civil War generals Grant, Sherman, and Sheridan, facing down the Mall.\n" +
                "The McMillam Commission had anticipated the need for a complex of government office building, and with the government's growth during World War I, the need was urgent by the 1920s.\n" +
                "It was the financier and art collector Andrew Mellon (1855-1937) who soon became deeply involved in the city's architecture.\n" +
                "As Secretary of Treasury, he was responsible for the realization of the so called Federal Triangular Project.\n" +
                "The core of the project was to reconstruct the large triangular area north of the Mall between Constitution and Pennsylvania Avenues, from Sixth to Fifteenth Street and to build offices for the government.\n" +
                "To ensure that the project would reflect the dignity and importance of the Federal Government, Mellon established a \"Board of Architectural Consultants\", which ultimately included John Russell Pope, one of America's most prominent architects.\n" +
                "Pope's contribution to the Federal Triangular Project was enormous.\n" +
                "Thanks to Pope's plan, Washington today is among the most beautiful cities in the world.";


    /**
     * Частота встречания слов в тексте
     * @return MapValues с указанием слова и его частоты встречания
     */
    public Map<String,Integer> frequencyOfWords () {
        Map<String,Integer> map = new HashMap<>();
        // Создадим массив из слов в тексте
        String[] words = text.split("[^a-zA-Z]+");
        for (int i=0; i<words.length;i++) {
            if (!map.containsKey(words[i])) {
            map.put(words[i],1); }
            else {
                int k = map.get(words[i]) + 1;
                map.put(words[i], k);
            }
        }
        return map;
    }

    /**
     * Создание и инициализация массива размерностью N с элементами от 1 до N
     * @param N размер массива
     * @return массив int[]
     */
    public Integer[] createArray (int N) {
        Integer [] array = new Integer [N];
        for (int i=0; i<N; i++) {
            array[i] = i+1;
        }
        return array;
    }

    /**
     * Метод вычеркивания каждого второго элемента, пока не останется один элемент (ArrayList)
     * @param array массив элементов
     * @return время, затраченное на операцию
     */
    public String processArray (Integer[] array) {
        int N = array.length;
        List<Integer> listA = new ArrayList<>(Arrays.asList(array));
        int i = 1; //Задаем позицию первого элемента для удаления
        long start = startTimeProcess();
        do {
        listA.remove(i);
            N--;
            if (i==N) {
                i = 1;
            } else if (i==N-1) {
                i = 0;
            } else {
                i+=1;}
        }
        while (N!=1);
        return deltaTimeProcess(start); //Время, затраченное на операцию
    }

    /**
     * Метод вычеркивания каждого второго элемента, пока не останется один элемент (LinkedList)
     * @param array массив элементов
     * @return время, затраченное на операцию
     */
    public String processLinked (Integer[] array) {
        int N = array.length;
        List<Integer> listL = new LinkedList<>(Arrays.asList(array));
        int i = 1; //Задаем позицию первого элемента для удаления
        long start = startTimeProcess();
        do {
            listL.remove(i);
            N--;
            if (i==N) {
                i = 1;
            } else if (i==N-1) {
                i = 0;
            } else {
            i+=1;}
        }
        while (N!=1);
        return deltaTimeProcess(start); //Время, затраченное на операцию
    }

   
}
