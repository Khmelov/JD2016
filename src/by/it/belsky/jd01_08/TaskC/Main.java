package by.it.belsky.jd01_08.TaskC;

import by.it.belsky.jd01_08.TaskA.*;

/**
 * Created by misha on 26.05.2016.
 */
public class Main {
    public static void main(String[] args) {

        Student extra = new extramuralStudent();
        Student full = new FullTimeStudent();
        System.out.println(full.getState());
        System.out.println(extra.getState());
        full.takeTicket();
        extra.takeTicket();
        System.out.println(full.getState());
        System.out.println(extra.getState());
        full.preparing();
        extra.preparing();
        System.out.println(full.getState());
        System.out.println(extra.getState());
        full.receiving2();
        extra.receiving2();
        System.out.println(full.getState());
        System.out.println(extra.getState());

    }
}
