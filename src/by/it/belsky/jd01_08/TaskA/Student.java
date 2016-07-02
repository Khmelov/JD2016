package by.it.belsky.jd01_08.TaskA;

/**
 * Created by misha on 25.05.2016.
 */
public abstract class Student implements enrollee {
    private boolean ticket;
    private boolean prepare;
    private boolean receive;

    @Override
    public boolean takeTicket() {
        ticket = true;
        prepare = false;
        receive = false;
        return ticket;
    }

    @Override
    public boolean preparing() {
        prepare = true;
        ticket = false;
        receive = false;
        return prepare;
    }

    @Override
    public boolean receiving2() {
        prepare = false;
        ticket = false;
        receive = true;
        return receive;

    }

    public abstract String getState();

    public boolean istakeTicket() {
        return ticket;
    }

    public boolean ispreparing() {
        return prepare;
    }

    public boolean isreceiveing2() {
        return receive;
    }

}
