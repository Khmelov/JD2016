package by.it.belsky.jd01_08.TaskA;

/**
 * Created by misha on 25.05.2016.
 */
public class Main {
    public static void main (String[] args) {
     extramuralStudent extra = new extramuralStudent();
        System.out.println(extra.getState());
        extra.takeTicket();
        System.out.println(extra.getState());
        extra.preparing();
        System.out.println(extra.getState());
        extra.receiving2();
        System.out.println(extra.getState());

    }
}
