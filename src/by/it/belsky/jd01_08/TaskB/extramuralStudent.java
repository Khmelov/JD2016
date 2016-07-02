package by.it.belsky.jd01_08.TaskB;

/**
 * Created by misha on 26.05.2016.
 */

public class extramuralStudent extends Student {
    @Override
    public int Groupnumber(int groupnumber) {
        return groupnumber;
    }

    public int Periodofstuding(int period) {
        return period;


    }

    @Override
    public int Age(int age) {
        return super.Age(age);
    }
}