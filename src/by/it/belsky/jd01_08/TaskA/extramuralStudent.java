package by.it.belsky.jd01_08.TaskA;

/**
 * Created by misha on 25.05.2016.
 */
public class extramuralStudent extends Student {

    @Override
    public String getState() {
        String state = "Студент вошел в кабинет";
        if (istakeTicket())
            state = "Студент тянет билет";
        if (ispreparing())
            state = "Студент готовится к ответу";
        if (isreceiveing2())
            state = "студент получает двойку";
        return state;
    }

}

