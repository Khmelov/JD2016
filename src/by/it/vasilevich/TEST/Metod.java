package by.it.vasilevich.TEST;

/**
 * Created by User on 21.05.2016.
 */
public class Metod {
    public static void Time (int s)    {
        int sec, m, min, h, hour, d, day, w;
        sec = s % 60;//кол-во секунд
        m = (s - sec) / 60;//оставшиеся секунды перевели в минуты
        min = m % 60;//кол-во минут
        h = (m - min) / 60;//оставшиеся минуты перевели в часы
        hour = h % 24;//кол-во часов
        d = (h - hour) / 24;//оставшиеся часы перевели в дни
        day = d % 7;//кол-во дней
        w = (d - day) / 7;//оставшиеся дни перевели в недели
        System.out.println(s+" секунд - это "+w+" недель "+day+" дней "+hour+" часов "+min+" минут "+sec+" секунд");
    }

    public static void EvenOdd (int x){
        int y=x%10;
        if (y == 7)
            System.out.println("Последняя цифра числа " + x + " является семеркой.");
        else
            System.out.println("Последняя цифра числа " + x + " не является семеркой.");
    }

    public static void Radius (double r){
        int a=3;
        int b=5;
        double rad=Math.sqrt((a*a+b*b)/2);
        if (r>=rad)
            System.out.println("Круглой картонкой радиусом "+r+" можно полностью закрыть прямоугольное отверстие.");
        else
            System.out.println("Круглой картонкой радиусом "+r+" нельзя полностью закрыть прямоугольное отверстие.");
    }

    public static void Year (int year) {
        if (year < 2011) {
            System.out.println("вариант a");
        } else if (year > 2011) {
            System.out.println("вариант b");
        } else if (year > 2015) {
            System.out.println("вариант c");
        } else {
            System.out.println("xxxx");
        }
    }

    public static void Rubl (int x) {
        if (x==1||x>=21&&x%10==1) {
            System.out.println(x+" рубль");
        } else if (x>=2&&x<5||x>=22&&x%10>1&&x%10<5){
            System.out.println(x+" рубля");
        } else if (x>=5&&x<21||(x>=25&&x%10==0||x%10>=5)){
            System.out.println(x+" рублей");


    }
    }
}
