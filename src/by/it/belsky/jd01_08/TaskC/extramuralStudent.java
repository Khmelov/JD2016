package by.it.belsky.jd01_08.TaskC;

import by.it.belsky.jd01_08.TaskA.*;

/**
 * Created by misha on 26.05.2016.
 */
public class extramuralStudent extends Student {

    @Override
    public String getState() {

        String state = "Студент-заочник вошел в кабинет";
        if (istakeTicket())
            state = "Студент-заочник тянет билет";
        if (ispreparing())
            state = "Студент-заочник готовится к ответу";
        if (isreceiveing2())
            state = "студент-заочник получает двойку";
        return state;
    }

}