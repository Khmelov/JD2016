package by.it.belsky.jd01_08.TaskC;

/**
 * Created by misha on 26.05.2016.
 */
public class FullTimeStudent extends Student
{

    @Override
    public String getState() {

        String state = "Студент-oчник вошел в кабинет";
        if (istakeTicket())
            state = "Студент-очник тянет билет";
        if (ispreparing())
            state = "Студент-очник готовится к ответу";
        if (isreceiveing2())
            state = "студент-очник получает двойку";
        return state;
    }
}
