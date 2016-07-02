package by.it.sinkevich.jd02_03.good;

/**
 * Class for jd02_03
 *
 * @author Sinkevich Denis
 */
public class Good {

    private String name;
    private double price;

    Good(String name) {
        this.name = name;
        price = Goods.getPriceOfGood(name);
    }

    @Override
    public String toString() {
        return name + " по цене " + price + " рублей";
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
