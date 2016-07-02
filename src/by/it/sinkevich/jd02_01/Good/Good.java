package by.it.sinkevich.jd02_01.Good;

/**
 * Class for jd02_01
 *
 * @author Sinkevich Denis
 */
public class Good {

    private String name;
    private int price;

    Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " по цене " + price + " рублей";
    }
}
