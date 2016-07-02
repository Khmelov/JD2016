package by.it.kushel.jd02_5;

import java.util.Locale;

public class Hello {
    public static void main(String[] args) {
        Locale loc1 = new Locale("ru", "RU");
        Locale loc2 = new Locale("be", "BY");
        Resouses res = new Resouses();
        res.greeting(loc2);
        res.greeting(loc1);
        res.greeting();


    /*public static void main(String[] args) {
        Resouses resouses= new Resouses();
        //Locale loc1 = new Locale("be", "BY");
        resouses.getInstans();
    }*/
    }
}