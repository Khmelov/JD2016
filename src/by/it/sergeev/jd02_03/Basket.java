package by.it.sergeev.jd02_03;

import java.util.Map;

/**
 * корзина
 */
public class Basket {

    private Map<String, Integer> goods;
    private int num;

    public Basket(Map<String, Integer> goods, int num){
        this.goods = goods;
        this.num = num;
    }

    public Map<String, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<String, Integer> goods) {
        this.goods = goods;
    }

    public int getNum() {
        return num;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Продукты в корзине: ");
        for (String s1 : goods.keySet()) {
            s.append(s1);
            s.append(" ");
        }
        return s.toString();
    }
}