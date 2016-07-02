package by.it.novik.jd02_02.entities;

/**
 * Created by Kate Novik.
 */
public class Good {
    //Поле id товара
    private int idGood;
    //Поле название товара
    private String nameGood;
    //Поле производитель
    private String producer;

    public Good(int idGood, String nameGood, String producer) {
        this.idGood = idGood;
        this.nameGood = nameGood;
        this.producer = producer;
    }

    public void setNameGood(String nameGood) {
        this.nameGood = nameGood;
    }

    public String getNameGood() {
        return nameGood;
    }

    public void setIdGood(int idGood) {
        this.idGood = idGood;
    }

    public int getIdGood() {
        return idGood;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return nameGood;
    }
}
