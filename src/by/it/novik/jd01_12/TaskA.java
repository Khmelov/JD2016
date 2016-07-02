package by.it.novik.jd01_12;

import java.util.*;

import static java.lang.Math.*;

/**
 * Created by Kate Novik.
 */
public class TaskA {

    /**
     * Создание и заполнение случайными числами списка оценок учеников
     * @return Созданный список оценок List<Integer>
     */
    public List<Integer> createListOfMarksOfPupils () {
        // Создадим список оценок учеников
        List<Integer> listOfMarks = new ArrayList<>();
        // Заполним случайными элементами от 1 до 10 список оценок
        for (int i=0; i<=20;i++) {
            listOfMarks.add( (int)round(random()*9+1));
        }
        return listOfMarks;
    }

    /**
     * Удаление неудовлетворительных оценок в списке оценок учеников
     * @param listOfMarks Список оценок учеников
     * @return Список оценок с удаленными нкудовлетворительными оценками
     */
    public List<Integer> deleteUnsatisfactoryMarks (List<Integer> listOfMarks) {
        Iterator<Integer> it = listOfMarks.iterator();
        while (it.hasNext()) {
            Integer mark = it.next();
            if (mark == 1 || mark == 2 || mark == 3) { // Проверка оценки на неудовлетворительность
                it.remove(); // Удаление оценки
            }
        }
        ArrayList<Integer> list = (ArrayList<Integer>) listOfMarks;
        list.trimToSize(); // Уменьшение размера List после удаления элементов
        return list;
    }

    /**
     * Создание множества A из чисел от 0 до 15
     * @return Множество А Set<Integer>
     */
    public Set<Integer> getSetA () {
        Set<Integer> setA = new HashSet<>();
        for (int i=0; i<15; i++) {
            setA.add(i);
        }
        return setA;
    }

    /**
     * Создание множества B из чисел от 10 до 25
     * @return Множество B Set<Integer>
     */
    public Set<Integer> getSetB () {
        Set<Integer> setB = new HashSet<>();
        for (int i=10; i<25; i++) {
            setB.add(i);
        }
        return setB;
    }

    /**
     * Создание и заполнение ArrayList случайными элементами от -10 до 10
     * @return Список ArrayList
     */
    public List<Integer> createList () {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<20; i++) {
            list.add( (int)round(random()*20-10)); // Заполнение ArrayList случайными элементами от -10 до 10
        }
        return list;
    }

    /**
     * Сортировка списка чисел в обратном порядке
     * @param list Список для сортировки
     * @return Отсортированный список с отрицательными элементами в конце списка
     */
    public List<Integer> sortDescList (List<Integer> list) {
        Collections.sort(list, Collections.<Integer>reverseOrder()); // Сортировка в обратном порядке
        return list;
    }


}
