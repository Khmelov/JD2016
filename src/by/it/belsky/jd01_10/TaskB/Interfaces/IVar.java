package by.it.belsky.jd01_10.TaskB.Interfaces;

/**
 * Created by misha on 01.06.2016.
 */
public interface IVar extends IMul, ISub, IDiv, IAdd {
    String toString();
    void setFrom(String str);
}
