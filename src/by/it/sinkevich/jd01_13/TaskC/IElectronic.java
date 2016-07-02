package by.it.sinkevich.jd01_13.TaskC;

/**
 * @author Sinkevich Denis
 */
interface IElectronic {

    void turnOn() throws PlayerException;
    void turnOff() throws PlayerException;
    void play() throws PlayerException;
    void pause() throws PlayerException;
    boolean connectToOtherDevice(IElectronic device);
    void connectToInternet();
    boolean repair() throws PlayerException;
}
