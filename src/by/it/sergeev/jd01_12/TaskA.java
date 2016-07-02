package by.it.sergeev.jd01_12;

import java.util.ArrayList;


public class TaskA {
    //A1.Создать список оценок учеников с помощью ArrayList,заполнить случайными оценками.Удалить неудовлетворительные оценки из списка. Вывести на консоль оба варианта.
    public static ArrayList<Integer> createArrayList() {
        ArrayList<Integer> rating = new ArrayList<Integer>();
        System.out.println("Список всех оценок :");
        for (int i = 0; i < 40; i++) {
            int random = Util.generateRandom(11);
            rating.add(random);
            System.out.print(rating.get(i) + " ");
        }
        System.out.println("\n" + "Положительные оценки :");
        for (Integer x : rating) {
            if (x >= 4)
                System.out.print(x + " ");
        }
        return rating;
    }

    public static ArrayList<Integer> createArrayList2() {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        System.out.println ("A" + " | " + "B");
        for (int i = 0; i < 11; i++) {
            int randomA = Util.generateRandom(10);
            A.add(randomA);
            int randomB = Util.generateRandom(10);
            B.add(randomB);
            System.out.println (A.get(i)+ " | " + B.get(i));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
        MyCollect.getCross(A,B);
        MyCollect.getUnion(A,B);
        return A;
    }

    public static ArrayList<Integer> createArrayList3()
    {
        System.out.println("Рандомный список чисел :");
        ArrayList<Integer> sortRating = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            int random = Util.generateRandomPositiveNegative(22);
            {
                if (random >= 0)
                    sortRating.add(0, random);
                else if (random < 0)
                    sortRating.add(random);
            }
        }
        for (Integer a : sortRating)
        {
            System.out.print(a + " ");
        }
        return sortRating;
    }
}

